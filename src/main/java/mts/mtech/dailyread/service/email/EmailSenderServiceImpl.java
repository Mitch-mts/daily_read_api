package mts.mtech.dailyread.service.email;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import mts.mtech.errorhandling.exception.SystemErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Mitchell Tawanda Severa
 * @created 06/11/2020 - 10:16 PM
 */
@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    private final Logger logger = LoggerFactory.getLogger(EmailSenderServiceImpl.class);
    private final JavaMailSender emailSender;
    private final Configuration freemarkerConfiguration;
    public static final String EMAIL_TEMPLATE_NAME = "email-template.ftl";

    @Autowired
    public EmailSenderServiceImpl(JavaMailSender emailSender, Configuration freemarkerConfiguration) {
        this.emailSender = emailSender;
        this.freemarkerConfiguration = freemarkerConfiguration;
    }

    @Override
    public void sendNotification(Notification notification) {
        logger.info("Sending email notification: {}", notification);
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = getMimeMessageHelper(message);
        var bcc = notification.getBcc().stream().toArray(String[]::new);
        var cc = notification.getCc().stream().toArray(String[]::new);
        var recipients = notification.getRecipients().stream().toArray(String[]::new);
        var htmlMessage = convertPlainTextToHtml(notification);
        prepareEmailMessage(mimeMessageHelper, recipients, notification.getSubject(), htmlMessage, cc, bcc,
                notification.getSentBy(), notification.getSentByPersonal());
        if (notification.getAttachments().size() > 0) {
            attachFiles(mimeMessageHelper, notification.getAttachments());
        }
        logger.info("email Message: {}", message);
        emailSender.send(message);
    }

    private MimeMessageHelper getMimeMessageHelper(MimeMessage mimeMessage) {
        try {
            return new MimeMessageHelper(mimeMessage, true);
        } catch (MessagingException e) {
            throw new SystemErrorException(e.getMessage());
        }
    }


    private String convertPlainTextToHtml(Notification notification) {
        Template template = getTemplate();
        try {
            return FreeMarkerTemplateUtils.processTemplateIntoString(template, getModel(notification));
        } catch (IOException | TemplateException e) {
            throw new SystemErrorException(e.getMessage());
        }

    }

    private void prepareEmailMessage(MimeMessageHelper mimeMessageHelper, String[] recipients, String subject,
                                     String emailBody, String[] cc, String[] bcc, String from, String fromPersonal) {
        try {
            mimeMessageHelper.setTo(recipients);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setCc(cc);
            mimeMessageHelper.setBcc(bcc);
            if (Objects.nonNull(from) && Objects.nonNull(fromPersonal)) {
                mimeMessageHelper.setFrom(from, fromPersonal);
            } else if (Objects.nonNull(from)) {
                mimeMessageHelper.setFrom(from);
            }
            mimeMessageHelper.setText(emailBody, true);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new SystemErrorException(e.getMessage());
        }

    }

    private Template getTemplate() {
        try {
            return freemarkerConfiguration.getTemplate(EMAIL_TEMPLATE_NAME);
        } catch (IOException e) {
            throw new SystemErrorException(e.getMessage());
        }
    }

    private void attachFiles(MimeMessageHelper mimeMessageHelper, List<MultipartFile> multipartFiles) {
        multipartFiles.forEach(multipartFile -> {
            try {
                mimeMessageHelper.addAttachment(multipartFile.getName(), multipartFile);
            } catch (MessagingException e) {
                throw new SystemErrorException(e.getMessage());
            }
        });
    }

    private Map<String, Object> getModel(Notification notification) {
        Map<String, Object> model = new HashMap<>();
        model.put("message", notification.getBody());
        model.put("year", LocalDateTime.now().getYear() + "");
        return model;
    }
}
