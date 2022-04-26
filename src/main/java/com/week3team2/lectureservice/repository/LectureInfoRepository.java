package com.week3team2.lectureservice.repository;

import com.week3team2.lectureservice.entity.LectureInfo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public interface LectureInfoRepository extends ReactiveCrudRepository<LectureInfo, Integer> {

    // 강의정보 테이블에 test_score(시험점수) 값을 설정한다.
    // (현재) where 조건으로 memberId, lectureId를 주고, 데이터를 update
    @Query("update lectureInfo set testScore = :score where lectureId = :lectureId and memberId = :memberId")
    Mono<LectureInfo> updateTestScore(Integer score, Integer lectureId, Integer memberId);
}
