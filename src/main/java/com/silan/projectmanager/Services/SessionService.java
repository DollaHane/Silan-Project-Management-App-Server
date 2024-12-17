package com.silan.projectmanager.Services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silan.projectmanager.Types.LoginCredentials;
import com.silan.projectmanager.Model.Session;
import com.silan.projectmanager.Model.Users;

import com.silan.projectmanager.Repo.SessionRepo;
import com.silan.projectmanager.Repo.UserRepo;

@Service
public class SessionService {

  @Autowired
  private SessionRepo sessionRepo;
  private UserRepo userRepo;

  // SESSION
  public Session sessionService(LoginCredentials loginCredentials) {

    Optional<Session> currentSession = sessionRepo.findSessionByEmail(loginCredentials.getEmail());
    Optional<Users> user = userRepo.findUserByEmail(loginCredentials.getEmail());
    String token = UUID.randomUUID().toString();

    LocalDateTime currentDate = LocalDateTime.now(ZoneId.of("+02:00"));
    LocalDateTime newExpirationDate = currentDate.plusDays(2);

    if (user.isEmpty()) {
      throw new RuntimeException("User not found with email:" + loginCredentials.getEmail());
    }

    if (currentSession.isEmpty() || currentDate.isAfter(currentSession.get().getExpiration())) {
      Session session = new Session();
      session.setEmail(loginCredentials.getEmail());
      session.setName(user.get().getName());
      session.setUserId(user.get().getId());
      session.setToken(token);
      session.setExpiration(newExpirationDate);
      return sessionRepo.save(session);
    } else {
      return currentSession.get();
    }
  }

}
