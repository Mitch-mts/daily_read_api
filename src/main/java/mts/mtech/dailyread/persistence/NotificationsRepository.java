package mts.mtech.dailyread.persistence;

import mts.mtech.dailyread.domain.Notifications;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mitchell Tawanda Severa
 * @created 08/06/2022 - 10:52 PM
 */
@Repository
public interface NotificationsRepository extends BaseRepository<Notifications>,
    JpaSpecificationExecutor<Notifications>, PagingAndSortingRepository<Notifications, Long> {

}
