package mts.mtech.dailyread.service.users.view;

import java.util.List;
import java.util.stream.Collectors;
import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.domain.enums.Status;
import mts.mtech.dailyread.persistence.UsersRepository;
import mts.mtech.dailyread.utils.Constants;
import mts.mtech.errorhandling.exception.RecordNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 16/05/2022 - 8:42 PM
 */
@Service
public class ViewUserServiceImpl implements ViewUserService {
  private final UsersRepository usersRepository;

  public ViewUserServiceImpl(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  @Override
  public Users getUserById(Long id) {
    return usersRepository.findByIdAndStatus(id, Status.ACTIVE)
        .orElseThrow(()-> new RecordNotFoundException(Constants.NOT_FOUND));
  }

  @Override
  public List<Users> getUserList() {
    try{
      return usersRepository.findAll()
          .stream()
          .filter(users -> users.getStatus().equals(Status.ACTIVE))
          .collect(Collectors.toList());
    }catch (Exception e){
      throw new RecordNotFoundException(Constants.NOT_RECORDS);
    }
  }

  @Override
  public Page<Users> getAllUsers(Pageable pageable) {
    return usersRepository.findAll(pageable);
  }

}
