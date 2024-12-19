package com.silan.projectmanager.Model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "\"customer\"")
public class Customer {

  Ulid ulid = UlidCreator.getUlid();

  // ____________________________________
  // Models

  @Id
  private Ulid id = ulid;

  @Column
  @NotBlank(message = "Company name is required")
  @Size(min = 3, max = 199, message = "Company name must be between 3 and 199 characters")
  private String name;

  @Column
  @NotBlank(message = "Address Line is required")
  @Size(min = 3, max = 199, message = "Address Line must be between 3 and 199 characters")
  private String addressLine1;

  @Column
  @NotBlank(message = "Address Line is required")
  @Size(min = 3, max = 199, message = "Address Line must be between 3 and 199 characters")
  private String addressLine2;

  @Column
  @NotBlank(message = "Address Line is required")
  @Size(min = 3, max = 199, message = "Address Line must be between 3 and 199 characters")
  private String addressLine3;

  @Column
  @NotBlank(message = "Contact person is required")
  @Size(min = 3, max = 199, message = "Contact person must be between 3 and 199 characters")
  private String contactPerson;

  @Column
  @Min(value = 3, message = "Contact number must be at least 3")
  @Max(value = 199, message = "Contact number must not exceed 199")
  private int contactNumber;

  @Column
  @NotBlank(message = "Contact email is required")
  @Size(min = 3, max = 199, message = "Contact email must be between 3 and 199 characters")
  private String contactEmail;

  @Column
  @NotBlank(message = "Admin email is required")
  @Size(min = 3, max = 199, message = "Admin email must be between 3 and 199 characters")
  private String adminEmail;

  @Column
  private LocalDateTime createdAt;

  @Column
  private LocalDateTime updatedAt;

  // Child Relations
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Project> projects;

  // _______________________________________________________
  // Getters & Setters

  public Ulid getId() {
    return id;
  }

  public void setId(Ulid id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String addressLine1() {
    return addressLine1;
  }

  public void setAddressLine1(String addressLine1) {
    this.addressLine1 = addressLine1;
  }

  public String addressLine2() {
    return addressLine2;
  }

  public void setAddressLine2(String addressLine2) {
    this.addressLine2 = addressLine2;
  }

  public String addressLine3() {
    return addressLine1;
  }

  public void setAddressLine3(String addressLine3) {
    this.addressLine3 = addressLine3;
  }

  public String getContactPerson() {
    return contactPerson;
  }

  public void setContactPerson(String contactPerson) {
    this.contactPerson = contactPerson;
  }

  public int getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(int contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getContactEmail() {
    return contactEmail;
  }

  public void setContactEmail(String contactEmail) {
    this.contactEmail = contactEmail;
  }

  public String getAdminEmail() {
    return adminEmail;
  }

  public void setAdminEmail(String adminEmail) {
    this.adminEmail = adminEmail;
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

  // 'projects' (Child Relations)
  public List<Project> getProjects() {
    return projects;
  }

  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

}
