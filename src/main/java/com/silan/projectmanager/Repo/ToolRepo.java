package com.silan.projectmanager.Repo;

import com.silan.projectmanager.Model.Tool;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepo extends JpaRepository<Tool, Long>{
  List<Tool> findByProjectId(Long projectId);
}
