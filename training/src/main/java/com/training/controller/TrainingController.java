package com.training.controller;

import com.training.domain.Training;
import com.training.domain.User;
import com.training.service.TrainingService;
import com.training.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/training")
public class TrainingController {

  private final Logger logger = Logger.getLogger(UserController.class.getName());
  private final TrainingService trainingService;
  private final UserService userService;

  @Autowired
  public TrainingController(TrainingService trainingService,
      UserService userService) {
    this.trainingService = trainingService;
    this.userService = userService;
  }

  @GetMapping(value = "/trs")
  public void getUsers() {
    Optional<User> user = userService.getUserById(1L);
    if (user.isPresent()) {
      logger.info("USER is present");
//      java.util.Collection<Training> trainings = user.get().getTrainings();
//      logger.info("Training set is: "+ trainings.size());
//      trainings.forEach(training -> logger.info("\n training: " + training.getType()));
    }
  }

  @GetMapping(value = "/all")
  public ResponseEntity<List<Training>> getAllTrainings() {
    List<Training> trainingList = trainingService.getAll();
    logger.info("Training size:"+ trainingList.size());
    List<User> allUsers = userService.getAllUsers();
    logger.info("User size:"+ allUsers.size());
    return ResponseEntity.ok(trainingList);
  }

  @GetMapping(value = "/user/{id}")
  public ResponseEntity<List<Training>> getTrainingsByUserId(@PathVariable Long id) {
    List<Training> allByUserId = trainingService.getAllByUserId(id);
    if (allByUserId.isEmpty()){
      return ResponseEntity.noContent().build();
    } else return ResponseEntity.ok(allByUserId);
  }

}
