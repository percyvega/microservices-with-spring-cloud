package com.percyvega.mwsc.repository;

import com.percyvega.mwsc.model.Greeting;
import com.percyvega.mwsc.model.Language;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {
  List<Greeting> findAllByLanguage(Language language);
}
