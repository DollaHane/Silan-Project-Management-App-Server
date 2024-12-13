package com.silan.projectmanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.f4b6a3.ulid.Ulid;
import com.silan.projectmanager.Model.Users;
import com.silan.projectmanager.Services.UserService;

import java.util.List;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping(value = "/api/get-users")
  public List<Users> getAllUsers() {
    return userService.getAllUsers();
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping(value = "/api/save-users")
  public ResponseEntity<Users> createUser(@RequestBody Users users) {
    Users savedUser = userService.saveUser(users);
    return ResponseEntity.ok(savedUser);
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PutMapping(value = "/api/update-users/{id}")
  public ResponseEntity<Users> updateUser(Ulid id, @RequestBody Users users) {
    Users updatedUser = userService.updateUser(id, users);
    return ResponseEntity.ok(updatedUser);
  }
}