package mts.mtech.dailyread.schedular;

import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.service.bibleverses.DailyReadService;
import mts.mtech.dailyread.service.email.EmailRequest;
import mts.mtech.dailyread.service.email.EmailService;
import mts.mtech.dailyread.service.users.view.ViewUserService;
import org.springframework.stereotype.Component;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:10 PM
 */
@Component
@Slf4j
public class DailyReadSchedular {
  private final DailyReadService dailyReadService;
  private final ViewUserService viewUserService;
  private final EmailService emailService;

  public DailyReadSchedular(DailyReadService dailyReadService,
      ViewUserService viewUserService, EmailService emailService) {
    this.dailyReadService = dailyReadService;
    this.viewUserService = viewUserService;
    this.emailService = emailService;
  }

//  @Scheduled(cron = "0 0 6,12,20 ? * * *")
//  @Scheduled(fixedDelay = 1000)
//  public void sendDailyBibleReading(){
//    log.info("sending daily bible reading");
//    viewUserService.getUserList().forEach(users -> {
//      EmailRequest emailRequest = EmailRequest.builder()
//                                  .email(users.getEmail())
//                                  .firstname(users.getFirstname())
//                                  .lastname(users.getLastname())
//                                  .dailyRead(dailyReadService.getDailyVerse())
//                                  .build();
//      emailService.sendEmail(emailRequest);
//    });
//  }

//  @Scheduled(fixedDelay = 2000)
  public void sendDailyBibleReading(){
    log.info("sending daily bible reading");
    viewUserService.getUserList().forEach(users -> {
      EmailRequest emailRequest = EmailRequest.builder()
                                  .email(users.getEmail())
                                  .firstname(users.getFirstname())
                                  .lastname(users.getLastname())
                                  .dailyRead(dailyReadService.getBibleVerse())
                                  .build();
      emailService.sendEmail(emailRequest);
    });
  }

}
