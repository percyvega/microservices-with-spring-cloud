package com.percyvega.mwsc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreeterResponseBodyController {

  @GetMapping("/greeterResponseBodyController")
  public @ResponseBody
  String greeterResponseBodyController(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
    return "Hello, " + name + "!";
  }

}
