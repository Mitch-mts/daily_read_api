package mts.mtech.dailyread.service.email;

import java.util.Collections;
import java.util.HashSet;
import mts.mtech.dailyread.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/11/2020 - 7:12 PM
 */
@Service
public class EmailServiceImpl implements EmailService {
    private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
    private final EmailSenderService emailSenderService;

    @Value("${spring.mail.username}")
    private String emailSender;

    public EmailServiceImpl(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }


    @Override
    public void sendEmail(EmailRequest emailRequest) {
        logger.info("Sending email {}", emailRequest);
        String emailBody;
        String name = emailRequest.getFirstname() + " " + emailRequest.getLastname();

        emailBody = "Hi " + name
                + "Today's bible reading comes from \n"
                + emailRequest.getDailyRead().getBook() + " \n chapter " + emailRequest.getDailyRead().getChapter()
         + " \n verse " + emailRequest.getDailyRead().getVerse() + " \n it reads \n" + emailRequest.getDailyRead().getReading();

        Notification notification = Notification.builder()
                .setBody(emailBody)
                .setMedium(Medium.EMAIL)
                .setSubject(Constants.BIBLE_READING)
                .setFrom(emailSender)
                .setFromPersonal(Constants.FROM_PERSONAL)
                .setRecipients(new HashSet<>(Collections.singletonList(emailRequest.getEmail())))
                .build();
        emailSenderService.sendNotification(notification);
    }

}
