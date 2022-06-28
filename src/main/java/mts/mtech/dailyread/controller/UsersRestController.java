package mts.mtech.dailyread.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.controller.dto.MessageResponse;
import mts.mtech.dailyread.controller.dto.UserAccountDto;
import mts.mtech.dailyread.service.users.UserRequest;
import mts.mtech.dailyread.service.users.UserService;
import mts.mtech.dailyread.service.users.create.CreateUserService;
import mts.mtech.dailyread.service.users.update.UpdateUserService;
import mts.mtech.dailyread.service.users.view.ViewUserService;
import mts.mtech.dailyread.utils.Constants;
import mts.mtech.dailyread.utils.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mitchell Tawanda Severa
 * @created 04/05/2022 - 8:17 PM
 */
@RestController
@RequestMapping(path = "/users")
@Slf4j
@CrossOrigin
public class UsersRestController {
  private final UserService userService;
  private final CreateUserService createUserService;
  private final UpdateUserService updateUserService;
  private final ViewUserService viewUserService;

  public UsersRestController(UserService userService,
      CreateUserService createUserService,
      UpdateUserService updateUserService,
      ViewUserService viewUserService) {
    this.userService = userService;
    this.createUserService = createUserService;
    this.updateUserService = updateUserService;
    this.viewUserService = viewUserService;
  }


  @PostMapping
  public Response<UserAccountDto> create(@Valid @RequestBody UserRequest userRequest){
    log.info("userRequest: {}", userRequest);
    return new Response<UserAccountDto>().buildSuccessResponse(Constants.SUCCESS,
        UserAccountDto.of(createUserService.createUser(userRequest)));
  }

  @PutMapping(path = "/{id}")
  public Response<UserAccountDto> update(@PathVariable Long id, UserRequest userRequest){
    log.info("id: {}, userRequest: {}", id, userRequest);
    return new Response<UserAccountDto>().buildSuccessResponse(Constants.UPDATED,
        UserAccountDto.of(updateUserService.updateUser(userRequest, id)));
  }

  @GetMapping
  public Response<Page<UserAccountDto>> getAll(@PageableDefault Pageable pageable, @RequestParam Integer pageNumber){
    Pageable page = PageRequest.of(pageNumber, pageable.getPageSize());
    var userPage = viewUserService.getAllUsers(page)
                                                .stream()
                                                .map(UserAccountDto::of)
                                                .collect(
                                                Collectors.toList());

    return  new Response<Page<UserAccountDto>>().buildSuccessResponse(Constants.SUCCESS,
        new PageImpl<>(userPage));
  }

  @GetMapping(path = "/{id}")
  public Response<UserAccountDto> getById(@PathVariable Long id){
    return new Response<UserAccountDto>().buildSuccessResponse(Constants.SUCCESS,
        UserAccountDto.of(viewUserService.getUserById(id)));
  }

  @GetMapping(path = "/list")
  public Response<List<UserAccountDto>> getList(){
    return new Response<List<UserAccountDto>>().buildSuccessResponse(Constants.SUCCESS,
        UserAccountDto.of(viewUserService.getUserList()));
  }

  @DeleteMapping(path = "{id}")
  public MessageResponse delete(@PathVariable Long id){
    log.info("delete id: {}", id);
    return new MessageResponse(Constants.DELETED, userService.deleteUser(id));
  }

  @PutMapping(path = "activate-deactivate/{id}")
  public Response<UserAccountDto> activateDeactivate(@PathVariable Long id){
    log.info("activating/deactivating : {}", id);
    return new Response<UserAccountDto>().buildSuccessResponse(Constants.SUCCESS,
        UserAccountDto.of(userService.activateDeactivateUser(id)));
  }

}
