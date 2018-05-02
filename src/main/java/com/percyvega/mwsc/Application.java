package com.percyvega.mwsc;

import com.percyvega.mwsc.model.Greeting;
import com.percyvega.mwsc.model.Language;
import com.percyvega.mwsc.repository.GreetingRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  private final GreetingRepository repository;

  @Autowired
  public Application(GreetingRepository repository) {
    this.repository = repository;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  CommandLineRunner init(GreetingRepository repository) {
    return (evt) -> Arrays.asList(
        new Greeting("Hello!", Language.English),
        new Greeting("Hi!", Language.English),
        new Greeting("Hey!", Language.English),
        new Greeting("Good morning!", Language.English),
        new Greeting("Hola!", Language.Spanish),
        new Greeting("Buenas noches!", Language.Spanish),
        new Greeting("Bonjour!", Language.French),
        new Greeting("Bonsoir!", Language.French),
        new Greeting("Salut!", Language.French))
        .forEach(a -> {
          repository.save(a);
        });
  }
}
