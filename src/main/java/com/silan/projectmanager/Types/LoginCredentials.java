package com.silan.projectmanager.Types;

import jakarta.validation.constraints.*;

public class LoginCredentials {

  // Email
  @NotBlank
  @Email
  private String email;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // Password
  @NotBlank
  private String password;

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public LoginCredentials(String email, String password) {
    this.email = getEmail();
    this.password = getPassword();
  }

}
