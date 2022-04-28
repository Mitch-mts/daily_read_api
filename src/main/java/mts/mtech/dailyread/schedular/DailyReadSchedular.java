package mts.mtech.dailyread.schedular;

import mts.mtech.dailyread.service.bibleverses.DailyReadService;
import mts.mtech.dailyread.service.email.EmailRequest;
import mts.mtech.dailyread.service.email.EmailService;
import mts.mtech.dailyread.service.users.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:10 PM
 */
@Component
public class DailyReadSchedular {
  private final Logger logger = LoggerFactory.getLogger(DailyReadSchedular.class);
  private final DailyReadService dailyReadService;
  private final UserService userService;
  private final EmailService emailService;

  public DailyReadSchedular(DailyReadService dailyReadService,
      UserService userService, EmailService emailService) {
    this.dailyReadService = dailyReadService;
    this.userService = userService;
    this.emailService = emailService;
  }

  @Scheduled(cron = "0 0 6,12,20 ? * * *")
  public void sendDailyBibleReading(){
    userService.getUserList().stream().forEach(users -> {
      EmailRequest emailRequest = EmailRequest.builder()
          .email(users.getEmail())
          .firstname(users.getFirstname())
          .lastname(users.getLastname())
          .dailyRead(dailyReadService.getDailyVerse())
          .build();
      emailService.sendEmail(emailRequest);
    });
  }

}
