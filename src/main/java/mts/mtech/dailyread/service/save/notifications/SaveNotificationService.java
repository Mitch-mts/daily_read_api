package mts.mtech.dailyread.service.save.notifications;

import mts.mtech.dailyread.domain.Notifications;

/**
 * @author Mitchell Tawanda Severa
 * @created 08/06/2022 - 10:48 PM
 */
@FunctionalInterface
public interface SaveNotificationService {
  void save(Notifications notifications);
}
