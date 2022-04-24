package com.week3team2.lectureservice.service;

import com.week3team2.lectureservice.entity.Lecture;
import com.week3team2.lectureservice.model.LectureFactory;
import com.week3team2.lectureservice.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;
    private final LectureFactory lectureFactory;


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

    @Override
    public Flux<Lecture> getLectureAllList() {
        return lectureRepository.findAll();
    }
}
