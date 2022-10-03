package mts.mtech.dailyread.service.users.create;

import mts.mtech.dailyread.domain.UserAccount;
import mts.mtech.dailyread.domain.enums.Status;
import mts.mtech.dailyread.exception.InvalidRequestException;
import mts.mtech.dailyread.persistence.UserAccountRepository;
import mts.mtech.dailyread.service.save.useraccounts.SaveUserService;
import mts.mtech.dailyread.service.users.UserRequest;
import mts.mtech.dailyread.utils.Constants;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author Mitchell Tawanda Severa
 * @created 16/05/2022 - 8:39 PM
 */
@Service
public class CreateUserServiceImpl implements CreateUserService{
  private final UserAccountRepository userAccountRepository;
  private final SaveUserService saveUserService;

  public CreateUserServiceImpl(UserAccountRepository userAccountRepository,
      SaveUserService saveUserService) {
    this.userAccountRepository = userAccountRepository;
    this.saveUserService = saveUserService;
  }

  @Override
  public UserAccount createUser(UserRequest userRequest) {
    if(userAccountRepository.existsByEmail(userRequest.getEmail()))
      throw new InvalidRequestException(Constants.EMAIL_EXISTS);

    UserAccount userAccount = UserAccount.builder()
        .firstname(userRequest.getFirstname())
        .lastname(userRequest.getLastname())
        .email(userRequest.getEmail())
        .dateCreated(LocalDate.now())
        .status(Status.ACTIVE)
        .build();
    return saveUserService.save(userAccount);
  }

}
