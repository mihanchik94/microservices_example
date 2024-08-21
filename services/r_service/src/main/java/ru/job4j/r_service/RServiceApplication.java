package ru.job4j.r_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class RServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RServiceApplication.class, args);
    }
}