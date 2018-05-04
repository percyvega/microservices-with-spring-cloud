package com.percyvega.mwsc.controller;

import com.percyvega.mwsc.model.Greeting;
import com.percyvega.mwsc.model.Language;
import com.percyvega.mwsc.model.Speaker;
import com.percyvega.mwsc.service.GreetingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private final GreetingService greetingService;

  @Autowired
  public GreetingController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @GetMapping("/greetings/random")
  public Greeting randomGreeting() {
    return greetingService.getRandomGreeting();
  }

  @GetMapping(value = "/greetings")
  public List<Greeting> greetings() {
      return greetingService.getGreetings();
  }

  @GetMapping(value = "/greetings/{id}")
  public Greeting greetingById(@PathVariable(name = "id") String id) {
      return greetingService.getGreeting(Long.valueOf(id));
  }

  @GetMapping(value = "/greetings/language/{language}")
  public List<Greeting> greetingsLanguage(@PathVariable(name = "language") String name) {
    return greetingService.getGreetings(Language.valueOf(name));
  }

  @GetMapping(value = "/greetings/{id}/speakers")
  public List<Speaker> speakersByGreetingId(@PathVariable(name = "id") Long id) {
    return greetingService.getGreetingSpeakers(id);
  }
}
