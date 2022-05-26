package mts.mtech.dailyread.service.bibleverses;

import static org.assertj.core.api.Assertions.assertThat;

import mts.mtech.dailyread.api.ApiResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author Mitchell Tawanda Severa
 * @created 10/05/2022 - 10:36 PM
 */

class BibleVerseApiServiceImplTest {
  private BibleVerseApiServiceImpl underTest;
  @Mock
  TestRestTemplate restTemplate;

  @BeforeEach
  void setUp() {
  }

  @Test
  @Disabled
  void getVerse() {
    var result = underTest.getVerse("https://quotes.rest/bible/verse.json");
    ResponseEntity<ApiResponse> response = restTemplate.getForEntity("https://quotes.rest/bible/verse.json",
        ApiResponse.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(response.getStatusCodeValue()).isEqualTo(200);
    assertThat(response.getBody().getContents()).isEqualTo(result);
  }
}