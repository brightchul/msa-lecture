package com.week3team2.lectureservice.repository;

import com.week3team2.lectureservice.handler.TeacherHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class LectureContentRepositoryTest {

    private WebTestClient webTestClient;

    @Autowired
    LectureContentRepository lectureContentRepository;

    @Autowired
    private TeacherHandler teacherHandler;

    @Test
    void readsAllEntitiesCorrectly() {
        StepVerifier.create(lectureContentRepository.findAll())
                .assertNext(o -> assertEquals(o.getContentName(), "test1"))
                .assertNext(o -> assertEquals(o.getContentName(), "test2"))
                .verifyComplete();
    }

}