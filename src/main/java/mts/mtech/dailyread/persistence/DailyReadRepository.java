package mts.mtech.dailyread.persistence;

import mts.mtech.dailyread.domain.DailyRead;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 9:00 PM
 */
@Repository
public interface DailyReadRepository extends BaseRepository<DailyRead>,
    JpaSpecificationExecutor<DailyRead> {

}