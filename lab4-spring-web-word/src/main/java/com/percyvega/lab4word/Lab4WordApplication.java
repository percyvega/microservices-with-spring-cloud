package com.percyvega.lab4word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Lab4WordApplication {

  public static void main(String[] args) {
    SpringApplication.run(Lab4WordApplication.class, args);
  }

}
