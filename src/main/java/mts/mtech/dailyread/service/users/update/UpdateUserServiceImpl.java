package mts.mtech.dailyread.service.users.update;

import mts.mtech.dailyread.domain.UserAccount;
import mts.mtech.dailyread.persistence.UserAccountRepository;
import mts.mtech.dailyread.service.save.SaveUserService;
import mts.mtech.dailyread.service.users.UserRequest;
import mts.mtech.dailyread.utils.Constants;
import mts.mtech.errorhandling.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 16/05/2022 - 8:40 PM
 */
@Service
public class UpdateUserServiceImpl implements UpdateUserService{
  private final UserAccountRepository userAccountRepository;
  private final SaveUserService saveUserService;

  public UpdateUserServiceImpl(UserAccountRepository userAccountRepository,
      SaveUserService saveUserService) {
    this.userAccountRepository = userAccountRepository;
    this.saveUserService = saveUserService;
  }

  @Override
  public UserAccount updateUser(UserRequest userRequest, Long id) {
    var users = userAccountRepository.findById(id)
        .orElseThrow(()-> new RecordNotFoundException(Constants.NOT_FOUND));
    users.setEmail(userRequest.getEmail());
    users.setFirstname(userRequest.getFirstname());
    users.setLastname(userRequest.getLastname());
    return saveUserService.save(users);
  }
}
