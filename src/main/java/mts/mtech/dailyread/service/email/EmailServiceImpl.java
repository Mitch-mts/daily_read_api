package mts.mtech.dailyread.service.email;

import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.utils.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/11/2020 - 7:12 PM
 */
@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    private final EmailSenderService emailSenderService;

    @Value("${spring.mail.username}")
    private String emailSender;
    @Value("${spring.mail.host}")
    private String emailHost;
    @Value("${spring.mail.port}")
    private String emailPort;
    @Value("${spring.mail.username}")
    private String emailUsername;
    @Value("${spring.mail.password}")
    private String emailPassword;


    public EmailServiceImpl(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }


    @Override
    public void sendEmail(EmailRequest emailRequest) {
        log.info("Sending email {}", emailRequest);
        String emailBody;
        String name = emailRequest.getFirstname() + " " + emailRequest.getLastname();

        emailBody = "Hi " + name
                + "\nToday's bible reading comes from \n"
                + emailRequest.getDailyRead().getBook() + " \n chapter " + emailRequest.getDailyRead().getChapter()
         + " \n verse " + emailRequest.getDailyRead().getVerse() + " \n it reads \n" + emailRequest.getDailyRead().getReading();

        log.info("emailBody: {}", emailBody);

        Notification notification = Notification.builder()
                                                .body(emailBody)
                                                .medium(Medium.EMAIL)
                                                .subject(Constants.BIBLE_READING)
                                                .sentBy(emailSender)
                                                .sentByPersonal(Constants.FROM_PERSONAL)
                                                .recipients(emailRequest.getEmail())
                                                .build();
        log.info("notification: {}", notification);
        emailSenderService.sendEmailNotification(notification);
    }
//    @Override
//    public void sendEmail(EmailRequest emailRequest) {
//        try {
//            Properties prop = new Properties();
//            prop.put("mail.smtp.auth", true);
//            prop.put("mail.smtp.starttls.enable", "true");
//            prop.put("mail.smtp.host", emailHost);
//            prop.put("mail.smtp.port", emailPort);
//            prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
//
//            Session session = Session.getInstance(prop, new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    return new PasswordAuthentication(emailUsername.trim(), emailPassword);
//                }
//            });
//
//            String name = emailRequest.getFirstname() + " " + emailRequest.getLastname();
//            String  emailBody = "Hi " + name
//                + "\nToday's bible reading comes from \n"
//                + emailRequest.getDailyRead().getBook() + " \n chapter " + emailRequest.getDailyRead().getChapter()
//         + " \n verse " + emailRequest.getDailyRead().getVerse() + " \n it reads \n" + emailRequest.getDailyRead().getReading();
//
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(Constants.FROM_PERSONAL));
//            message.setRecipients(
//                Message.RecipientType.TO, InternetAddress.parse(emailRequest.getEmail().trim()));
//            message.setSubject(Constants.BIBLE_READING);
//
//            MimeBodyPart mimeBodyPart = new MimeBodyPart();
//            mimeBodyPart.setContent(emailBody, "text/html");
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(mimeBodyPart);
//
//            message.setContent(multipart);
//
//            Transport.send(message);
//        } catch (Exception e) {
//            logger.error("Failed to method email: {}", e.getMessage());
//        }
//    }

}
