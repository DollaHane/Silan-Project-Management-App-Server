package com.silan.projectmanager.Repo;

import com.github.f4b6a3.ulid.Ulid;
import com.silan.projectmanager.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Ulid> {
  
}