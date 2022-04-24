package com.week3team2.lectureservice.service;

import com.week3team2.lectureservice.model.Lecture;
import reactor.core.publisher.Mono;

public interface LectureService {

    // 수강자 성적 입력
    Mono<Lecture> updateStudentScore(Lecture lecture);

    // 시험 컨텐츠 추가
    Mono<Lecture> updateNewTest(Lecture lecture);

    // 강의 컨텐츠 업로드
    Mono<Lecture> uploadContent(Lecture lecture);

    // 강사에 매칭된 강의 목록 조회
    Mono<Lecture> getLectureOnTeacher(Lecture lecture);

    // 강의 개설

    // 강의에 강사 매칭

    // 강의를 학생 회원에게 노출 및 종료

    // 강의를 선택해서 수강 신청

    // 수강한 강의의 목록 조회

    // 수강 신청한 강의 컨텐츠 열람

    // 수강한 강의에 별점 남기기

    // 학생 회원이 제출한 별점을 열람
}