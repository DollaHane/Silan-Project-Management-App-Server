package com.silan.projectmanager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silan.projectmanager.Repo.ProjectRepo;
import com.github.f4b6a3.ulid.UlidCreator;
import com.silan.projectmanager.Model.Project;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
  
  @Autowired
  private ProjectRepo projectRepo;

  public List<Project> getAllProjects() {
    return projectRepo.findAll();
  }

  public Optional<Project> getProjectById(String id) {
    return projectRepo.findById(id);
  }

  public Project createProject(Project project) {
    LocalDateTime currentDate = LocalDateTime.now(ZoneId.of("+02:00"));
    Project newProject = new Project();
    newProject.setId(UlidCreator.getUlid().toString());
    newProject.setJobNumber(project.getJobNumber());
    newProject.setPoNumber(project.getPoNumber());
    newProject.setTitle(project.getTitle());
    newProject.setValue(project.getValue());
    newProject.setCreatedAt(currentDate);
    newProject.setUpdatedAt(currentDate);
    newProject.setDeliveryDate(currentDate.plusMonths(3));
    return projectRepo.save(newProject);
  }

  public Project updateProject(String id, Project projects) {
    Project updatedProject = projectRepo.findById(id).get();
    updatedProject.setTitle(projects.getTitle());
    updatedProject.setJobNumber(projects.getJobNumber());
    updatedProject.setPoNumber(projects.getPoNumber());
    updatedProject.setValue(projects.getValue());
    return projectRepo.save(updatedProject);
  }

  public void deleteProject(String id) {
    Project deletedProject = projectRepo.findById(id).get();
    if (deletedProject == null) {
      throw new IllegalArgumentException("Invalid Project ID");
    }
    projectRepo.delete(deletedProject);
    System.out.println("Successfully deleted project!");
  }

}
