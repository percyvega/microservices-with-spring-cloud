package com.percyvega.mwsc.service;

import com.percyvega.mwsc.model.Greeting;
import com.percyvega.mwsc.model.Language;
import com.percyvega.mwsc.repository.GreetingRepository;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

  private GreetingRepository service;
  private Random random = new Random();

  @Autowired
  public GreetingService(GreetingRepository service) {
    this.service = service;
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
    Optional<Greeting> optionalGreeting = service.findById(id);
    if(optionalGreeting.isPresent()) {
      return optionalGreeting.get();
    } else {
      return null;
    }
  }

  public List<Greeting> getGreetings() {
    return service.findAll();
  }

  public List<Greeting> getGreetings(Language language) {
    return service.findAllByLanguage(language);
  }
}
