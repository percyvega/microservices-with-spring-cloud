package com.percyvega.mwsc.controller;

import com.percyvega.mwsc.model.Greeting;
import com.percyvega.mwsc.model.Language;
import com.percyvega.mwsc.service.GreetingService;
import java.util.List;
import java.util.Optional;
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

  @GetMapping("/greeting")
  public Greeting randomGreeting() {
    return greetingService.getRandomGreeting();
  }

  @GetMapping("/greeting/{id}")
  public Greeting greeting(@PathVariable(name = "id") Long id) {
    return greetingService.getGreeting(id);
  }

  @GetMapping(value = "/greetings")
  public List<Greeting> greetingsLanguage(
      @RequestParam(name = "language", required = false) String name) {
    if (name == null) {
      return greetingService.getGreetings();
    } else {
      return greetingService.getGreetings(Language.valueOf(name));
    }
  }

}
