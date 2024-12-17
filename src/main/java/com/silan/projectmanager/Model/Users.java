package com.silan.projectmanager.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.f4b6a3.ulid.Ulid;
import com.github.f4b6a3.ulid.UlidCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "\"users\"")
public class Users {

  Ulid ulid = UlidCreator.getUlid();

  // Model
  @Id
  @NotBlank
  private Ulid id = ulid;

  @Column
  @NotBlank(message = "Name is required")
  @Max(value = 199, message = "Name must be shorter than 199 characters")
  private String name;

  @Column
  @Email
  @NotBlank(message = "Email is required")
  @Max(value = 199, message = "Email must be shorter than 199 characters")
  private String email;

  @Column
  @Email
  @Max(value = 199, message = "Email must be shorter than 199 characters")
  private String emailVerified;

  @Column
  @NotBlank(message = "Password is required")
  @Min(value = 8, message = "Password must be longer than 8 characters")
  @Max(value = 199, message = "Password must be shorter than 199 characters")
  @Pattern(regexp = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).*$", message = "Password must contain at least one uppercase letter, one number, and one special character")
  private String password;

  @Column
  @NotBlank(message = "Admin privilages required")
  private Boolean isAdmin;

  @Column
  private LocalDateTime createdAt;

  @Column
  private LocalDateTime updatedAt;

  // Parent Relations
  @OneToOne
  @JoinColumn(name = "session_id", nullable = false)
  @JsonBackReference
  private Session session;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmailVerified() {
    return emailVerified;
  }

  public void setEmailVerified(String email) {
    this.emailVerified = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Boolean getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(Boolean isAdmin) {
    this.isAdmin = isAdmin;
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

  public Session getSession() {
    return session;
  }

  public void setSession(Session session) {
    this.session = session;
  }
}
