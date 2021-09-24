package com.example.sbstudentclientlab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class StudentClient {

    private final WebClient webClient;

    @Autowired
    public StudentClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Student getStudentById(Long id) {
        return webClient.get()
                .uri("/students/{id}", id)
                .retrieve()
                .bodyToMono(Student.class)
                .block();

    }
}
