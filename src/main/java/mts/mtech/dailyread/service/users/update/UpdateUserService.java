package mts.mtech.dailyread.service.users.update;

import mts.mtech.dailyread.domain.UserAccount;
import mts.mtech.dailyread.service.users.UserRequest;

/**
 * @author Mitchell Tawanda Severa
 * @created 16/05/2022 - 8:40 PM
 */

public interface UpdateUserService {
  UserAccount updateUser(UserRequest userRequest, Long id);
}
