package mts.mtech.dailyread.service.save.notifications;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.domain.Notifications;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 08/06/2022 - 10:49 PM
 */
@Service
@Slf4j
public class SaveNotificationServiceImpl implements SaveNotificationService{

  @Override
  public void save(Notifications notifications) {
    Notifications notifications1 = Notifications.builder()
        .recipient(notifications.getRecipient())
        .message(notifications.getMessage())
        .localDate(LocalDateTime.now())
        .username(notifications.getUsername())
        .build();

  }
}
