package com.training.repository;

import com.training.domain.Training;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TrainingRepositoryTest {

  @Autowired
  private TrainingRepository trainingRepository;

  private TestEntityManager entityManager;

  @Test
  public void getFindFirst_returnsTraining() {
    Training trainingToSave = new Training();
    trainingToSave.setId(2L);
//    trainingToSave.setUserId(1L);
//    trainingToSave.setTrainingDetails(new TrainingDetails().setCalories(123));
    Training savedTraining = entityManager.persistFlushFind(trainingToSave);
    Optional<Training> training = trainingRepository.findFirstById(1L);
    System.out.println("Training is: " + training.isPresent());
    System.out.println(training.toString());
  }
}