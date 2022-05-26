package mts.mtech.dailyread.service.users;

import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.domain.enums.Status;
import mts.mtech.dailyread.persistence.UsersRepository;
import mts.mtech.dailyread.service.save.SaveUserService;
import mts.mtech.dailyread.utils.Constants;
import mts.mtech.errorhandling.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:45 PM
 */
@Service
public class UserServiceImpl implements UserService{
  private final UsersRepository usersRepository;
  private final SaveUserService saveUserService;

  public UserServiceImpl(UsersRepository usersRepository,
      SaveUserService saveUserService) {
    this.usersRepository = usersRepository;
    this.saveUserService = saveUserService;
  }

  @Override
  public Users deleteUser(Long id) {
    var user = usersRepository.findById(id)
        .orElseThrow(()-> new RecordNotFoundException(Constants.NOT_FOUND));
    user.setStatus(Status.INACTIVE);
    return saveUserService.save(user);
  }


  @Override
  public Users activateDeactivateUser(Long id) {
    Users users = usersRepository.findById(id)
        .orElseThrow(()-> new RecordNotFoundException(Constants.NOT_FOUND));
    switch (users.getStatus()){
      case ACTIVE:
        users.setStatus(Status.SUSPENDED);
        break;
      case BLOCKED:
      case SUSPENDED:
        users.setStatus(Status.ACTIVE);
        break;
    }
    return usersRepository.save(users);
  }
}
