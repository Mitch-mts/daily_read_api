package mts.mtech.dailyread.service.bibleverses;

import mts.mtech.dailyread.domain.DailyRead;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 8:45 PM
 */
@Service
public class DailyReadServiceImpl implements DailyReadService{
  private final BibleVerseApiService bibleVerseApiService;

  @Value("${daily-read.daily-verse}")
  String verseOfTheDay;
  @Value("${daily-read.random-verse}")
  String randomVerse;

  public DailyReadServiceImpl(BibleVerseApiService bibleVerseApiService) {
    this.bibleVerseApiService = bibleVerseApiService;
  }

  @Override
  public DailyRead getDailyVerse() {
    return bibleVerseApiService.getVerse(verseOfTheDay);
  }

  @Override
  public DailyRead getRandomVerse() {
    return bibleVerseApiService.getVerse(randomVerse);
  }

}
