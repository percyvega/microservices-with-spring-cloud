package com.percyvega.lab1.repository;

import com.percyvega.lab1.model.Greeting;
import com.percyvega.lab1.model.Language;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

  List<Greeting> findAllByLanguage(Language language);
}
