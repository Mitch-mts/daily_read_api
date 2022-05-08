package mts.mtech.dailyread.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Mitchell T Severa
 * 9/4/2018
 * 11:52 AM
 */

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Long> {
}
