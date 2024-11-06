package com.jalasoft.movierental.entity;

import java.util.UUID;

public class Customer {
  private UUID id;
  private String name;

  public Customer() {
  }

  public Customer(String name) {
    this.id = UUID.randomUUID();
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
