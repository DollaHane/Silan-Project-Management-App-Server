package com.silan.projectmanager.Types;

import java.time.LocalDateTime;

public class LoginResponse {
  private String userId;
  private String email;
  private String name;
  private LocalDateTime expiration;

  public String getUserId(){
    return this.userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName(){
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDateTime getExpiration() {
    return this.expiration;
  }

  public void setExpiration(LocalDateTime expiration) {
    this.expiration = expiration;
  }

}
