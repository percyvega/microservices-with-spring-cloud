package com.percyvega.lab1.controller;

import com.percyvega.lab1.model.Speaker;
import com.percyvega.lab1.service.SpeakerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeakerController {

  private final SpeakerService speakerService;

  @Autowired
  public SpeakerController(SpeakerService speakerService) {
    this.speakerService = speakerService;
  }

  @GetMapping("/speakers/random")
  public Speaker randomSpeaker() {
    return speakerService.getRandomSpeaker();
  }

  @GetMapping("/speakers/{id}")
  public Speaker speaker(@PathVariable(name = "id") Long id) {
    return speakerService.getSpeaker(id);
  }

  @GetMapping(value = "/speakers")
  public List<Speaker> speakers() {
    return speakerService.getSpeakers();
  }
}
