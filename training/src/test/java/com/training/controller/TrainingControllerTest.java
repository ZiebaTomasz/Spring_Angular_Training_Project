package com.training.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.training.domain.Training;
import com.training.domain.User;
import com.training.repository.TrainingRepository;
import com.training.repository.UserRepository;
import com.training.service.TrainingService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.mapping.Collection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.BDDMockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(TrainingController.class)
public class TrainingControllerTest {
  private static final Logger logger = Logger.getLogger(TrainingControllerTest.class.getName());

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TrainingRepository trainingRepository;

  @MockBean
  private TrainingService trainingService;

  @MockBean
  private UserRepository userRepository;

  @Autowired
  private UserController userController;

//  @Autowired
//  private UserService userService;

  @Autowired
  private TrainingController trainingController;

  @Before
  public void setUp() throws Exception {
    logger.info("In save trainings");
    User user = new User();
    user.setLogin("Catarina12");
//    user.setId(6L);
    user.setFirstName("Catolcia");
    user.setLastName("Blonska");
//    userService.saveUser(user);
//    User user1 = new User();
//    user1.setLogin("Catarinka123");
//    user1.setFirstName("Catolciak");
//    user1.setLastName("Babilonska");
//    userService.saveUser(user1);

    Training training = new Training();
    training.setType("Hokey");
    trainingRepository.save(training);

    Training training1 = new Training();
    training1.setType("Football");
    trainingRepository.save(training1);

//    user.addTraining(training);
//    user.addTraining(training1);

    userController.saveUser(user);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void saveTrainings() throws Exception {
    Training training = new Training();
    training.setType("Super");
    training.setUserId(1L);
    Training training1 = new Training();
    training1.setType("Master");
    List<Training> trainingList = Arrays.asList(training, training1);
    given(trainingService.getAll()).willReturn(trainingList);
      mockMvc.perform(MockMvcRequestBuilders.get("/training/all"))
              .andExpect(status().isOk());
  }
}