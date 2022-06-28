package mts.mtech.dailyread.service.bibleverses;

import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.domain.DailyRead;
import org.springframework.stereotype.Service;

/**
 * @author Mitchell Tawanda Severa
 * @created 08/06/2022 - 9:52 PM
 */
@Service
@Slf4j
public class GetBibleVerseServiceImpl implements GetBibleVerseService{
  private final UpdateBibleVerseService updateBibleVerseService;

  public GetBibleVerseServiceImpl(
      UpdateBibleVerseService updateBibleVerseService) {
    this.updateBibleVerseService = updateBibleVerseService;
  }

  @Override
  public DailyRead getBibleVerse() {
    updateBibleVerseService.updateBibleVerse();
    return null;
  }
}
