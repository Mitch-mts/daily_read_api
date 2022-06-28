package mts.mtech.dailyread.controller;

import mts.mtech.dailyread.controller.dto.DailyReadDto;
import mts.mtech.dailyread.service.bibleverses.DailyReadService;
import mts.mtech.dailyread.utils.Constants;
import mts.mtech.dailyread.utils.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mitchell Tawanda Severa
 * @created 31/03/2022 - 9:02 PM
 */
@RestController
@RequestMapping(path = "daily-read")
@CrossOrigin
public class DailyReadRestController {
  private final DailyReadService dailyReadService;

  public DailyReadRestController(DailyReadService dailyReadService) {
    this.dailyReadService = dailyReadService;
  }

  @GetMapping(path = "/daily")
  public Response<DailyReadDto> getDailyVerse(){
    return new Response<DailyReadDto>().buildSuccessResponse(Constants.SUCCESS,
        DailyReadDto.of(dailyReadService.getDailyVerse()));
  }

  @GetMapping(path = "/random")
  public Response<DailyReadDto> getRandomVerse(){
    return new Response<DailyReadDto>().buildSuccessResponse(Constants.SUCCESS,
        DailyReadDto.of(dailyReadService.getRandomVerse()));
  }

  @GetMapping
  public Response<DailyReadDto> getBibleVerse(){
    return new Response<DailyReadDto>().buildSuccessResponse(Constants.SUCCESS,
        DailyReadDto.of(dailyReadService.getBibleVerse()));
  }
}
