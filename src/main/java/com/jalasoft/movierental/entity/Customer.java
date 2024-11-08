package com.jalasoft.movierental.entity;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  private UUID id;
  private String name;

  public Customer(String name) {
    this.id = UUID.randomUUID();
    this.name = name;
  }
}
