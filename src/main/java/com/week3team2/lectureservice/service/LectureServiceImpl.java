package com.week3team2.lectureservice.service;

import com.week3team2.lectureservice.entity.Lecture;
import com.week3team2.lectureservice.repository.LectureRepository;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
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

    @Override
    public Flux<Lecture> getLectureAllList() {
        return lectureRepository.findAll();
    }

    // 강의 개설
    @Override
    public Mono<Lecture> createLecture(Map<String, Object> param) {

        String lectureId = UUID.randomUUID().toString();
        String lectureName = (String) param.get("lectureName");
        return lectureRepository.save(
                new Lecture(lectureId, lectureName, "", "", false, 0, LocalDateTime.now(), LocalDateTime.now()));
    }

    // 강의에 강사 매칭
    @Override
    public Mono<Lecture> matchingLecture(Map<String, Object> param) {
        return lectureRepository.findByLectureId((String) param.get("lectureId"))
                .flatMap(data -> setTeacherData(data, param));
    }

    private Mono<Lecture> setTeacherData(Lecture lecture, Map<String, Object> param) {
        lecture.setLectureId((String) param.get("lectureId"));
        lecture.setMemberId((String) param.get("teacherId"));
        lecture.setLectureName((String) param.get("teacherName"));
        lecture.setUpdateDt(LocalDateTime.now());
        return lectureRepository.save(lecture);
    }

    // 강의 아이디로 강의 조회 (테스트)
    @Override
    public Mono<Lecture> getLecture(String lectureId) {
        return lectureRepository.findByLectureId(lectureId);
    }

}