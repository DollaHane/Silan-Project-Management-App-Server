package com.silan.projectmanager.Model;

import java.time.LocalDateTime;
// import java.util.List;
// import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"task\"")
public class Task {

  // _________________________________________________
  // Model
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String title;

  @Column
  private String responsible;

  @Column
  private String status;

  @Column
  private LocalDateTime targetDate;

  @Column
  private boolean flag = false;

  // Parent Relations
  @ManyToOne
  @JoinColumn(name = "tool_id")
  private Tool tool;

  // _________________________________________________
  // Getters & Setters

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalDateTime getTargetDate() {
    return targetDate;
  }

  public void setTargetDate(LocalDateTime targetDate) {
    this.targetDate = targetDate;
  }

  public boolean getFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  // 'tool' (Parent Relation)
  public Tool getTool() {
    return tool;
  }

  public void setTool(Tool tool) {
    this.tool = tool;
  }

}
