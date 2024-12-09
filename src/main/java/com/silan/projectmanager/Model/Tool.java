package com.silan.projectmanager.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"tool\"")
public class Tool {

  // _________________________________________________
  // Model
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private long projectParentId;

  @Column
  private String toolNumber;

  @Column
  private String title;

  @Column
  private String description;

  // Child Relations
  @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
  private List<Task> tasks;

  // Parent Relations
  @ManyToOne
  @JoinColumn(name = "project_id", nullable = false)
  @JsonBackReference
  private Project project;

  // _________________________________________________
  // Getters & Setters

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getProjectParentId() {
    return projectParentId;
  }

  public void setProjectParentId(long projectParentId) {
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
