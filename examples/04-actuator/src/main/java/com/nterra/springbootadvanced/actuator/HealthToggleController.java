package com.nterra.springbootadvanced.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toggle")
public class HealthToggleController {

    public boolean up = true;

    @GetMapping
    public void toggle() {
        up = !up;
    }
}
