package com.silan.projectmanager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silan.projectmanager.Model.Users;
import com.silan.projectmanager.Repo.UserRepo;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;

  // REGISTER
  public Users registerUser(@Valid Users users) {

    LocalDateTime currentDate = LocalDateTime.now(ZoneId.of("+02:00"));
    String password = users.getPassword();
    String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

    Users newUser = new Users();

    newUser.setName(users.getName());
    newUser.setEmail(users.getEmail());
    newUser.setPassword(hashedPassword);
    newUser.setIsAdmin(users.getIsAdmin());
    newUser.setCreatedAt(currentDate);
    newUser.setUpdatedAt(currentDate);

    return userRepo.save(newUser);
  }

  public Users updateUser(String id, Users users) {
    Users updatedUser = userRepo.findById(id).get();
    updatedUser.setName(users.getName());
    updatedUser.setUpdatedAt(users.getUpdatedAt());
    return userRepo.save(updatedUser);
  }

}
