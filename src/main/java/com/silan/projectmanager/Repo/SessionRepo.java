package com.silan.projectmanager.Repo;

import com.silan.projectmanager.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface SessionRepo extends JpaRepository<Session, String> {

  @Query("SELECT u FROM Session u WHERE u.email = ?1")
  Optional<Session> findSessionByEmail(String email);

}
