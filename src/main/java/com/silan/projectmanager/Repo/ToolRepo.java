package com.silan.projectmanager.Repo;

import java.util.List;
import com.github.f4b6a3.ulid.Ulid;
import com.silan.projectmanager.Model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepo extends JpaRepository<Tool, Ulid>{
  List<Tool> findByProjectId(Ulid projectId);
}
