package com.nterra.springbootadvanced.tracing;

import ch.qos.logback.classic.spi.ILoggingEvent;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TracingApplication {

    List<ILoggingEvent> logList = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(TracingApplication.class, args);
	}


    @Bean(name = "logList")
    public List<ILoggingEvent> logList() {
        return logList;
    }
}
