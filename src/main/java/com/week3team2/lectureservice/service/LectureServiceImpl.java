package com.week3team2.lectureservice.service;

import com.week3team2.lectureservice.entity.Lecture;
import com.week3team2.lectureservice.entity.LectureContent;
import com.week3team2.lectureservice.repository.LectureContentRepository;
import com.week3team2.lectureservice.repository.LectureRepository;

import java.time.LocalDateTime;

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
    public Mono<LectureContent> updateNewExam(LectureContent lectureContent) {
        lectureContent.setContentType("exam");
        return lectureContentRepository.save(lectureContent);
    }

    // 강의 컨텐츠 업로드
    @Override
    public Mono<LectureContent> uploadContent(LectureContent lectureContent) {
        lectureContent.setContentType("lecture");
        return lectureContentRepository.save(lectureContent);
    }

    @Override
    public Flux<Lecture> getLectureAllList() {
        return lectureRepository.findAll();
    }

    // 학생 회원이 제출한 별점을 열람
    @Override
    public Mono<Lecture> getLectureTotalScore(String lectureId) {
        return lectureRepository.getTotalScore(lectureId);
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

    // 강의를 학생 회원에게 노출 및 종료
    @Override
    public Mono<Lecture> changeLectureShowYn(Lecture lecture) {
        return lectureRepository.changeLectureShowYn(lecture.getLectureId(), lecture.getLectureShowYn());
    }

}