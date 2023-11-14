package com.nterra.springbootadvanced.profiles;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.Appender;
import ch.qos.logback.core.AppenderBase;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Logging {
  private static final Logger log = (Logger) LoggerFactory.getLogger(Logging.class);
  private final List logList;

  public Logging(List logList) {
    this.logList = logList;
  }

  public void logSomething() {

    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
    Appender<ILoggingEvent> memAppender =
        new AppenderBase<>() {
          @Override
          protected void append(ILoggingEvent iLoggingEvent) {
            logList.add(iLoggingEvent.getMessage());
          }
        };
    memAppender.setContext(lc);
    memAppender.start();

    Logger logbackLogger = log;
    logbackLogger.addAppender(memAppender);

    log.trace("trace");
    log.debug("debug");
    log.info("info");
    log.warn("warn");
    log.error("error");
  }
}
