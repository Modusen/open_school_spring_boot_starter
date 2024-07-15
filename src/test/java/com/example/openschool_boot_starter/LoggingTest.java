//package com.example.openschool_boot_starter;
//
//import com.example.openschool_boot_starter.interceptor.HttpRequestInterceptor;
//import org.apache.log4j.Appender;
//import org.apache.log4j.Logger;
//import org.apache.log4j.spi.LoggingEvent;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//
//@RunWith(MockitoJUnitRunner.class)
//@WebMvcTest
//public class LoggingTest {
//    @Mock
//    Appender appender;
//    TestRestTemplate testRestTemplate = new TestRestTemplate();
//    private final String URL_MAGNETIC_5_MIN = "https://services.swpc.noaa.gov/text/rtsw/data/mag-6-hour-5-minute.json";
//
//    @Test
//    public void loggingTest() {
//
//        Logger logger = Logger.getLogger(HttpRequestInterceptor.class);
//        logger.addAppender(appender);
//        testRestTemplate.getForEntity(URL_MAGNETIC_5_MIN, String[][].class);
//
//        ArgumentCaptor<LoggingEvent> eventArgumentCaptor = ArgumentCaptor.forClass(LoggingEvent.class);
//
//        Assert.assertEquals("", eventArgumentCaptor.getAllValues().isEmpty() ? "" : eventArgumentCaptor.getAllValues().get(0).getMessage());
//    }
//}