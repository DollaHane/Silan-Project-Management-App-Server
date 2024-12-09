package com.silan.projectmanager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silan.projectmanager.Repo.ProjectRepo;
import com.silan.projectmanager.Model.Project;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
  
  @Autowired
  private ProjectRepo projectRepo;

  public List<Project> getAllProjects() {
    return projectRepo.findAll();
  }

  public Optional<Project> getProjectById(long id) {
    return projectRepo.findById(id);
  }

  public Project createProject(Project project) {
    return projectRepo.save(project);
  }

  public Project updateProject(long id, Project projects) {
    Project updatedProject = projectRepo.findById(id).get();
    updatedProject.setTitle(projects.getTitle());
    updatedProject.setJobNumber(projects.getJobNumber());
    updatedProject.setPoNumber(projects.getPoNumber());
    updatedProject.setValue(projects.getValue());
    return projectRepo.save(updatedProject);
  }

  public void deleteProject(long id) {
    Project deletedProject = projectRepo.findById(id).get();
    if (deletedProject == null) {
      throw new IllegalArgumentException("Invalid Project ID");
    }
    projectRepo.delete(deletedProject);
    System.out.println("Successfully deleted project!");
  }

}
