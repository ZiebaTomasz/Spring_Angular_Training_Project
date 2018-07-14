package com.training.domain;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.Data;

@Data
public class Ftth {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FTTHS_SEQ")
  @SequenceGenerator(sequenceName = "FTTH_SEQ", initialValue = 1, allocationSize = 1, name = "FTTHS_SEQ")
  private Long id;

  private String streetName;


  private int leasingNumber;

  private Date createdOn;

  private String district;
}
