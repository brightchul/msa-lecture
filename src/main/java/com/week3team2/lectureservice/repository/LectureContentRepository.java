package com.week3team2.lectureservice.repository;

import com.week3team2.lectureservice.entity.LectureContent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface LectureContentRepository extends ReactiveCrudRepository<LectureContent, Integer> {

}