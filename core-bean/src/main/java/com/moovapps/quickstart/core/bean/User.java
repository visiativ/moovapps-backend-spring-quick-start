package com.moovapps.quickstart.core.bean;

public class User {

  private final String email;
  private final String firstName;
  private final String lastName;

  public User(String email, String firstName, String lastName) {
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }
}
