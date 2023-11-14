package com.nterra.springbootadvanced.tracing;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.AppenderBase;

import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RestEndpoint {

    private static final Logger log = (Logger) LoggerFactory.getLogger(RestEndpoint.class);
    private final List logList;
    private boolean isAppenderInitialized = false;

    public RestEndpoint(@Qualifier("logList") List logList) {
        this.logList = logList;
    }

    @GetMapping
    public void log() {
        if (!isAppenderInitialized) {
            Appender<ILoggingEvent> memAppender = getAppender();
            Logger logbackLogger = log;
            logbackLogger.addAppender(memAppender);
            isAppenderInitialized = true;
        }
        log.info("This is a logstatement!");
    }

    private Appender<ILoggingEvent> getAppender() {
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        Appender<ILoggingEvent> memAppender = new AppenderBase<>() {
            @Override
            protected void append(ILoggingEvent iLoggingEvent) {
                logList.add(iLoggingEvent);
            }
        };
        memAppender.setContext(lc);
        memAppender.start();
        return memAppender;
    }
}
