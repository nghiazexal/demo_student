package com.example.demo_student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoStudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStudentApplication.class, args);
    }
    @Bean
    public RestTemplate restTesmplate() {
        return new RestTemplate();
    }
}
