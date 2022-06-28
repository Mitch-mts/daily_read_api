package mts.mtech.dailyread.service.bibleverses;

import mts.mtech.dailyread.domain.DailyRead;
import mts.mtech.dailyread.domain.enums.Status;
import mts.mtech.dailyread.persistence.DailyReadRepository;
import mts.mtech.dailyread.utils.Constants;
import mts.mtech.errorhandling.exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 8:45 PM
 */
@Service
public class DailyReadServiceImpl implements DailyReadService{
  private final BibleVerseApiService bibleVerseApiService;
  private final DailyReadRepository dailyReadRepository;

  @Value("${daily-read.daily-verse}")
  String verseOfTheDay;
  @Value("${daily-read.random-verse}")
  String randomVerse;

  public DailyReadServiceImpl(BibleVerseApiService bibleVerseApiService,
      DailyReadRepository dailyReadRepository) {
    this.bibleVerseApiService = bibleVerseApiService;
    this.dailyReadRepository = dailyReadRepository;
  }

  @Override
  public DailyRead getDailyVerse() {
    return bibleVerseApiService.getVerse(verseOfTheDay);
  }

  @Override
  public DailyRead getRandomVerse() {
    return bibleVerseApiService.getVerse(randomVerse);
  }

  @Override
  public DailyRead getBibleVerse() {
    return dailyReadRepository.findByStatus(Status.ACTIVE)
        .orElseThrow(()-> new RecordNotFoundException(Constants.NO_READING));
  }

}
