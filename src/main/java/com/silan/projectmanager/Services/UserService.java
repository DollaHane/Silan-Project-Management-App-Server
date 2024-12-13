package com.silan.projectmanager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.f4b6a3.ulid.Ulid;
import com.silan.projectmanager.Model.Users;
import com.silan.projectmanager.Repo.UserRepo;

import java.util.List;

@Service
public class UserService {

  @Autowired
  private UserRepo userRepo;

  public List<Users> getAllUsers() {
    return userRepo.findAll();
  }

  public Users saveUser(Users users) {
    return userRepo.save(users);
  }

  public Users updateUser(Ulid id, Users users) {
    Users updatedUser = userRepo.findById(id).get();
    updatedUser.setName(users.getName());
    updatedUser.setUpdatedAt(users.getUpdatedAt());
    return userRepo.save(updatedUser);
  }

}
