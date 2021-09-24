package com.example.sbstudentclientlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SbStudentClientLabApplication {
    @Bean
    WebClient getWebClient(WebClient.Builder builder){
       return builder.baseUrl("http://localhost:8080").build();
    }

    public static void main(String[] args) {
        SpringApplication.run(SbStudentClientLabApplication.class, args);
    }

}
