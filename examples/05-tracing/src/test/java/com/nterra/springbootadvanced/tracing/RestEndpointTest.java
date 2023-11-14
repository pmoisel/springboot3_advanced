package com.nterra.springbootadvanced.tracing;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import ch.qos.logback.classic.spi.ILoggingEvent;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RestEndpointTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    List<ILoggingEvent> logList;

    @BeforeEach
    public void resetLogList(){
        logList.clear();
    }

    @Test
    @Disabled
    public void testLog() throws Exception {
        mockMvc.perform(
                get("/")
        );
        assertEquals(1, logList.size());
        ILoggingEvent e = logList.get(0);
        Map<String, String> mdcPropertyMap = e.getMDCPropertyMap();
        assertEquals(2, mdcPropertyMap.size());
        assertThat(mdcPropertyMap.containsKey("traceId"));
        assertThat(mdcPropertyMap.containsKey("spanId"));
    }

    @Test
    @Disabled
    public void testLogWithHeader() throws Exception {
        String traceId = "0a7ea4ab859a5cde";
        String spandId = "9f599a0ee3ec8ca4";
        mockMvc.perform(
                get("/")
                        .header("X-B3-TraceId", traceId)
                        .header("X-B3-SpanId", spandId)
        );
        assertEquals(1, logList.size());
        ILoggingEvent e = logList.get(0);
        Map<String, String> mdcPropertyMap = e.getMDCPropertyMap();
        assertEquals(2, mdcPropertyMap.size());
        assertThat(mdcPropertyMap.containsKey("traceId"));
        assertThat(mdcPropertyMap.containsKey("spanId"));
        assertEquals(traceId, mdcPropertyMap.get("traceId"));
    }
}
