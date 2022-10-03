package mts.mtech.dailyread.service.users;

import mts.mtech.dailyread.domain.UserAccount;
import mts.mtech.dailyread.domain.enums.Status;
import mts.mtech.dailyread.exception.RecordNotFoundException;
import mts.mtech.dailyread.persistence.UserAccountRepository;
import mts.mtech.dailyread.service.save.useraccounts.SaveUserService;
import mts.mtech.dailyread.utils.Constants;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:45 PM
 */
@Service
public class UserServiceImpl implements UserService{
  private final UserAccountRepository userAccountRepository;
  private final SaveUserService saveUserService;

  public UserServiceImpl(UserAccountRepository userAccountRepository,
      SaveUserService saveUserService) {
    this.userAccountRepository = userAccountRepository;
    this.saveUserService = saveUserService;
  }

  @Override
  public UserAccount deleteUser(Long id) {
    var user = userAccountRepository.findById(id)
        .orElseThrow(()-> new RecordNotFoundException(Constants.NOT_FOUND));
    user.setStatus(Status.INACTIVE);
    return saveUserService.save(user);
  }


  @Override
  public UserAccount activateDeactivateUser(Long id) {
    UserAccount userAccount = userAccountRepository.findById(id)
        .orElseThrow(()-> new RecordNotFoundException(Constants.NOT_FOUND));
    switch (userAccount.getStatus()){
      case ACTIVE:
        userAccount.setStatus(Status.SUSPENDED);
        break;
      case BLOCKED:
      case SUSPENDED:
        userAccount.setStatus(Status.ACTIVE);
        break;
    }
    return userAccountRepository.save(userAccount);
  }
}
