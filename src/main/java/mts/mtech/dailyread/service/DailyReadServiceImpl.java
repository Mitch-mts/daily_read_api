package mts.mtech.dailyread.service;

import java.time.LocalDate;
import mts.mtech.dailyread.api.ApiResponse;
import mts.mtech.dailyread.domain.DailyRead;
import mts.mtech.dailyread.persistence.DailyReadRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 8:45 PM
 */
@Service
public class DailyReadServiceImpl implements DailyReadService{
  private final Logger logger = LoggerFactory.getLogger(DailyReadServiceImpl.class);
  private final DailyReadRepository dailyReadRepository;
  private RestTemplate restTemplate = new RestTemplate();
  private final SaveVerseService saveVerseService;

  @Value("${daily-read.daily-verse}")
  String verseOfTheDay;
  @Value("${daily-read.random-verse}")
  String randomVerse;

  public DailyReadServiceImpl(DailyReadRepository dailyReadRepository, SaveVerseService saveVerseService) {
    this.dailyReadRepository = dailyReadRepository;
    this.saveVerseService = saveVerseService;
  }

  @Override
  public DailyRead getDailyVerse() {
    return getVerse(verseOfTheDay);
  }

  @Override
  public DailyRead getRandomVerse() {
    return getVerse(randomVerse);
  }

  private DailyRead getVerse(String url){
    try {
      ResponseEntity<ApiResponse> call = restTemplate.getForEntity(url, ApiResponse.class);
      logger.info("response:{}", call.getBody());
      var result = call.getBody();

      if(result == null){
        throw new IllegalStateException("Bible verse not found");
      }

      DailyRead dailyRead = DailyRead.of(result.getContents().getVerse(),
                                        result.getContents().getNumber(),
                                        result.getContents().getChapter(),
                                        result.getContents().getBook(),
                                        result.getContents().getTestament(),
                                        LocalDate.now());
      saveVerse(dailyRead);
      return dailyRead;

    } catch (Exception e) {
      throw new IllegalStateException("Failed to retrieve bible verse:{}", e);
    }
  }

  private void saveVerse(DailyRead dailyRead){
    saveVerseService.save(dailyRead);
  }

}
