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
  private String userId;

  @Column
  private String name;

  @Column
  private String email;

  @Column 
  private String token;

  @Column
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

  // 'user' (Child Relation)
  public List<Users> getUsers() {
    return users;
  }

  public void setUsers(List<Users> users) {
    this.users = users;
  }



  
}
