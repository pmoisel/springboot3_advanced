package com.nterra.springbootadvanced.profiles;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProfileApplication {
  public static void main(String[] args) {
    SpringApplication.run(ProfileApplication.class, args);
  }

  @Bean
  public List logList() {
    return new ArrayList();
  }
}
