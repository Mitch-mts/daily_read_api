package mts.mtech.dailyread.service.bibleverses;

import mts.mtech.dailyread.domain.DailyRead;

/**
 * @author Mitchell Tawanda Severa
 * @created 10/05/2022 - 10:31 PM
 */

public interface BibleVerseApiService {
  DailyRead getVerse(String url);
}
