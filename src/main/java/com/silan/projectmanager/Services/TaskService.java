package com.silan.projectmanager.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.f4b6a3.ulid.Ulid;
import com.silan.projectmanager.Model.Task;
import com.silan.projectmanager.Repo.TaskRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
  
  @Autowired
  private TaskRepo taskRepo;

  public List<Task> getAllTasks() {
    return taskRepo.findAll();
  }

  public Optional<Task> getTaskById(Ulid id) {
    return taskRepo.findById(id);
  }

}
