package com.nterra.springbootadvanced.profiles;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DevLoggingTest {

  @Test
  public void testLogging() {
    List<String> logList = new ArrayList<>();
    Logging logging = new Logging(logList);
    logging.logSomething();
    assertEquals(5, logList.size());
  }
}