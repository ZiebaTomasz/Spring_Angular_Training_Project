package com.training.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "USERS")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
  @SequenceGenerator(sequenceName = "USER_SEQ", initialValue = 1, allocationSize = 1, name = "USERS_SEQ")
  private Long id;

//  @Min(5)
  @NotBlank
  @Column(unique = true)
  private String login;

  @NotBlank
  @Column(length = 20, nullable = false)
  private String firstName;

  @NotBlank
  @Column(length = 25, nullable = false)
  private String lastName;
  private String email;

  @Column(name = "CREATED_DATE")
  private Date createdDates;

  @Column(name = "DATE_OF_THE_BIRTH")
  private Date dateOfTheBirth;

  //  @Min(6)
  private String password;

  @OneToMany(
//      orphanRemoval = true, fetch = FetchType.LAZY,
//      mappedBy = "id"
  )
  @JoinColumn(name = "USER_ID")
  private Set<Training> trainings = new HashSet<>();

  public boolean addTraining(Training training) {
    if (trainings.contains(training)) {
      return false;
    } else {
      trainings.add(training);
      return true;
    }
  }
}
