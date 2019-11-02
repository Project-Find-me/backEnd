package com.example.findme.findme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class FindMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindMeApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
        return "Home Page";
    }
}
