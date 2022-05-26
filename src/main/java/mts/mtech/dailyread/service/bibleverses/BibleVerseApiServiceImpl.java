package mts.mtech.dailyread.service.bibleverses;

import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.api.ApiResponse;
import mts.mtech.dailyread.domain.DailyRead;
import mts.mtech.dailyread.service.save.SaveVerseService;
import mts.mtech.dailyread.utils.Constants;
import mts.mtech.errorhandling.exception.RecordNotFoundException;
import mts.mtech.errorhandling.exception.SystemErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mitchell Tawanda Severa
 * @created 10/05/2022 - 10:32 PM
 */
@Service
@Slf4j
public class BibleVerseApiServiceImpl implements BibleVerseApiService{
  private RestTemplate restTemplate = new RestTemplate();
  private final SaveVerseService saveVerseService;

  public BibleVerseApiServiceImpl(
      SaveVerseService saveVerseService) {
    this.saveVerseService = saveVerseService;
  }

  @Override
  public DailyRead getVerse(String url){
    try {
      ResponseEntity<ApiResponse> call = restTemplate.getForEntity(url, ApiResponse.class);
      log.info("response:{}", call.getBody());
      var result = call.getBody();

      if(result == null){
        throw new RecordNotFoundException(Constants.VERSE_NOT_FOUND);
      }

      DailyRead dailyRead = DailyRead.builder()
          .reading(result.getContents().getVerse())
          .book(result.getContents().getBook())
          .chapter(result.getContents().getChapter())
          .verse(result.getContents().getNumber())
          .testament(result.getContents().getTestament())
          .build();
      saveVerseService.save(dailyRead);
      return dailyRead;

    } catch (Exception e) {
      throw new SystemErrorException(Constants.SERVICE_UNAVAILABLE);
    }
  }

}
