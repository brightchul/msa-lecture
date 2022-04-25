package com.week3team2.lectureservice.service;

import com.week3team2.lectureservice.entity.Lecture;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LectureServiceTest {

    @Autowired
    LectureService lectureService;

    @Test
    void getLectureAllListTest() {
        Flux<Lecture> result = lectureService.getLectureAllList();
        StepVerifier.create(result)
                .assertNext(o -> assertEquals(o.getLectureName(), "testName"))
                .assertNext(o -> assertEquals(o.getLectureName(), "테스트강의"))
                .verifyComplete();
    }

}