package com.moovapps.quickstart.core.bean;

import org.apache.commons.lang3.Validate;

public class User {

  private final String email;
  private final String firstName;
  private final String lastName;

  public User(String email, String firstName, String lastName) {
    this.email = Validate.notBlank(email);
    this.firstName = Validate.notBlank(firstName);
    this.lastName = Validate.notBlank(lastName);
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
