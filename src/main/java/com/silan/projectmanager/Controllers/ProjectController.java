package com.silan.projectmanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.silan.projectmanager.Services.ProjectService;
import com.silan.projectmanager.Model.Project;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {
  
  @Autowired
  private ProjectService projectService;

  @GetMapping(value = "/api/get-projects")
  public List<Project> getAllProjects() {
    return projectService.getAllProjects();
  }

  @GetMapping(value = "/api/get-project/{id}")
  public Optional<Project> getProjectById(@PathVariable("id") String id) {
    return projectService.getProjectById(id);
  }

  @PostMapping(value = "/api/create-project")
  public ResponseEntity<Project> createProject(@RequestBody Project project) {
    Project savedProject = projectService.createProject(project);
    return ResponseEntity.ok(savedProject);
  }


}
