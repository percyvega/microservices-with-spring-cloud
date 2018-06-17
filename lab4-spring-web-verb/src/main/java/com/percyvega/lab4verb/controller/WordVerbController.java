package com.percyvega.lab4verb.controller;

import java.util.Random;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordVerbController {

  @Value("${words}")
  private String words;

  private Random random = new Random();

  @GetMapping
  public @ResponseBody
  String getWord() {
    String[] wordArray = words.split(",");
    return wordArray[random.nextInt(wordArray.length)];
  }
}
