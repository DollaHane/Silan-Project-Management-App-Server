package com.silan.projectmanager.Repo;

import com.silan.projectmanager.Model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepo extends JpaRepository<Tool, String>{
  
}
