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

    @Autowired
    LectureService lectureService;

    @Test
    void readsAllEntitiesCorrectly() {
        StepVerifier.create(repository.findAll())
                .assertNext(o -> assertEquals(o.getLectureName(), "스프링 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "마이크로 서비스 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "자바 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "데이터베이스 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "네트워크 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "알고리즘 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "자료구조 강의")).verifyComplete();
    }
    @Test
    void testGetLectureAllList() {
        Flux<Lecture> result  = lectureService.getLectureAllList();
        StepVerifier.create(result)
                .assertNext(o -> assertEquals(o.getLectureName(), "스프링 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "마이크로 서비스 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "자바 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "데이터베이스 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "네트워크 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "알고리즘 강의"))
                .assertNext(o -> assertEquals(o.getLectureName(), "자료구조 강의")).verifyComplete();
    }
}