package com.microservices.demo.pocazureeventhub;

import com.azure.spring.messaging.implementation.annotation.EnableAzureMessaging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableAzureMessaging
public class PocAzureEventHubApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(PocAzureEventHubApplication.class, args);
    }

}
