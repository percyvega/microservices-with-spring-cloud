package com.percyvega.mwsc.repository;

import com.percyvega.mwsc.model.Greeting;
import com.percyvega.mwsc.model.Speaker;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {

  List<Speaker> findSpeakersByFavorites(Greeting favorite);
}
