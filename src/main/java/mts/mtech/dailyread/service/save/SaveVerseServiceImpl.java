package mts.mtech.dailyread.service.save;

import mts.mtech.dailyread.domain.DailyRead;
import mts.mtech.dailyread.persistence.DailyReadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 03/04/2022 - 1:36 PM
 */
@Service
public class SaveVerseServiceImpl implements SaveVerseService{
  private final Logger logger = LoggerFactory.getLogger(SaveVerseServiceImpl.class);
  private final DailyReadRepository dailyReadRepository;

  public SaveVerseServiceImpl(
      DailyReadRepository dailyReadRepository) {
    this.dailyReadRepository = dailyReadRepository;
  }

  @Override
  public DailyRead save(DailyRead dailyRead) {
    return dailyReadRepository.save(dailyRead);
  }
}
