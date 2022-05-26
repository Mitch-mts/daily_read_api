package mts.mtech.dailyread.service.users.view;

import java.util.List;
import mts.mtech.dailyread.domain.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mitchell Tawanda Severa
 * @created 16/05/2022 - 8:41 PM
 */

public interface ViewUserService {
  Users getUserById(Long id);
  List<Users> getUserList();
  Page<Users> getAllUsers(Pageable pageable);
}
