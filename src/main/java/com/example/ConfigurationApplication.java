package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationApplication implements CommandLineRunner {

    @Autowired
    private ConfigurationApplicationSettings demoApplicationSettings;

    @Override
    public void run(String... args) {
        System.out.println(demoApplicationSettings);
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationApplication.class, args);
    }
}
