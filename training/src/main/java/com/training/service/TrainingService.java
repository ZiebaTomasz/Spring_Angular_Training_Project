package com.training.service;

import com.training.domain.Training;
import com.training.repository.TrainingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingService {

  private TrainingRepository trainingRepository;

  @Autowired
  public TrainingService(TrainingRepository trainingRepository) {
    this.trainingRepository = trainingRepository;
  }

  public void save(Training training) {
    trainingRepository.save(training);
  }

  public List<Training> getAll() {
    return trainingRepository.findAll();
  }

  public List<Training> getAllByUserId(Long id) {
    return trainingRepository.findByUserId(id);
  }
}
