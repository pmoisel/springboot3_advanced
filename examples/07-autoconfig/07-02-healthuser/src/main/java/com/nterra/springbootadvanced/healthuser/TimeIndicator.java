package com.nterra.springbootadvanced.healthuser;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class TimeIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health
                .up()
                .withDetail("time", System.currentTimeMillis())
                .build();

    }
}
