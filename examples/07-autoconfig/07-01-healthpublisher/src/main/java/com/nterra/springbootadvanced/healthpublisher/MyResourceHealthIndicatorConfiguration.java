package com.nterra.springbootadvanced.healthpublisher;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class MyResourceHealthIndicatorConfiguration {

  @Bean
  public MyResourceHealthIndicator myResourceHealthIndicator(){
    return new MyResourceHealthIndicator();
  }
}
