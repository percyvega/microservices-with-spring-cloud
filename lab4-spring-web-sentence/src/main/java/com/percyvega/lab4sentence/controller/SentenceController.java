package com.percyvega.lab4sentence.controller;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SentenceController {

  @Autowired
  DiscoveryClient discoveryClient;

  private RestTemplate restTemplate = new RestTemplate();

  @GetMapping
  public @ResponseBody String getSentence() {
    return
        getWord("lab4-spring-web-subject") + " " +
        getWord("lab4-spring-web-verb") + " " +
        getWord("lab4-spring-web-article") + " " +
        getWord("lab4-spring-web-adjective") + " " +
        getWord("lab4-spring-web-noun");
  }

  private String getWord(String serviceName) {
    List<ServiceInstance> list = discoveryClient.getInstances(serviceName);

    if(list != null && list.size() > 0) {
      URI uri = list.get(0).getUri();

      if(uri != null) {
        return restTemplate.getForObject(uri, String.class);
      }
    }

    return null;
  }
}
