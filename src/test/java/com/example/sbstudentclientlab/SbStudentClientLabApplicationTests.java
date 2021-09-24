package com.example.sbstudentclientlab;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest
@AutoConfigureWireMock
class SbStudentClientLabApplicationTests {
    @Autowired
    private StudentClient studentClient;

    @Test
    void getStudent_forGivenStudentIsReturned() {
        Long id = 1L;
        stubFor(get("/students/" + id).willReturn(okJson("{\"id\":1, \"name\":\"Fedya\", \"grade\":10}")));
        final Student studentById = studentClient.getStudentById(id);
        then(studentById.getId()).isNotNull();
        then(studentById.getName()).isEqualTo("Fedya");
        then(studentById.getGrade()).isEqualTo(10);
    }

}
