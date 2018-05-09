package com.percyvega.mwsc;

import com.percyvega.mwsc.model.Classroom;
import com.percyvega.mwsc.model.Greeting;
import com.percyvega.mwsc.model.Language;
import com.percyvega.mwsc.model.Speaker;
import com.percyvega.mwsc.repository.ClassroomRepository;
import com.percyvega.mwsc.repository.GreetingRepository;
import com.percyvega.mwsc.repository.SpeakerRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  private final GreetingRepository greetingRepository;
  private final SpeakerRepository speakerRepository;
  private final ClassroomRepository classroomRepository;

  @Autowired
  public Application(GreetingRepository greetingRepository, SpeakerRepository speakerRepository,
      ClassroomRepository classroomRepository) {
    this.greetingRepository = greetingRepository;
    this.speakerRepository = speakerRepository;
    this.classroomRepository = classroomRepository;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @PostConstruct
  public void postConstruct() {

    // GREETINGS
    final List<Greeting> GREETINGS = Arrays.asList(
        new Greeting("Hello!", Language.English),
        new Greeting("Hi!", Language.English),
        new Greeting("Hey!", Language.English),
        new Greeting("Good morning!", Language.English),
        new Greeting("Hola!", Language.Spanish),
        new Greeting("Buenas noches!", Language.Spanish),
        new Greeting("Bonjour!", Language.French),
        new Greeting("Bonsoir!", Language.French),
        new Greeting("Salut!", Language.French),
        new Greeting("Olá!", Language.Portuguese)
    );

    GREETINGS.forEach(greeting -> {
      System.out.println(greetingRepository.save(greeting));
    });

    // SPEAKERS
    final List<Greeting> spanishGreetings = greetingRepository.findAllByLanguage(Language.Spanish);
    final List<Greeting> frenchGreetings = greetingRepository.findAllByLanguage(Language.French);
    final List<Greeting> englishGreetings = greetingRepository.findAllByLanguage(Language.English);
    final List<Greeting> portugueseGreetings = greetingRepository
        .findAllByLanguage(Language.Portuguese);

    final ArrayList<Greeting> portugueseAndSpanishGreetings = new ArrayList<>(portugueseGreetings);
    portugueseAndSpanishGreetings.addAll(spanishGreetings);

    final List<Speaker> SPEAKERS = Arrays.asList(
        new Speaker("Percy", spanishGreetings),
        new Speaker("Francois", frenchGreetings),
        new Speaker("James", englishGreetings),
        new Speaker("João", portugueseAndSpanishGreetings),
        new Speaker("Ricardo", spanishGreetings),
        new Speaker("Francisco", spanishGreetings)
    );

    SPEAKERS.forEach(speaker -> {
      System.out.println(speakerRepository.save(speaker));
    });

    // CLASSROOMS
    final Speaker speaker11 = speakerRepository.getOne(11L);
    final Speaker speaker12 = speakerRepository.getOne(12L);
    final Speaker speaker13 = speakerRepository.getOne(13L);
    final Speaker speaker14 = speakerRepository.getOne(14L);
    final Speaker speaker15 = speakerRepository.getOne(15L);
    final Speaker speaker16 = speakerRepository.getOne(16L);
    final List<Classroom> CLASSROOMS = Arrays.asList(
        new Classroom("English Grammar", Arrays.asList(speaker11, speaker12, speaker13, speaker14)),
        new Classroom("Portuguese III", Arrays.asList(speaker11, speaker12, speaker16)),
        new Classroom("French Pronunciation", Arrays.asList(speaker15))
    );

    CLASSROOMS.forEach(classroom -> {
      System.out.println(classroomRepository.save(classroom));
    });

  }
}
