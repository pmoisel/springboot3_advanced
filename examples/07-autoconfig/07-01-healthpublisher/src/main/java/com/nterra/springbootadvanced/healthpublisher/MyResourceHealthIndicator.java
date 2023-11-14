package com.nterra.springbootadvanced.healthpublisher;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class MyResourceHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health
                .up()
                .withDetail("The healthpublisher", "published this")
                .build();

    }
}
