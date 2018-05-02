package com.percyvega.mwsc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Greeting {

  @Id
  @GeneratedValue
  private Long id;
  private String salutation;
  private Language language;

  public Greeting(String salutation, Language language) {
    this.salutation = salutation;
    this.language = language;
  }
}
