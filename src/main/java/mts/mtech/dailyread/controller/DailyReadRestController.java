package mts.mtech.dailyread.controller;

import mts.mtech.dailyread.controller.dto.DailyReadDto;
import mts.mtech.dailyread.service.DailyReadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 9:02 PM
 */
@RestController
@RequestMapping("daily-read")
public class DailyReadRestController {
  private final DailyReadService dailyReadService;

  public DailyReadRestController(DailyReadService dailyReadService) {
    this.dailyReadService = dailyReadService;
  }

  @GetMapping("/daily")
  public DailyReadDto getDailyVerse(){
    return DailyReadDto.of(dailyReadService.getDailyVerse());
  }

  @GetMapping("/random")
  public DailyReadDto getRandomVerse(){
    return DailyReadDto.of(dailyReadService.getRandomVerse());
  }
}
