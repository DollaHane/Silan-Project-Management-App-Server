package com.silan.projectmanager.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "\"note\"")
public class Note {

  Ulid ulid = UlidCreator.getUlid();

  // ___________________________________
  // Model
  @Id
  private Ulid id = ulid;

  @Column
  @NotBlank(message = "Note text is required")
  @Size(min = 3, max = 199, message = "Note text must be between 3 and 199 characters")
  private String text;

  @Column
  private LocalDateTime createdAt;

  @Column
  private LocalDateTime updatedAt;

  // Parent Relations
  @ManyToOne
  @JoinColumn(name = "task_id", nullable = false)
  @JsonBackReference
  private Task task;

  @ManyToOne
  @JoinColumn(name = "tool_id", nullable = false)
  @JsonBackReference
  private Tool tool;

  // _____________________________________________
  // Getters & Setters

  public Ulid getId() {
    return id;
  }

  public void setId(Ulid id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
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

  // 'task' (Parent Relation)
  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  // 'tool' (Parent Relation)
  public Tool getTool() {
    return tool;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

}
