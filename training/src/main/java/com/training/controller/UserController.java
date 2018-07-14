package com.training.controller;


import com.training.domain.User;
import com.training.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  private final Logger logger = Logger.getLogger(UserController.class.getName());

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/post")
  public ResponseEntity saveUser(@RequestBody User user) {

    if (userService.findUserByLogin(user.getLogin()).isPresent()) {
      logger.info("USer is present");
      return ResponseEntity.status(412).body("User already exists");
    } else {
      logger.info("User doesn't present");
      userService.saveUser(user);
      logger.info("After save");
      return ResponseEntity.ok("User was save to DB");
    }
//    user = new User();
  }


  @GetMapping("/all")
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> customers = userService.getAllUsers();
    logger.info("customers size: " + customers.size());
    if (customers.isEmpty()) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.ok(customers);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    logger.info("receive user id: " + id);
    Optional<User> foundUser = userService.getUserById(id);
    logger.info(String.valueOf(foundUser.isPresent()));
    return foundUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound()
        .header("User not found").build());
  }
}
