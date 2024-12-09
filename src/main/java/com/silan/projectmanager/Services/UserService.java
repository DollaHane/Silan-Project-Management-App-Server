package com.silan.projectmanager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

  public Users updateUser(long id, Users users) {
    Users updatedUser = userRepo.findById(id).get();
    updatedUser.setFirstName(users.getFirstName());
    updatedUser.setLastName(users.getLastName());
    updatedUser.setOccupation(users.getOccupation());
    updatedUser.setAge(users.getAge());
    return userRepo.save(updatedUser);
  }

}
