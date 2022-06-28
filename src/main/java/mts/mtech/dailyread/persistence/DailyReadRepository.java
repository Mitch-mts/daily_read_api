package mts.mtech.dailyread.persistence;

import java.util.Optional;
import mts.mtech.dailyread.domain.DailyRead;
import mts.mtech.dailyread.domain.enums.Status;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 9:00 PM
 */
@Repository
public interface DailyReadRepository extends BaseRepository<DailyRead>,
    JpaSpecificationExecutor<DailyRead>, PagingAndSortingRepository<DailyRead, Long> {

  Optional<DailyRead> findByStatus(Status status);
}