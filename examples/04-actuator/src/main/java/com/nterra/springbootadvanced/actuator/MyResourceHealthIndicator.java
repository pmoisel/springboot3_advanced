package com.nterra.springbootadvanced.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyResourceHealthIndicator implements HealthIndicator {

  @Autowired
  HealthToggleController c;

  @Override
  public Health health() {
    if (c.up) {
      return Health
          .up()
          .withDetail("owner", "Philipp Moisel")
          .build();
    } else {
      return Health
          .down()
          .withDetail("owner", "Philipp Moisel")
          .build();
    }
  }
}
