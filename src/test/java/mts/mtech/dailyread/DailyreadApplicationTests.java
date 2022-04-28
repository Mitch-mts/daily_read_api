package mts.mtech.dailyread;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import mts.mtech.dailyread.domain.DailyRead;
import mts.mtech.dailyread.exceptions.SystemErrorException;
import mts.mtech.dailyread.persistence.DailyReadRepository;
import mts.mtech.dailyread.service.bibleverses.DailyReadServiceImpl;
import mts.mtech.dailyread.service.save.SaveVerseService;
import mts.mtech.dailyread.service.save.SaveVerseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DailyreadApplicationTests {

	@Mock
	DailyReadRepository dailyReadRepository;
	SaveVerseServiceImpl underTest1;
	SaveVerseService saveVerseService;
	DailyReadServiceImpl underTest;

	@BeforeEach
	void setUp() {
		underTest = new DailyReadServiceImpl(saveVerseService);
		underTest1 = new SaveVerseServiceImpl(dailyReadRepository);
	}

	@Test
	@DisplayName("should save bible verse")
	void shouldSaveBibleVerse() {
		// given
		DailyRead dailyRead = DailyRead.builder()
																		.verse("Jesus wept")
																		.testament("New Testament")
																		.chapter("35")
																		.number("5")
																		.dateCreated(LocalDate.now())
																		.build();
		// when
		underTest1.save(dailyRead);

		// then
		ArgumentCaptor<DailyRead> dailyReadArgumentCaptor = ArgumentCaptor.forClass(DailyRead.class);
		verify(dailyReadRepository).save(dailyReadArgumentCaptor.capture());

		DailyRead capturedDailyRead = dailyReadArgumentCaptor.getValue();
		assertThat(capturedDailyRead).isEqualTo(dailyRead);
	}

	@Test
	@DisplayName("will throw exception when failed to get random verse")
	void willThrowExceptionWhenFailedToGetRandomVerse() {
		// then
		assertThatThrownBy(() -> underTest.getRandomVerse())
				.isInstanceOf(SystemErrorException.class)
				.hasMessageContaining("Bible Verse service unavailable at the moment");
	}

	@Test
	@DisplayName("will throw exception when failed to get daily verse")
	void willThrowExceptionWhenFailedToGetDailyVerse() {
		// then
		assertThatThrownBy(() -> underTest.getDailyVerse())
				.isInstanceOf(SystemErrorException.class)
				.hasMessageContaining("Bible Verse service unavailable at the moment");
	}
}
