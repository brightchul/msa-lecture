package com.week3team2.lectureservice.repository;

import com.week3team2.lectureservice.entity.Lecture;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public interface LectureRepository extends ReactiveCrudRepository<Lecture, Integer> {

    @Query("select * from lecture where lectureId = :lectureId")
    Mono<Lecture> findByLectureId(String lectureId);

    @Query("select * from lecture where memberId = :memberId")
    Mono<Lecture> findByMemberId(String memberId);

    @Query("update lecture set lectureShowYn = :lectureShowYn where lectureId = :lectureId")
    Mono<Lecture> changeLectureShowYn(Integer lectureId, Boolean lectureShowYn);

    // 강의 테이블(LECTURE)의 lecture_total_score 컬럼 데이터를 조회

    @Query("select lectureTotalScore from lecture where lectureId = :lectureId")
    Mono<Lecture> getTotalScore(Integer lectureId);

    @Query("select * from lecture where memberId = $1")
    Flux<Lecture> findAllByMemberId(Integer memberId);
}
