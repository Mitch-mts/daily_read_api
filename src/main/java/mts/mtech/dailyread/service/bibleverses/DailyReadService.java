package mts.mtech.dailyread.service.bibleverses;

import mts.mtech.dailyread.domain.DailyRead;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 8:44 PM
 */

public interface DailyReadService {
  DailyRead getDailyVerse();
  DailyRead getRandomVerse();
  DailyRead getBibleVerse();
}
