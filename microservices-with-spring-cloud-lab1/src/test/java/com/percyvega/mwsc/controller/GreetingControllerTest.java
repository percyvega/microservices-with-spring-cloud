package com.percyvega.mwsc.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.percyvega.mwsc.model.Greeting;
import java.net.InetAddress;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GreetingControllerTest {

  @LocalServerPort
  private int port;

  private String appPath;

  @Before
  public void setUp() throws Exception {
    String host = InetAddress.getLocalHost().getHostAddress();
    appPath = "http://" + host + ":" + port;
  }

  // ------------------------------------------------------------------------------------------------

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void randomGreeting() {
    Greeting greeting = restTemplate.getForObject(appPath + "/greetings/random", Greeting.class);
    System.out.println(greeting);

    assertThat(greeting).isNotNull();
    assertThat(greeting).hasFieldOrProperty("salutation");
  }

  // ------------------------------------------------------------------------------------------------

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void greetings() throws Exception {
    mockMvc.perform(get("/greetings").accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.[0].salutation").value("Hello!"));
  }

}
