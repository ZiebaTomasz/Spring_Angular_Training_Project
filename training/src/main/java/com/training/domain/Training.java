package com.training.domain;

import java.time.Duration;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostRemove;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Entity(name = "TRAININGS")
@Data
public class Training {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAIN_SEQ")
  @SequenceGenerator(sequenceName = "TRAINING_SEQ", initialValue = 1, allocationSize = 1, name= "TRAIN_SEQ")
  private Long id;

  @Column(name = "USER_ID")
  private Long userId;

  private String name;
  private String type;
  private Duration duration;
  private int caloriesPerHour;



//  @ManyToOne()
//  private User user;


}
