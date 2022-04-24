package com.week3team2.lectureservice.repository;

import com.week3team2.lectureservice.entity.Lecture;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends ReactiveCrudRepository<Lecture, Integer> {
}
