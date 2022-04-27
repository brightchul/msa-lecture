package com.week3team2.lectureservice.handler;

import com.week3team2.lectureservice.entity.Lecture;
import com.week3team2.lectureservice.entity.LectureContent;
import com.week3team2.lectureservice.entity.LectureInfo;
import com.week3team2.lectureservice.repository.LectureRepository;
import com.week3team2.lectureservice.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@RequiredArgsConstructor
public class TeacherHandler {

    private final LectureService lectureService;
    private final LectureRepository lectureRepository;

    // 수강자 성적 입력
    public Mono<ServerResponse> updateStudentScore(ServerRequest request) {

        Mono<Lecture> lectureMono = request.bodyToMono(Lecture.class)
                .flatMap(lectureService::updateStudentScore);

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(lectureMono, Lecture.class)
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }

    // 시험 컨텐츠 추가
    public Mono<ServerResponse> updateNewTest(ServerRequest request) {

        Mono<LectureContent> lectureMono = request.bodyToMono(LectureContent.class)
                .flatMap(lectureService::updateNewExam);

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(lectureMono, LectureContent.class)
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }

    // 강의 컨텐츠 업로드
    public Mono<ServerResponse> uploadContent(ServerRequest request) {

        Mono<LectureContent> lectureMono = request.bodyToMono(LectureContent.class)
                .flatMap(lectureService::uploadContent);

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(lectureMono, LectureContent.class)
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }

    // 강사에 매칭된 강의 목록 조회
    public Mono<ServerResponse> getLectureOnTeacher(ServerRequest request) {
        Integer teacherId = Integer.valueOf(request.pathVariable("teacherId"));
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        return Mono.just(lectureRepository.findAllByMemberId(teacherId))
                .flatMap(lecture -> ServerResponse.ok()
                        .contentType(APPLICATION_JSON)
                        .body(lecture, Lecture.class)
                        .switchIfEmpty(notFound));
    }

    // 강사가 강의정보 테이블의 시험점수(testScore)를 반영한다.
    public Mono<ServerResponse> updateTestScore(ServerRequest request) {
        Mono<LectureInfo> lectureInfoMono = request.bodyToMono(LectureInfo.class)
                .flatMap(lectureService::updateTestScore);

        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(lectureInfoMono, Lecture.class)
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }
}
