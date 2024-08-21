package ru.job4j.s_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SServiceApplication.class, args);
    }
}
