package com.percyvega.mwsc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speaker {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  @ManyToMany
  private List<Greeting> favorites = new ArrayList<>();

  public Speaker(String name, List<Greeting> favorites) {
    this.name = name;
    this.favorites.addAll(favorites);
  }
}
