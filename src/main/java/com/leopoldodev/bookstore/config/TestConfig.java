package com.leopoldodev.bookstore.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@RequiredArgsConstructor
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

    }
}
