package com.percyvega.lab1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreeterController {

  @GetMapping("/greeterController")
  public String greetController(
      @RequestParam(name = "name", required = false, defaultValue = "World") String name,
      Model model) {
    model.addAttribute("name", name);
    return "hello";
  }

}
