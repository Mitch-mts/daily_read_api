package mts.mtech.dailyread.service.bibleverses;

import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.domain.enums.Status;
import mts.mtech.dailyread.persistence.DailyReadRepository;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 08/06/2022 - 9:39 PM
 */
@Service
@Slf4j
public class UpdateBibleVerseServiceImpl implements UpdateBibleVerseService{
  private final DailyReadRepository dailyReadRepository;

  public UpdateBibleVerseServiceImpl(DailyReadRepository dailyReadRepository) {
    this.dailyReadRepository = dailyReadRepository;
  }

  @Override
  public void updateBibleVerse() {
    var bibleVerses = dailyReadRepository.findAll();
    if(bibleVerses.size() > 0){
      bibleVerses.forEach(dailyRead -> dailyRead.setStatus(Status.INACTIVE));
      dailyReadRepository.saveAll(bibleVerses);
    }
  }
}
