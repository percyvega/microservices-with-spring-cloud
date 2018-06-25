package com.percyvega.lab3server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@SpringBootApplication
public class Lab3ConfigServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lab3ConfigServerApplication.class, args);
  }

  @RestController
  class Test {

    @Value("${spring.cloud.config.server.git.uri}")
    String gitUri;

    @GetMapping
    public String root() {
      System.out.println(gitUri);
      return "Config Server Git Uri: " + gitUri;
    }
  }

}
