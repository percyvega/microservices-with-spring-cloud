package com.percyvega.lab1.controller;

import com.percyvega.lab1.model.Language;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

  @GetMapping(value = "/languages")
  public Language[] languages() {
    return Language.values();
  }
}
