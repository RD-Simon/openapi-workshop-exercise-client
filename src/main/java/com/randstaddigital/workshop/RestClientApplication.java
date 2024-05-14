package com.randstaddigital.workshop;

import com.randstaddigital.workshop.api.DefaultApi;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class RestClientApplication {

  private final DefaultApi client;

  public static void main(String[] args) {
    SpringApplication.run(RestClientApplication.class);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void applicationReady() {
    var result = client.stationsGet();
    System.out.println(result);
  }
}
