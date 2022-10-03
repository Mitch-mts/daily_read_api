package mts.mtech.dailyread.service.email;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.exception.SystemErrorException;
import mts.mtech.dailyread.service.save.notifications.SaveNotificationService;
import mts.mtech.dailyread.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Mitchell Tawanda Severa
 * @created 06/11/2020 - 10:16 PM
 */
@Service
@Slf4j
public class EmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender javaMailSender;
    private final Configuration freemarkerConfiguration;
    private final SaveNotificationService notificationService;
    public static final String EMAIL_TEMPLATE_NAME = "email-template.ftl";

    @Value("${spring.mail.host}")
    private String emailHost;
    @Value("${spring.mail.port}")
    private String emailPort;
    @Value("${spring.mail.username}")
    private String emailUsername;
    @Value("${spring.mail.password}")
    private String emailPassword;

    @Autowired
    public EmailSenderServiceImpl(JavaMailSender javaMailSender,
        Configuration freemarkerConfiguration,
        SaveNotificationService notificationService) {
        this.javaMailSender = javaMailSender;
        this.freemarkerConfiguration = freemarkerConfiguration;
        this.notificationService = notificationService;
    }



    @Override
    public void sendNotification(Notification notification) {
        log.info("Sending email notification: {}", notification);
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = getMimeMessageHelper(message);
        var recipients = notification.getRecipients();
        var htmlMessage = convertPlainTextToHtml(notification);

        prepareEmailMessage(mimeMessageHelper, recipients, notification.getSubject(), htmlMessage,
                notification.getSentBy(), notification.getSentByPersonal());

        log.info("email Message: {}", message);
        javaMailSender.send(message);
    }

    @Override
    public void sendEmailNotification(Notification notification) {
        SimpleMailMessage mail = new SimpleMailMessage();
        log.info("sending email out to subscribers");

        try{
            String sendTo = "";
            Map<String, Object> model = new HashMap<>();
            model.put("message", notification.getBody());
            model.put("year", LocalDate.now().getYear());

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());
            mail.setFrom(notification.getSentBy());
            mail.setSentDate(new Date());
            mail.setSubject(notification.getSubject());
            Template template = freemarkerConfiguration.getTemplate(EMAIL_TEMPLATE_NAME);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setTo(notification.getRecipients());
            helper.setText(html,true);
            helper.setSubject(notification.getSubject());
            helper.setFrom(notification.getSentBy());

            javaMailSender.send(message);
//            notificationService.save(notification);
        }catch (Exception e){
            log.error("error message: {}", e.getMessage());
        }
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

    private void prepareEmailMessage(MimeMessageHelper mimeMessageHelper, String recipients, String subject,
                                     String emailBody, String from, String fromPersonal) {
        try {
            Properties prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", emailHost);
            prop.put("mail.smtp.port", emailPort);
            prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
            prop.put("mail.mime.address.strict", "false");
            log.info("prop: {}", prop);

            Session session = Session.getInstance(prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailUsername, emailPassword);
                }
            });
            log.info("recipients: {}",recipients);
            Message message = new MimeMessage(session);
            log.info("message: {}", message);
            message.setFrom(new InternetAddress(Constants.FROM_PERSONAL));
            message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse(recipients.trim()));
            message.setSubject(Constants.BIBLE_READING);

            log.info("message: {}", message);
            mimeMessageHelper.setTo(recipients);
            mimeMessageHelper.setSubject(subject);
            if (Objects.nonNull(from) && Objects.nonNull(fromPersonal)) {
                mimeMessageHelper.setFrom(from, fromPersonal);
            } else if (Objects.nonNull(from)) {
                mimeMessageHelper.setFrom(from);
            }
            mimeMessageHelper.setText(emailBody, true);
            log.info("mimeMessageHelper: {}", mimeMessageHelper);
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
