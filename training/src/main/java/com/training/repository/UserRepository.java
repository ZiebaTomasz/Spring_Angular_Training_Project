package com.training.repository;

import com.training.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query(value = "select u from USERS u where u.id=:idNumber")
  Optional<User> findById(@Param("idNumber") Long idNumber);

  Optional<User> findUserByLogin(String login);

//  Optional<User> findByLoginAndIdBetweenAnd(String login, Long id, int first, int second);

  @Query (value = "select * from USERS", nativeQuery = true)
  List<User> findAll();

}
