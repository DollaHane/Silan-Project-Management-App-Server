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

@Entity 
@Table(name = "\"customer\"")
public class Customer {

  Ulid ulid = UlidCreator.getUlid();

  // _______________________________
  // Model

  @Id
  private Ulid id = ulid;

  @Column
  private String name;

  @Column
  private String addressLine1;

  @Column
  private String addressLine2;

  @Column
  private String addressLine3;

  @Column
  private String contactPerson;

  @Column
  private int contactNumber;

  @Column 
  private String contactEmail;

  @Column
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

  public LocalDateTime getUpdatedAt(){
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
