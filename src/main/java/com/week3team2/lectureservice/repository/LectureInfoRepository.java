package com.week3team2.lectureservice.repository;

import com.week3team2.lectureservice.entity.LectureInfo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public interface LectureInfoRepository extends ReactiveCrudRepository<LectureInfo, Integer> {

    @Query("select * from lectureInfo where lectureId=:lectureId and memberId=memberId")
    Mono<LectureInfo> findByLectureInfo(Integer lectureId, Integer memberId);

    @Query("select * from lectureInfo where lectureId=:lectureId")
    Flux<LectureInfo> findByLectureInfoList(Integer lectureId);
}
