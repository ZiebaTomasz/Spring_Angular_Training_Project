package com.training.repository;

import com.training.domain.Training;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

  //  @Query(value = "select t from TRAININGS t where t.user_id=:id")
  List<Training> findAll();

  Optional<Training> findFirstById(Long id);

  List<Training> findByUserId(Long id);


}
