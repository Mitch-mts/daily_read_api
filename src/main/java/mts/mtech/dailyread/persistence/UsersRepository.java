package mts.mtech.dailyread.persistence;

import mts.mtech.dailyread.domain.Users;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Mitchell Tawanda Severa
 * @created 27/04/2022 - 9:24 PM
 */
@Repository
public interface UsersRepository extends BaseRepository<Users>,
    JpaSpecificationExecutor<Users> {

}
