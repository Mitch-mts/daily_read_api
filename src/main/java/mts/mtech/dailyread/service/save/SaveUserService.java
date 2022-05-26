package mts.mtech.dailyread.service.save;

import mts.mtech.dailyread.domain.UserAccount;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:43 PM
 */

public interface SaveUserService {
  UserAccount save(UserAccount userAccount);
}
