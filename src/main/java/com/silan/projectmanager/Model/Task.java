package com.silan.projectmanager.Model;
import com.silan.projectmanager.Types.Status.STATUS;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;
import com.silan.projectmanager.Types.Priority.PRIORITY;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "\"task\"")
public class Task {

  Ulid ulid = UlidCreator.getUlid();

  // _________________________________________________
  // Model
  @Id
  private Ulid id = ulid;

  @Column
  @NotBlank(message = "Title is required")
  @Min(value = 3, message = "Title must be longer than 3 characters")
  @Max(value = 199, message = "Title must be shorter than 199 characters")
  private String title;

  @Column
  @NotBlank(message = "Responsible is required")
  @Min(value = 3, message = "Responsible must be longer than 3 characters")
  @Max(value = 199, message = "Responsible must be shorter than 199 characters")
  private String responsible;

  @Column
  private int progress;

  @Column
  @NotBlank
  private LocalDateTime startDate;

  @Column
  @NotBlank
  private LocalDateTime targetDate;

  @Column
  private LocalDateTime createdAt;

  @Column
  private LocalDateTime updatedAt;

  @Column
  private STATUS status;


  @Column
  private PRIORITY priority;

  // Child Relations
  @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Note> notes;

  // Parent Relations
  @ManyToOne
  @JoinColumn(name = "tool_id", nullable = false)
  @JsonBackReference
  private Tool tool;

  // _________________________________________________
  // Getters & Setters

  public Ulid getId() {
    return id;
  }

  public void setId(Ulid id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getResponsible() {
    return responsible;
  }

  public void setResposible(String responsible) {
    this.responsible = responsible;
  }

  public STATUS getStatus() {
    return status;
  }

  public void setStatus(STATUS status) {
    this.status = status;
  }

  public LocalDateTime getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(LocalDateTime targetDate) {
    this.targetDate = targetDate;
  }

  public PRIORITY getPriority() {
    return priority;
  }

  public void setPriority(PRIORITY priority) {
    this.priority = priority;
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

  // 'note' (Child Relation)
  public List<Note> getNotes() {
    return notes;
  }

  public void setNotes(List<Note> notes) {
    this.notes = notes;
  }

  // 'tool' (Parent Relation)
  public Tool getTool() {
    return tool;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

}
