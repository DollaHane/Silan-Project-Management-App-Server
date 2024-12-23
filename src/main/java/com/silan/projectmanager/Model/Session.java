package com.silan.projectmanager.Model;

import java.time.LocalDateTime;

// import org.hibernate.annotations.UuidGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Future;
import jakarta.persistence.Id;

@Entity
@Table(name = "\"session\"")
public class Session {


  // ____________________________________
  // Models

  @Id
  private String id;

  @Column
  @NotBlank(message = "User ID is required")
  private String userId;

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
  @NotNull(message = "Expiration Date is required")
  @Future
  private LocalDateTime expiration;

  // ____________________________________
  // Getters & Setters

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
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

}
