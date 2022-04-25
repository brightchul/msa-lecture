package com.week3team2.lectureservice.repository;

import com.week3team2.lectureservice.model.Lecture;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

@Component
public interface LectureRepository extends ReactiveCrudRepository<Lecture, Integer> {

    @Query("select * from lecture where lectureId = :lectureId")
    Mono<Lecture> findByLectureId(String lectureId);

}
