package com.week3team2.lectureservice.handler;

import com.week3team2.lectureservice.entity.Lecture;
import com.week3team2.lectureservice.entity.LectureContent;
import com.week3team2.lectureservice.entity.LectureInfo;
import com.week3team2.lectureservice.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class TeacherHandler {

    private final LectureService lectureService;

    // 수강자 성적 입력
    public Mono<ServerResponse> updateStudentScore(ServerRequest request) {

        Mono<Lecture> lectureMono = request.bodyToMono(Lecture.class)
                .flatMap(lectureService::updateStudentScore);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureMono, Lecture.class)
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }

    // 시험 컨텐츠 추가
    public Mono<ServerResponse> updateNewTest(ServerRequest request) {

        Mono<LectureContent> lectureMono = request.bodyToMono(LectureContent.class)
                .flatMap(lectureService::updateNewExam);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureMono, LectureContent.class)
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }

    // 강의 컨텐츠 업로드
    public Mono<ServerResponse> uploadContent(ServerRequest request) {

        Mono<LectureContent> lectureMono = request.bodyToMono(LectureContent.class)
                .flatMap(lectureService::uploadContent);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureMono, LectureContent.class)
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }

    // 강사에 매칭된 강의 목록 조회
    public Mono<ServerResponse> getLectureOnTeacher(ServerRequest request) {

        Mono<Lecture> lectureMono = request.bodyToMono(Lecture.class)
                .flatMap(lectureService::getLectureOnTeacher);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureMono, Lecture.class)
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }

    // 강사가 시험성적 업데이트
    public Mono<ServerResponse> updateTestScore(ServerRequest request) {

        Mono<LectureInfo> lectureMono = request.bodyToMono(LectureInfo.class)
                .flatMap(lectureService::updateTestScore);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureMono, Lecture.class)
                .onErrorResume(error -> ServerResponse.badRequest().build());
    }
}
