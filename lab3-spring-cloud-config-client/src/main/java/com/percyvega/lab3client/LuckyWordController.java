package com.percyvega.lab3client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckyWordController {

  @Value("${lucky-word}")
  private String luckyWord;

  @GetMapping
  public String showLuckyWord() {
    return "The lucky word is: " + luckyWord;
  }

}
