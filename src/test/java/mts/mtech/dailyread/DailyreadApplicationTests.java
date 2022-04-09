package mts.mtech.dailyread;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import mts.mtech.dailyread.domain.DailyRead;
import mts.mtech.dailyread.persistence.DailyReadRepository;
import mts.mtech.dailyread.service.DailyReadServiceImpl;
import mts.mtech.dailyread.service.SaveVerseService;
import mts.mtech.dailyread.service.SaveVerseServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
	@DisplayName("should save verse")
	void shouldSaveVerse() {
		// given
		DailyRead dailyRead = DailyRead.of("test",
																			"1",
																			"1",
																			"test_book",
																			"new",
																			LocalDate.now());
		// when
		underTest1.save(dailyRead);

		// then
		ArgumentCaptor<DailyRead> dailyReadArgumentCaptor = ArgumentCaptor.forClass(DailyRead.class);
		verify(dailyReadRepository).save(dailyReadArgumentCaptor.capture());

		DailyRead capturedDailyRead = dailyReadArgumentCaptor.getValue();
		assertThat(capturedDailyRead).isEqualTo(dailyRead);
	}

	@Test
	@DisplayName("will throw exception when failed to get verse")
	void willThrowExceptionWhenFailedToGetVerse() {
		// then
		assertThatThrownBy(() -> underTest.getRandomVerse())
				.isInstanceOf(IllegalStateException.class)
				.hasMessageContaining("Failed to retrieve bible verse");
	}

	@Test
	@DisplayName("should get random verse")
	@Disabled
	void shouldGetRandomVerse() {
		// when
		var result = underTest.getRandomVerse();
		// then
		assertThat(result).isNotNull();
	}
}
