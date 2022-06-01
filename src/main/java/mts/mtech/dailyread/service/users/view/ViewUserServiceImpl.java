package mts.mtech.dailyread.service.users.view;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.domain.UserAccount;
import mts.mtech.dailyread.domain.enums.Status;
import mts.mtech.dailyread.persistence.UserAccountRepository;
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
@Slf4j
public class ViewUserServiceImpl implements ViewUserService {
  private final UserAccountRepository userAccountRepository;

  public ViewUserServiceImpl(UserAccountRepository userAccountRepository) {
    this.userAccountRepository = userAccountRepository;
  }

  @Override
  public UserAccount getUserById(Long id) {
    return userAccountRepository.findUserAccountByIdAndStatus(id, Status.ACTIVE)
        .orElseThrow(()-> new RecordNotFoundException(Constants.NOT_FOUND));
  }

  @Override
  public List<UserAccount> getUserList() {
    try{
      return userAccountRepository.findAll()
          .stream()
          .filter(users -> users.getStatus().equals(Status.ACTIVE))
          .collect(Collectors.toList());
    }catch (Exception e){
      throw new RecordNotFoundException(Constants.NOT_RECORDS);
    }
  }

  @Override
  public Page<UserAccount> getAllUsers(Pageable pageable) {
    try{
      return userAccountRepository.findAllByStatus(Status.ACTIVE, pageable);
    }catch (Exception e){
      log.warn("warning:{}", e.getMessage());
      throw new RecordNotFoundException(Constants.NOT_FOUND);
    }
  }

}
