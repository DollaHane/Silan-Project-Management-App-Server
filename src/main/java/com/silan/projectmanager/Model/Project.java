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
import jakarta.validation.constraints.*;

@Entity
@Table(name = "\"project\"")
public class Project {

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
  @NotBlank(message = "PO Number is required")
  @Min(value = 3, message = "PO Number must be longer than 3 characters")
  @Max(value = 199, message = "PO Number must be shorter than 199 characters")
  private String poNumber;

  @Column
  @NotBlank(message = "Job number is required")
  @Min(value = 3, message = "Job number must be longer than 3 characters")
  @Max(value = 199, message = "Job number must be shorter than 199 characters")
  private String jobNumber;

  @Column
  @NotBlank(message = "Project Value is required")
  @Min(value = 3, message = "Project Value must be longer than 3 characters")
  @Max(value = 199, message = "Project Value must be shorter than 199 characters")
  private int value;

  @Column
  private LocalDateTime deliveryDate;

  @Column
  private LocalDateTime createdAt;

  @Column
  private LocalDateTime updatedAt;

  // Child Relations
  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Tool> tools;

  // Parent Relations
  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  @JsonBackReference
  private Customer customer;

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

  public LocalDateTime getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(LocalDateTime deliveryDate) {
    this.deliveryDate = deliveryDate;
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

  // 'tools' (Child Relations)

  public List<Tool> getTools() {
    return tools;
  }

  public void setTools(List<Tool> tools) {
    this.tools = tools;
  }

}
