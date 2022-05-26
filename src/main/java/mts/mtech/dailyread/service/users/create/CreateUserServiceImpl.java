package mts.mtech.dailyread.service.users.create;

import java.time.LocalDate;
import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.domain.enums.Status;
import mts.mtech.dailyread.persistence.UsersRepository;
import mts.mtech.dailyread.service.save.SaveUserService;
import mts.mtech.dailyread.service.users.UserRequest;
import mts.mtech.dailyread.utils.Constants;
import mts.mtech.errorhandling.exception.InvalidRequestException;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 16/05/2022 - 8:39 PM
 */
@Service
public class CreateUserServiceImpl implements CreateUserService{
  private final UsersRepository usersRepository;
  private final SaveUserService saveUserService;

  public CreateUserServiceImpl(UsersRepository usersRepository,
      SaveUserService saveUserService) {
    this.usersRepository = usersRepository;
    this.saveUserService = saveUserService;
  }

  @Override
  public Users createUser(UserRequest userRequest) {
    if(usersRepository.existsByEmail(userRequest.getEmail()))
      throw new InvalidRequestException(Constants.EMAIL_EXISTS);

    Users users = Users.builder()
        .firstname(userRequest.getFirstname())
        .lastname(userRequest.getLastname())
        .email(userRequest.getEmail())
        .dateCreated(LocalDate.now())
        .status(Status.ACTIVE)
        .build();
    return saveUserService.save(users);
  }

}
