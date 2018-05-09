package com.percyvega.mwsc.controller;

import com.percyvega.mwsc.model.Language;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

  @GetMapping(value = "/languages")
  public Language[] languages() {
    return Language.values();
  }
}
