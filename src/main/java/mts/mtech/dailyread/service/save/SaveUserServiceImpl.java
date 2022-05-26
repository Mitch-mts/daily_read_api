package mts.mtech.dailyread.service.save;

import mts.mtech.dailyread.domain.UserAccount;
import mts.mtech.dailyread.persistence.UserAccountRepository;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:44 PM
 */
@Service
public class SaveUserServiceImpl implements SaveUserService{
  private final UserAccountRepository userAccountRepository;

  public SaveUserServiceImpl(UserAccountRepository userAccountRepository) {
    this.userAccountRepository = userAccountRepository;
  }

  @Override
  public UserAccount save(UserAccount userAccount) {
    return userAccountRepository.save(userAccount);
  }
}
