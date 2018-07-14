package com.training.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.training.domain.User;
import com.training.repository.TrainingRepository;
import com.training.repository.UserRepository;
import com.training.service.TrainingService;
import com.training.service.UserService;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

  private static final Logger logger = Logger.getLogger(UserControllerTest.class.getName());

  @Before
  public void createFakeUser(){
    User user = new User();
    user.setId(1L);
    user.setLogin("tomek516");
    user.setFirstName("tome");
    user.setLastName("Zi");
    userService.saveUser(user);
  }

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TrainingRepository trainingRepository;

  @Autowired
  private TrainingService trainingService;

  @MockBean
  private UserService userService;

  @Test
  public void shouldReturnNotFound() throws Exception {
  mockMvc.perform(MockMvcRequestBuilders.get("/user/1321"))
      .andExpect(status().isNotFound());
  }

  @Test
  public void shouldReturnIsOk() throws Exception {
    logger.info("\n\n Before save User");
    createFakeUser();
    logger.info("After Save User");
    mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
        .andExpect(status().isOk());
  }
}