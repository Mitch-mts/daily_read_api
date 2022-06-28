package mts.mtech.dailyread.persistence;

import java.util.Optional;
import mts.mtech.dailyread.domain.UserAccount;
import mts.mtech.dailyread.domain.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:24 PM
 */
@Repository
public interface UserAccountRepository extends BaseRepository<UserAccount>,
    JpaSpecificationExecutor<UserAccount>, PagingAndSortingRepository<UserAccount, Long> {
  boolean existsByEmail(String email);
  Optional<UserAccount> findUserAccountByIdAndStatus(Long id, Status status);
  Page<UserAccount> findAllByStatus(Status status, Pageable pageable);
}
