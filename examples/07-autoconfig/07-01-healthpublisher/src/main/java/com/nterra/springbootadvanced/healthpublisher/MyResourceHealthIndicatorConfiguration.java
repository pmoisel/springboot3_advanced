package com.nterra.springbootadvanced.healthpublisher;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnAvailableEndpoint;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@AutoConfiguration
public class MyResourceHealthIndicatorConfiguration {

  @Bean
  @ConditionalOnAvailableEndpoint(endpoint = HealthEndpoint.class)
  public MyResourceHealthIndicator myResourceHealthIndicator(){
    return new MyResourceHealthIndicator();
  }
}
