package mts.mtech.dailyread.service.users;

import java.time.LocalDate;
import java.util.List;
import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.domain.enums.Status;
import mts.mtech.dailyread.exceptions.InvalidRequestException;
import mts.mtech.dailyread.exceptions.RecordNotFoundException;
import mts.mtech.dailyread.persistence.UsersRepository;
import mts.mtech.dailyread.service.save.SaveUserService;
import mts.mtech.dailyread.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:45 PM
 */
@Service
public class UserServiceImpl implements UserService{
  private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
  private final UsersRepository usersRepository;
  private final SaveUserService saveUserService;

  public UserServiceImpl(UsersRepository usersRepository,
      SaveUserService saveUserService) {
    this.usersRepository = usersRepository;
    this.saveUserService = saveUserService;
  }


  @Override
  public Users createUser(UserRequest userRequest) {
    Users users = Users.builder()
                        .firstname(userRequest.getFirstname())
                        .lastname(userRequest.getLastname())
                        .email(userRequest.getEmail())
                        .dateCreated(LocalDate.now())
                        .build();
    return saveUserService.save(users);
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

  @Override
  public Users deleteUser(Long id) {
    var user = usersRepository.findById(id)
        .orElseThrow(()-> new RecordNotFoundException(Constants.NOT_FOUND));
    user.setStatus(Status.INACTIVE);
    return saveUserService.save(user);
  }

  @Override
  public Users getUserById(Long id) {
    return usersRepository.findById(id)
        .orElseThrow(()-> new InvalidRequestException(Constants.NOT_FOUND));
  }

  @Override
  public List<Users> getUserList() {
    return usersRepository.findAll();
  }

  @Override
  public Page<Users> getAllUsers(Pageable pageable) {
    return usersRepository.findAll(pageable);
  }
}
