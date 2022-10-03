package mts.mtech.dailyread.service.bibleverses;

import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.api.ApiResponse;
import mts.mtech.dailyread.domain.DailyRead;
import mts.mtech.dailyread.domain.enums.Status;
import mts.mtech.dailyread.exception.RecordNotFoundException;
import mts.mtech.dailyread.exception.SystemErrorException;
import mts.mtech.dailyread.service.save.bibleverses.SaveVerseService;
import mts.mtech.dailyread.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

/**
 * @author Mitchell Tawanda Severa
 * @created 10/05/2022 - 10:32 PM
 */
@Service
@Slf4j
public class BibleVerseApiServiceImpl implements BibleVerseApiService{
  private RestTemplate restTemplate = new RestTemplate();
  private final SaveVerseService saveVerseService;
  private final UpdateBibleVerseService updateBibleVerseService;

  public BibleVerseApiServiceImpl(
      SaveVerseService saveVerseService,
      UpdateBibleVerseService updateBibleVerseService) {
    this.saveVerseService = saveVerseService;
    this.updateBibleVerseService = updateBibleVerseService;
  }

  @Override
  public DailyRead getVerse(String url){
    try {
      ResponseEntity<ApiResponse> response = restTemplate.getForEntity(url, ApiResponse.class);
      log.info("response:{}", response.getBody());
      var body = response.getBody();

      if(body == null){
        throw new RecordNotFoundException(Constants.VERSE_NOT_FOUND);
      }
      return saveBibleVerse(body);

    } catch (Exception e) {
      throw new SystemErrorException(Constants.SERVICE_UNAVAILABLE);
    }
  }

  private DailyRead saveBibleVerse(ApiResponse response){
    updateBibleVerseService.updateBibleVerse();
    DailyRead dailyRead = DailyRead.builder()
                                  .reading(response.getContents().getVerse())
                                  .book(response.getContents().getBook())
                                  .chapter(response.getContents().getChapter())
                                  .verse(response.getContents().getNumber())
                                  .testament(response.getContents().getTestament())
                                  .status(Status.ACTIVE)
                                  .dateCreated(LocalDate.now())
                                  .build();
    return saveVerseService.save(dailyRead);
  }

}
