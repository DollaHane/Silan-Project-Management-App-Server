package com.silan.projectmanager.Model;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@Table(name = "\"session\"")
public class Session {

  Ulid ulid = UlidCreator.getUlid();

  // ____________________________________
  // Models

  @Id
  private Ulid id = ulid;

  @Column
  @NotBlank(message = "User ID is required")
  private Ulid userId;

  @Column
  @NotBlank(message = "Name is required")
  private String name;

  @Column
  @Email
  @NotBlank(message = "Email is required")
  private String email;

  @Column
  @NotBlank(message = "Token is required")
  private String token;

  @Column
  @NotBlank(message = "Expiration Date is required")
  private LocalDateTime expiration;

  // Child Relations
  @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Users> users;

  // ____________________________________
  // Getters & Setters

  public Ulid getId() {
    return id;
  }

  public void setId(Ulid id) {
    this.id = id;
  }

  public Ulid getUserId() {
    return userId;
  }

  public void setUserId(Ulid userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public LocalDateTime getExpiration() {
    return expiration;
  }

  public void setExpiration(LocalDateTime expiration) {
    this.expiration = expiration;
  }

  // 'user' (Child Relation)
  public List<Users> getUsers() {
    return users;
  }

  public void setUsers(List<Users> users) {
    this.users = users;
  }

}
