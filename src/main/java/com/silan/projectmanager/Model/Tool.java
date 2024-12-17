package com.silan.projectmanager.Model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "\"tool\"")
public class Tool {

  Ulid ulid = UlidCreator.getUlid();

  // _________________________________________________
  // Model
  @Id
  private Ulid id = ulid;

  @Column
  @NotBlank
  private Ulid projectParentId;

  @Column
  @NotBlank(message = "Tool number is required")
  @Min(value = 3, message = "Tool number must be longer than 3 characters")
  @Max(value = 199, message = "Tool number must be shorter than 199 characters")
  private String toolNumber;

  @Column
  @NotBlank(message = "Title is required")
  @Min(value = 3, message = "Title must be longer than 3 characters")
  @Max(value = 199, message = "Title must be shorter than 199 characters")
  private String title;

  @Column
  @NotBlank(message = "Description is required")
  @Min(value = 3, message = "Description must be longer than 3 characters")
  @Max(value = 199, message = "Description must be shorter than 199 characters")
  private String description;


  @Column
  private LocalDateTime createdAt;

  @Column
  private LocalDateTime updatedAt;

  // Child Relations
  @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Task> tasks;

  @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Note> notes;

  // Parent Relations
  @ManyToOne
  @JoinColumn(name = "project_id", nullable = false)
  @JsonBackReference
  private Project project;

  // _________________________________________________
  // Getters & Setters

  public Ulid getId() {
    return id;
  }

  public void setId(Ulid id) {
    this.id = id;
  }

  public Ulid getProjectParentId() {
    return projectParentId;
  }

  public void setProjectParentId(Ulid projectParentId) {
    this.projectParentId = projectParentId;
  }

  public String getToolNumber() {
    return toolNumber;
  }

  public void setToolNumber(String toolNumber) {
    this.toolNumber = toolNumber;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

    public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  // 'tasks' (Child Relation)
  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  // 'project' (Parent Relation)
  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
}
