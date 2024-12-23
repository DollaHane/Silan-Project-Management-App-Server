package com.silan.projectmanager.Repo;

import com.silan.projectmanager.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

// import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, String> {

  Optional<Users> findByEmail(String email);

}