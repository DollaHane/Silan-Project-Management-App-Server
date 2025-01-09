package com.silan.projectmanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.silan.projectmanager.Model.Session;
import com.silan.projectmanager.Model.Users;
import com.silan.projectmanager.Repo.SessionRepo;
import com.silan.projectmanager.Repo.UserRepo;
import com.silan.projectmanager.Services.SessionService;
import com.silan.projectmanager.Services.UserService;
import com.silan.projectmanager.Types.LoginResponse;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.http.HttpServletRequest;

// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
import java.util.Optional;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private SessionService sessionService;

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private SessionRepo sessionRepo;

  // ________________________________________________________________
  // LOGIN
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping(value = "/api/auth-login")
  public ResponseEntity<LoginResponse> loginUser(@RequestBody Users users) {

    Users user;
    String providedPassword = users.getPassword();
    String userPassword;
    BCrypt.Result checkPassword;

    try {
      Optional<Users> getUser = userRepo.findByEmail(users.getEmail());
      user = getUser.get();
      userPassword = user.getPassword();
      checkPassword = passwordCheck(userPassword, providedPassword);
    } catch (Exception ex) {
      System.out.println("Email does not exist: ERR - " + ex.getMessage() + ex.getCause());
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Email does not exist");
    }

    if (checkPassword.verified) {
      try {
        Session session = sessionService.sessionService(user);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-token", session.getToken());
        headers.add("Auth-sessionId", session.getId());

        LoginResponse response = new LoginResponse();
        response.setUserId(user.getId());
        response.setEmail(user.getEmail());
        response.setName(user.getName());
        response.setExpiration(session.getExpiration());

        return new ResponseEntity<LoginResponse>(response, headers, HttpStatus.OK);
      } catch (Exception ex) {
        System.err.println("Failed to create a session: ERR - " + ex.getMessage() + ex.getCause());
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create session");
      }
    } else {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Incorrect password supplied");
    }
  }

  private BCrypt.Result passwordCheck(String userPassword, String providedPassword) {
    BCrypt.Result result = BCrypt.verifyer().verify(providedPassword.toCharArray(), userPassword);
    return result;
  }

  // ________________________________________________________________
  // REGISTRATION
  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping(value = "/api/auth-register")
  public ResponseEntity<Users> registerUser(@RequestBody Users users) {

    Optional<Users> userCheck = userRepo.findByEmail(users.getEmail());

    if (userCheck.isPresent()) {
      throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already exists.");
    }

    try {
      Users registeredUser = userService.registerUser(users);
      System.out.println("User registration success");
      return new ResponseEntity<>(registeredUser, HttpStatus.OK);
    } catch (Exception ex) {
      System.err.println("Failed to register user: ERR - " + ex.getMessage() + ex.getCause());
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to register user.");
    }

  }

  // _________________________________________________________________
  // DELETE SESSION
  @CrossOrigin(origins = "http://localhost:4200")
  @DeleteMapping(path = "api/auth-rm-session")
  private ResponseEntity<String> DeleteSession(HttpServletRequest request) {
    String token = request.getHeader("Auth-token");
    String sessionId = request.getHeader("Auth-sessionId");
    Optional<Session> getSession = sessionRepo.findById(sessionId);

    System.out.println("Request Headers: " + token + " " + sessionId);

    try {

      if (token.isEmpty()) {
        System.err.println("Session not present in request headers");
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Session token not present in request headers");
      }

      if (getSession.isPresent()) {
        Session session = getSession.get();
        sessionRepo.delete(session);
      }
    } catch (Exception ex) {
      System.err.println("Failed to delete session: ERR - ." + ex.getMessage() + ex.getCause());
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to delete session");
    }

    return new ResponseEntity<>(HttpStatus.OK);
  }
}