package com.silan.projectmanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.f4b6a3.ulid.Ulid;
import com.silan.projectmanager.Model.Users;
import com.silan.projectmanager.Repo.UserRepo;
import com.silan.projectmanager.Services.UserService;
import java.util.Optional;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  private UserService userService;
  private UserRepo userRepo;

  @GetMapping(value = "/api/get-users")
  public List<Users> getAllUsers() {
    return userService.getAllUsers();
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping(value = "/api/auth-register")
  public ResponseEntity<Users> registerUser(@RequestBody Users users) {

    Optional<Users> userCheck = userRepo.findUserByEmail(users.getEmail());

    if (userCheck.isPresent()) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists.");
    }

    try {
      Users registeredUser = userService.registerUser(users);
      System.out.println("User registration success");
      return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    } catch (Exception ex) {
      System.err.println("Failed to register user: ERR - " + ex.getMessage());
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to register user.");
    }

  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PutMapping(value = "/api/update-users/{id}")
  public ResponseEntity<Users> updateUser(Ulid id, @RequestBody Users users) {
    Users updatedUser = userService.updateUser(id, users);
    return ResponseEntity.ok(updatedUser);
  }
}