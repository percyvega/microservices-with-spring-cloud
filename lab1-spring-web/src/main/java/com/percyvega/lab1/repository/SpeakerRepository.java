package com.percyvega.lab1.repository;

import com.percyvega.lab1.model.Greeting;
import com.percyvega.lab1.model.Speaker;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

  List<Speaker> findSpeakersByFavorites(Greeting favorite);
}
