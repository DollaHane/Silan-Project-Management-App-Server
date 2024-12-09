package com.silan.projectmanager.Repo;

import com.silan.projectmanager.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
  
}
