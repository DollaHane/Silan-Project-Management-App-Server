package com.silan.projectmanager.Repo;

import com.silan.projectmanager.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
  
}
