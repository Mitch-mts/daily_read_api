package mts.mtech.dailyread.service.users.view;

import java.util.List;
import mts.mtech.dailyread.domain.UserAccount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Mitchell Tawanda Severa
 * @created 16/05/2022 - 8:41 PM
 */

public interface ViewUserService {
  UserAccount getUserById(Long id);
  List<UserAccount> getUserList();
  Page<UserAccount> getAllUsers(Pageable pageable);
}
