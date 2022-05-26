package mts.mtech.dailyread.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mts.mtech.dailyread.controller.dto.MessageResponse;
import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.service.users.UserRequest;
import mts.mtech.dailyread.service.users.UserService;
import mts.mtech.dailyread.service.users.create.CreateUserService;
import mts.mtech.dailyread.service.users.update.UpdateUserService;
import mts.mtech.dailyread.service.users.view.ViewUserService;
import mts.mtech.dailyread.utils.Constants;
import mts.mtech.dailyread.utils.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mitchell Tawanda Severa
 * @created 04/05/2022 - 8:17 PM
 */
@RestController
@RequestMapping("/users")
@Slf4j
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
  public Response<Users> create(@Valid @RequestBody UserRequest userRequest){
    log.info("userRequest: {}", userRequest);
    return new Response<Users>().buildSuccessResponse(Constants.SUCCESS,
        createUserService.createUser(userRequest));
  }

  @PutMapping("/{id}")
  public Response<Users> update(@PathVariable Long id, UserRequest userRequest){
    log.info("id: {}, userRequest: {}", id, userRequest);
    return new Response<Users>().buildSuccessResponse(Constants.UPDATED,
        updateUserService.updateUser(userRequest, id));
  }

  @GetMapping
  public Response<Page<Users>> getAll(@PageableDefault Pageable pageable){
    log.info("pagaeble:{}", pageable);
    return  new Response<Page<Users>>().buildSuccessResponse(Constants.SUCCESS,
        viewUserService.getAllUsers(pageable));
  }

  @GetMapping("/{id}")
  public Response<Users> getById(@PathVariable Long id){
    return new Response<Users>().buildSuccessResponse(Constants.SUCCESS,
        viewUserService.getUserById(id));
  }

  @GetMapping("/list")
  public Response<List<Users>> getList(){
    return new Response<List<Users>>().buildSuccessResponse(Constants.SUCCESS,
        viewUserService.getUserList());
  }

  @DeleteMapping("{id}")
  public MessageResponse delete(@PathVariable Long id){
    log.info("delete id: {}", id);
    return new MessageResponse(Constants.DELETED, userService.deleteUser(id));
  }

  @PutMapping("activate-deactivate/{id}")
  public Response<Users> activateDeactivate(@PathVariable Long id){
    log.info("activating/deactivating : {}", id);
    return new Response<Users>().buildSuccessResponse(Constants.SUCCESS,
        userService.activateDeactivateUser(id));
  }

}
