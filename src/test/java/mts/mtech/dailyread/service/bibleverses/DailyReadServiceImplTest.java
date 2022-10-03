package mts.mtech.dailyread.service.bibleverses;

import mts.mtech.dailyread.exception.SystemErrorException;
import mts.mtech.dailyread.persistence.DailyReadRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Mitchell Tawanda Severa
 * @created 10/05/2022 - 10:38 PM
 */
@ExtendWith(MockitoExtension.class)
class DailyReadServiceImplTest {
  private DailyReadServiceImpl underTest;
  @Mock
  private BibleVerseApiService bibleVerseApiService;
  @Autowired
  private DailyReadRepository dailyReadRepository;

  @BeforeEach
  void setUp() {
    underTest = new DailyReadServiceImpl(bibleVerseApiService, dailyReadRepository);
  }


  @Test
  @Disabled
  @DisplayName("will throw exception when failed to get random verse")
  void willThrowExceptionWhenFailedToGetRandomVerse() {
    // then
    assertThatThrownBy(() -> underTest.getRandomVerse())
        .isInstanceOf(SystemErrorException.class)
        .hasMessageContaining("Bible Verse service unavailable at the moment");
  }

  @Test
  @Disabled
  @DisplayName("will throw exception when failed to get daily verse")
  void willThrowExceptionWhenFailedToGetDailyVerse() {
    // then
    assertThatThrownBy(() -> underTest.getDailyVerse())
        .isInstanceOf(SystemErrorException.class)
        .hasMessageContaining("Bible Verse service unavailable at the moment");
  }
}