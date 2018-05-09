package com.percyvega.mwsc.service;

import com.percyvega.mwsc.model.Speaker;
import com.percyvega.mwsc.repository.SpeakerRepository;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeakerService {

  private SpeakerRepository speakerRepository;

  private Random random = new Random();

  @Autowired
  public SpeakerService(SpeakerRepository speakerRepository) {
    this.speakerRepository = speakerRepository;
  }

  public Speaker getRandomSpeaker() {
    List<Speaker> list = getSpeakers();
    if (list.size() > 0) {
      return list.get(random.nextInt(list.size()));
    } else {
      return null;
    }
  }

  public Speaker getSpeaker(Long id) {
    Optional<Speaker> optionalSpeaker = speakerRepository.findById(id);
    return optionalSpeaker.orElse(null);
  }

  public List<Speaker> getSpeakers() {
    return speakerRepository.findAll();
  }
}
