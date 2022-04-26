package com.week3team2.lectureservice.service;

import com.week3team2.lectureservice.entity.Lecture;
import com.week3team2.lectureservice.entity.LectureContent;
import com.week3team2.lectureservice.repository.LectureContentRepository;
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
    private final LectureContentRepository lectureContentRepository;

    public LectureServiceImpl(LectureRepository lectureRepository, LectureContentRepository lectureContentRepository) {
        this.lectureRepository = lectureRepository;
        this.lectureContentRepository = lectureContentRepository;
    }

    // 수강자 성적 입력
    @Override
    public Mono<Lecture> updateStudentScore(Lecture lecture) {
        return null;
    }

    // 시험 컨텐츠 추가
    @Override
    public Mono<LectureContent> updateNewTest(Map<String, Object> param) {
        return lectureContentRepository.save(new LectureContent("testId2", "test3", "blahblah", "testId", "1",  LocalDateTime.now(), LocalDateTime.now()));
    }

    // 강의 컨텐츠 업로드
    @Override
    public Mono<LectureContent> uploadContent(Map<String, Object> param) {
        return lectureContentRepository.save(new LectureContent("testId2", "test3", "blahblah", "testId", "1",  LocalDateTime.now(), LocalDateTime.now()));
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
    public Mono<Lecture> createLecture(Lecture lecture) {
        String lectureName = lecture.getLectureName();
        String memberName = lecture.getMemberName();
        return lectureRepository.save(new Lecture(null, lectureName, 0, memberName, false, 0, LocalDateTime.now(), LocalDateTime.now()));
    }

    // 강의에 강사 매칭
    @Override
    public Mono<Lecture> matchingLecture(Lecture lecture) {
        return lectureRepository.findById(lecture.getLectureId())
                .doOnNext(data-> data.setMemberName(lecture.getMemberName()))
                .flatMap(lectureRepository::save)
                .log()
                ;
    }

    // 강의 아이디로 강의 조회 (테스트)
    @Override
    public Mono<Lecture> getLecture(Integer lectureId) {
        return lectureRepository.findById(lectureId);
    }

}