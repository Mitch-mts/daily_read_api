package mts.mtech.dailyread.service.users;

import mts.mtech.dailyread.domain.UserAccount;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:26 PM
 */

public interface UserService {
  UserAccount deleteUser(Long id);
  UserAccount activateDeactivateUser(Long id);
}
