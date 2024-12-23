package com.silan.projectmanager.Services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;
import com.github.f4b6a3.ulid.Ulid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.github.f4b6a3.ulid.UlidCreator;
import com.silan.projectmanager.Model.Session;
import com.silan.projectmanager.Model.Users;

import com.silan.projectmanager.Repo.SessionRepo;
// import org.slf4j.LoggerFactory;
// import org.slf4j.*;

@Service

public class SessionService {

  @Autowired
  private SessionRepo sessionRepo;

  // SESSION
  public Session sessionService(Users user) {

    // final Logger logger = LoggerFactory.getLogger(SessionService.class);

    Optional<Session> session = sessionRepo.findSessionByEmail(user.getEmail());

    if (session.isEmpty()) {
      System.out.println("No existing session available");
    }

    Ulid ulid = UlidCreator.getUlid();
    String token = UUID.randomUUID().toString();

    LocalDateTime currentDate = LocalDateTime.now(ZoneId.of("+02:00"));
    LocalDateTime newExpirationDate = currentDate.plusDays(2);

    if (session.isEmpty() || currentDate.isAfter(session.get().getExpiration())) {
      try {
        System.out.println("Creating new session");
        Session newSession = new Session();
        newSession.setId(ulid.toString());
        newSession.setEmail(user.getEmail());
        newSession.setName(user.getName());
        newSession.setUserId(user.getId());
        newSession.setToken(token);
        newSession.setExpiration(newExpirationDate);
        System.out.println("New session:" + newSession.getId());
        Session savedSession = sessionRepo.save(newSession);
        return savedSession;
      } catch (DataIntegrityViolationException dive) {
        System.err.println("Database integrity violation: " + dive.getMessage());
        throw dive;
      } catch (Exception ex) {
        System.err.println("Failed to save session: " + ex.getMessage() + ex.getCause());
        // logger.error("Failed to save session", ex);
        throw ex;
      }
    } else {
      // TODO: Send email confirmation, there should not be a session in logged out state
      System.out.println("Returning current session");
      return session.get();
    }
  }

}
