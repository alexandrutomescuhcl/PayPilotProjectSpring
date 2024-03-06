package com.paypilotprojectspring;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.ZoneOffset;
import java.util.TimeZone;

@SpringBootApplication
@Slf4j
@EnableCaching
public class PayPilotProjectSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayPilotProjectSpringApplication.class, args);
    }
    @PostConstruct
    public void postConstruct() {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
        log.info("Application TIMEZONE is " + TimeZone.getDefault().toString());
    }
}
