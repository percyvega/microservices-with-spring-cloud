package com.percyvega.lab1.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.percyvega.lab1.model.Greeting;
import com.percyvega.lab1.model.Language;
import com.percyvega.lab1.service.GreetingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class GreetingControllerMockBeanTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GreetingService greetingService;

  @Test
  public void greetingById() throws Exception {
    when(greetingService.getGreeting(2L)).thenReturn(new Greeting(2222L, "Sup!", Language.English));

    mockMvc.perform(get("/greetings/2"))
        .andDo(print())
        .andExpect(jsonPath("$.id").value("2222"))
        .andExpect(jsonPath("$.salutation").value("Sup!"))
        .andExpect(jsonPath("$.language").value("English"));
  }

}
