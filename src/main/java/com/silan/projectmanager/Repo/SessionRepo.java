package com.silan.projectmanager.Repo;

import com.github.f4b6a3.ulid.Ulid;
import com.silan.projectmanager.Model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface SessionRepo extends JpaRepository<Session, Ulid> {

  @Query("SELECT * FROM session WHERE email = ?1")
  Optional<Session> findSessionByEmail(String email);

}
