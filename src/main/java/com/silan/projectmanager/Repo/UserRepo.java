package com.silan.projectmanager.Repo;

import com.github.f4b6a3.ulid.Ulid;
import com.silan.projectmanager.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Ulid> {

  @Query("SELECT u FROM Users u WHERE u.email = ?1")
  Optional<Users> findUserByEmail(String email);

}