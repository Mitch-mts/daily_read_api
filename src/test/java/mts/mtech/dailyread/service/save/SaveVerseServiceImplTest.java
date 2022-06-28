package mts.mtech.dailyread.service.save;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import mts.mtech.dailyread.domain.DailyRead;
import mts.mtech.dailyread.persistence.DailyReadRepository;
import mts.mtech.dailyread.service.save.bibleverses.SaveVerseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Mitchell Tawanda Severa
 * @created 10/05/2022 - 10:41 PM
 */
@ExtendWith(MockitoExtension.class)
class SaveVerseServiceImplTest {
  @Mock
  DailyReadRepository dailyReadRepository;
  SaveVerseServiceImpl underTest;

  @BeforeEach
  void setUp() {
    underTest = new SaveVerseServiceImpl(dailyReadRepository);
  }

  @Test
  @DisplayName("should save bible verse")
  void shouldSaveBibleVerse() {
    // given
    DailyRead dailyRead = DailyRead.builder()
        .reading("Jesus wept")
        .testament("New Testament")
        .chapter("35")
        .verse("5")
        .dateCreated(LocalDate.now())
        .build();
    // when
    underTest.save(dailyRead);

    // then
    ArgumentCaptor<DailyRead> dailyReadArgumentCaptor = ArgumentCaptor.forClass(DailyRead.class);
    verify(dailyReadRepository).save(dailyReadArgumentCaptor.capture());

    DailyRead capturedDailyRead = dailyReadArgumentCaptor.getValue();
    assertThat(capturedDailyRead).isEqualTo(dailyRead);
  }

}