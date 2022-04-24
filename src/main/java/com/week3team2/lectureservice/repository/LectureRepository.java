package com.week3team2.lectureservice.repository;

import com.week3team2.lectureservice.model.Lecture;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface LectureRepository extends ReactiveCrudRepository<Lecture, Integer> {
}
