package com.percyvega.mwsc.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreeterResponseBodyControllerTest {

  @Autowired
  private TestRestTemplate restTemplate;

  @LocalServerPort
  private int port;

  @Test
  public void controllerShouldReturnDefaultMessage() {
    assertThat(restTemplate
        .getForObject("http://localhost:" + port + "/greeterResponseBodyController", String.class))
        .isEqualTo("Hello, World!");
  }
}
