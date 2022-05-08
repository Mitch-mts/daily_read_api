package mts.mtech.dailyread.persistence;

import java.util.Optional;
import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.domain.enums.Status;
import org.springframework.stereotype.Repository;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:24 PM
 */
@Repository
public interface UsersRepository extends BaseRepository<Users>{
  boolean existsByEmail(String email);
  Optional<Users> findByIdAndStatus(Long id, Status status);
}
