package com.silan.projectmanager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silan.projectmanager.Repo.ProjectRepo;
import com.silan.projectmanager.Repo.ToolRepo;
import com.github.f4b6a3.ulid.Ulid;
import com.silan.projectmanager.Model.Project;
import com.silan.projectmanager.Model.Tool;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {

  @Autowired
  private ToolRepo toolRepo;

  @Autowired
  private ProjectRepo projectRepo;

  public List<Tool> getAllTools() {
    return toolRepo.findAll();
  }

  public Optional<Tool> getToolById(Ulid id) {
    return toolRepo.findById(id);
  }

  public Tool createTool(Tool tool) {
    Project project = projectRepo.findById(tool.getProjectParentId())
        .orElseThrow(() -> new RuntimeException("Project not found"));
    Tool newTool = new Tool();
    newTool.setToolNumber(tool.getToolNumber());
    newTool.setTitle(tool.getTitle());
    newTool.setDescription(tool.getDescription());
    newTool.setProjectParentId(tool.getProjectParentId());
    newTool.setProject(project);
    return toolRepo.save(newTool);
  }

  public Tool updateTool(Ulid id, Tool tool) {
    Project project = projectRepo.findById(tool.getProjectParentId())
        .orElseThrow(() -> new RuntimeException("Project not found"));
    Tool updatedTool = toolRepo.findById(id).get();
    updatedTool.setTitle(tool.getTitle());
    updatedTool.setDescription(tool.getDescription());
    updatedTool.setToolNumber(tool.getToolNumber());
    updatedTool.setProjectParentId(tool.getProjectParentId());
    updatedTool.setProject(project);
    return toolRepo.save(updatedTool);
  }

  public void deleteTool(Ulid id) {
    Tool deletedTool = toolRepo.findById(id).get();
    if (deletedTool == null) {
      throw new IllegalArgumentException("Invalid tool ID");
    }
    toolRepo.delete(deletedTool);
    System.out.println("Tool deleted successfully!");
  }

}
