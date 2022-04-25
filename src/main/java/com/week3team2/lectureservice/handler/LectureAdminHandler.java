package com.week3team2.lectureservice.handler;

import com.week3team2.lectureservice.entity.Lecture;
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
public class LectureAdminHandler {

    private final LectureService lectureService;

    // 강의개설
    public Mono<ServerResponse> createLecture(ServerRequest request) {

        Mono<Lecture> lectureMono = request.bodyToMono(Map.class)
                .flatMap(lectureService::createLecture)
                .log()
                ;

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureMono, Lecture.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                ;
    }

    // 강사 매칭
    public Mono<ServerResponse> matchingLecture(ServerRequest request) {

        Mono<Lecture> lectureMono = request.bodyToMono(Map.class)
                .flatMap(lectureService::matchingLecture);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureMono, Lecture.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                ;
    }

    // 강의id로 강의조회
    public Mono<ServerResponse> getLecture(ServerRequest request) {

        Mono<Lecture> lectureMono = lectureService.getLecture(request.queryParam("lectureId").get());

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureMono, Lecture.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                ;
    }
}
