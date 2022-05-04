package mts.mtech.dailyread.service.users;

import java.util.List;
import mts.mtech.dailyread.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:26 PM
 */

public interface UserService {
  Users createUser(UserRequest userRequest);
  Users updateUser(UserRequest userRequest, Long id);
  Users deleteUser(Long id);
  Users getUserById(Long id);
  List<Users> getUserList();
  Page<Users> getAllUsers(Pageable pageable);
  Users activateDeactivateUser(Long id);

}
