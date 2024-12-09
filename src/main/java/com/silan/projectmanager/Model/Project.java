package com.silan.projectmanager.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "\"project\"")
public class Project {

  // _________________________________________________
  // Model
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String title;

  @Column
  private String poNumber;

  @Column
  private String jobNumber;

  @Column
  private int value;

  // Relations
  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Tool> tools;

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

  public String getPoNumber() {
    return poNumber;
  }

  public void setPoNumber(String poNumber) {
    this.poNumber = poNumber;
  }

  public String getJobNumber() {
    return jobNumber;
  }

  public void setJobNumber(String jobNumber) {
    this.jobNumber = jobNumber;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public List<Tool> getTools() {
    return tools;
  }

  public void setTools(List<Tool> tools) {
    this.tools = tools;
  }

}
