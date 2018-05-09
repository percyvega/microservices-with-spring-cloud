package com.percyvega.mwsc.service;

import com.percyvega.mwsc.model.Greeting;
import com.percyvega.mwsc.model.Language;
import com.percyvega.mwsc.model.Speaker;
import com.percyvega.mwsc.repository.GreetingRepository;
import com.percyvega.mwsc.repository.SpeakerRepository;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

  private GreetingRepository greetingRepository;
  private SpeakerRepository speakerRepository;
  private Random random = new Random();

  @Autowired
  public GreetingService(GreetingRepository greetingRepository, SpeakerRepository speakerRepository) {
    this.greetingRepository = greetingRepository;
    this.speakerRepository = speakerRepository;
  }

  public Greeting getRandomGreeting() {
    List<Greeting> list = getGreetings();
    if (list.size() > 0) {
      return list.get(random.nextInt(list.size()));
    } else {
      return null;
    }
  }

  public Greeting getGreeting(Long id) {
    Optional<Greeting> optionalGreeting = greetingRepository.findById(id);
    return optionalGreeting.orElse(null);
  }

  public List<Greeting> getGreetings() {
    return greetingRepository.findAll();
  }

  public List<Greeting> getGreetings(Language language) {
    return greetingRepository.findAllByLanguage(language);
  }

  public List<Speaker> getGreetingSpeakers(Long id) {
    return speakerRepository.findSpeakersByFavorites(greetingRepository.getOne(id));
  }
}
