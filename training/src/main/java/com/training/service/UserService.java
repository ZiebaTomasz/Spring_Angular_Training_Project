package com.training.service;

import com.training.domain.User;
import com.training.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(
      UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void saveUser(User user) {
    System.out.println("Save User: "+ user.getLogin());
    userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUserById(Long id) {
    return userRepository.findById(id);
  }

  public Optional<User> findUserByLogin(String login) {
    return userRepository.findUserByLogin(login);
  }

  public void findVeryLongUser(){
//    userRepository.findByLoginAndIdBetweenAnd("tom", 1L, 2,3);
  }
}
