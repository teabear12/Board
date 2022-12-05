package com.sparta.basic_crud_10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BasicCrud10Application {

    public static void main(String[] args) {
        SpringApplication.run(BasicCrud10Application.class, args);
    }

}