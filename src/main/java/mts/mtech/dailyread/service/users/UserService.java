package mts.mtech.dailyread.service.users;

import mts.mtech.dailyread.domain.Users;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:26 PM
 */

public interface UserService {
  Users deleteUser(Long id);
  Users activateDeactivateUser(Long id);
}
