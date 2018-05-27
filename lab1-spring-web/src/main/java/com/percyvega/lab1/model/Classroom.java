package com.percyvega.lab1.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "students")
public class Classroom {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @ManyToMany
  private List<Speaker> students = new ArrayList<>();

  public Classroom(String name, List<Speaker> students) {
    this.name = name;
    this.students.addAll(students);
  }
}
