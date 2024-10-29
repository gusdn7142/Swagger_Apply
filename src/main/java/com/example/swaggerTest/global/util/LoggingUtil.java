package com.example.swaggerTest.global.util;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingUtil {
    public static void logData(String name, Object value) {
        if (value != null) {
            log.info("<--- {} ---> : {}", name, value.toString());
        } else {
            log.info("<--- {} ---> : {}", name, null);
        }
    }
}
