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

    @Autowired
    LectureContentRepository lectureContentRepository;

    @Test
    void readsAllContentsCorrectly() {
        StepVerifier.create(lectureContentRepository.findAll())
                .assertNext(o -> assertEquals("test1", o.getContentName()))
                .assertNext(o -> assertEquals("test2", o.getContentName()))
                .assertNext(o -> assertEquals("test2", o.getContentName()))
                .verifyComplete();
    }

}