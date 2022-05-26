package mts.mtech.dailyread.service.save;

import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.persistence.UsersRepository;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:44 PM
 */
@Service
public class SaveUserServiceImpl implements SaveUserService{
  private final UsersRepository usersRepository;

  public SaveUserServiceImpl(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Override
  public Users save(Users users) {
    return usersRepository.save(users);
  }
}
