package com.silan.projectmanager.Repo;

import com.silan.projectmanager.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {
  
}