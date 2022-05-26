package mts.mtech.dailyread.service.users.update;

import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.persistence.UsersRepository;
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
  private final UsersRepository usersRepository;
  private final SaveUserService saveUserService;

  public UpdateUserServiceImpl(UsersRepository usersRepository,
      SaveUserService saveUserService) {
    this.usersRepository = usersRepository;
    this.saveUserService = saveUserService;
  }

  @Override
  public Users updateUser(UserRequest userRequest, Long id) {
    var users = usersRepository.findById(id)
        .orElseThrow(()-> new RecordNotFoundException(Constants.NOT_FOUND));
    users.setEmail(userRequest.getEmail());
    users.setFirstname(userRequest.getFirstname());
    users.setLastname(userRequest.getLastname());
    return saveUserService.save(users);
  }
}
