package com.example;

import org.axonframework.springboot.autoconfig.AxonServerAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = AxonServerAutoConfiguration.class)
public class BasicWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicWalletApplication.class, args);
    }

}

