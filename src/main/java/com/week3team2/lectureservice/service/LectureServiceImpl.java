package com.week3team2.lectureservice.service;

import com.week3team2.lectureservice.model.Lecture;
import com.week3team2.lectureservice.repository.LectureRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    // 수강자 성적 입력
    @Override
    public Mono<Lecture> updateStudentScore(Lecture lecture) {
        return null;
    }

    // 시험 컨텐츠 추가
    @Override
    public Mono<Lecture> updateNewTest(Lecture lecture) {
        return null;
    }

    // 강의 컨텐츠 업로드
    @Override
    public Mono<Lecture> uploadContent(Lecture lecture) {
        return null;
    }

    // 강사에 매칭된 강의 목록 조회
    @Override
    public Mono<Lecture> getLectureOnTeacher(Lecture lecture) {
        return null;
    }

}
