package com.paypilotprojectspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PayPilotProjectSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayPilotProjectSpringApplication.class, args);
    }

}
