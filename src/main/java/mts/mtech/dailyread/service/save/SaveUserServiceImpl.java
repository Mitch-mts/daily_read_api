package mts.mtech.dailyread.service.save;

import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.persistence.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:44 PM
 */
@Service
public class SaveUserServiceImpl implements SaveUserService{
  private Logger logger = LoggerFactory.getLogger(SaveUserServiceImpl.class);
  private final UsersRepository usersRepository;

  public SaveUserServiceImpl(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Override
  public Users save(Users users) {
    return usersRepository.save(users);
  }
}
