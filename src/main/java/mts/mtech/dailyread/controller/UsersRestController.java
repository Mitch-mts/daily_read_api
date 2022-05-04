package mts.mtech.dailyread.controller;

import java.util.List;
import javax.validation.Valid;
import mts.mtech.dailyread.controller.dto.MessageResponse;
import mts.mtech.dailyread.domain.Users;
import mts.mtech.dailyread.service.users.UserRequest;
import mts.mtech.dailyread.service.users.UserService;
import mts.mtech.dailyread.utils.Constants;
import mts.mtech.dailyread.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UsersRestController {
  private final Logger logger = LoggerFactory.getLogger(UsersRestController.class);
  private final UserService userService;

  public UsersRestController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public Response<Users> create(@Valid @RequestBody UserRequest userRequest){
    logger.info("userRequest: {}", userRequest);
    return new Response<Users>().buildSuccessResponse(Constants.SUCCESS,
        userService.createUser(userRequest));
  }

  @PutMapping("/{id}")
  public Response<Users> update(@PathVariable Long id, UserRequest userRequest){
    logger.info("id: {}, userRequest: {}", id, userRequest);
    return new Response<Users>().buildSuccessResponse(Constants.UPDATED,
        userService.updateUser(userRequest, id));
  }

  @GetMapping
  public Response<Page<Users>> getAll(@PageableDefault Pageable pageable){
    logger.info("pagaeble:{}", pageable);
    return  new Response<Page<Users>>().buildSuccessResponse(Constants.SUCCESS,
        userService.getAllUsers(pageable));
  }

  @GetMapping("/{id}")
  public Response<Users> getById(@PathVariable Long id){
    return new Response<Users>().buildSuccessResponse(Constants.SUCCESS,
        userService.getUserById(id));
  }

  @GetMapping("/list")
  public Response<List<Users>> getList(){
    return new Response<List<Users>>().buildSuccessResponse(Constants.SUCCESS,
        userService.getUserList());
  }

  @DeleteMapping("{id}")
  public MessageResponse delete(@PathVariable Long id){
    logger.info("delete id: {}", id);
    return new MessageResponse(Constants.DELETED, userService.deleteUser(id));
  }

  @PutMapping("activate-deactivate/{id}")
  public Response<Users> activateDeactivate(@PathVariable Long id){
    logger.info("activating/deactivating : {}", id);
    return new Response<Users>().buildSuccessResponse(Constants.SUCCESS,
        userService.activateDeactivateUser(id));
  }

}
