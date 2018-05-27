package com.percyvega.lab1.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.InetAddress;
import org.junit.Before;
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

  private String appPath;

  @Before
  public void setUp() throws Exception {
    String host = InetAddress.getLocalHost().getHostAddress();
    appPath = "http://" + host + ":" + port;
  }

  @Test
  public void controllerShouldReturnDefaultMessage() {
    assertThat(restTemplate
        .getForObject(appPath + "/greeterResponseBodyController", String.class))
        .isEqualTo("Hello, World!");
  }
}
