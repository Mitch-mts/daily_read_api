package mts.mtech.dailyread.service.users.update;

import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.service.users.UserRequest;

/**
 * @author Mitchell Tawanda Severa
 * @created 16/05/2022 - 8:40 PM
 */

public interface UpdateUserService {
  Users updateUser(UserRequest userRequest, Long id);
}
