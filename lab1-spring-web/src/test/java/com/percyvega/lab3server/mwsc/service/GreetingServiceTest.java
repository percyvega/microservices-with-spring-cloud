package com.percyvega.lab1.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.percyvega.lab1.model.Greeting;
import com.percyvega.lab1.model.Language;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GreetingServiceTest {

  @Autowired
  private GreetingService greetingService;

  @Test
  public void getList() {
    assertThat(greetingService.getGreetings()).containsAnyOf(new Greeting(1L, "Hello!", Language.English));
  }
}
