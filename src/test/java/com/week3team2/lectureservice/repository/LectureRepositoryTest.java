package com.week3team2.lectureservice.repository;

import com.week3team2.lectureservice.entity.Lecture;
import com.week3team2.lectureservice.service.LectureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class LectureRepositoryTest {

    @Autowired
    LectureRepository repository;


    @Test
    void readsAllEntitiesCorrectly() {
        StepVerifier.create(repository.findAll())
                .assertNext(o -> assertEquals(o.getLectureName(), "testName"))
                .assertNext(o -> assertEquals(o.getLectureName(), "테스트강의"))
                .verifyComplete();
    }

}