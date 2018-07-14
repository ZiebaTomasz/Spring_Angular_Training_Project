package com.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories("com.training.repository")
@ComponentScan("com.training")
public class TrainingApplication {

  public static void main(String[] args) {
    SpringApplication.run(TrainingApplication.class, args);
  }
}
