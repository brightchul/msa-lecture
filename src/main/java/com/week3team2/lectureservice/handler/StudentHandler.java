package com.week3team2.lectureservice.handler;

import com.week3team2.lectureservice.entity.Lecture;
import com.week3team2.lectureservice.entity.LectureInfo;
import com.week3team2.lectureservice.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class StudentHandler {

    private final LectureService lectureService;

    // 수강한 강의에 별점 남기기
    public Mono<ServerResponse> setLectureScore(ServerRequest request) {
        Mono<LectureInfo> lectureMono = request.bodyToMono(LectureInfo.class)
                .flatMap(lectureService::setLectureScore)
                .log()
                ;

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureMono, LectureInfo.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                ;
    }

    // 강의를 선택해서 수강 신청 (수강정보 : LectureInfo 생성)
    public Mono<ServerResponse> enrolment(ServerRequest request) {
        Mono<LectureInfo> lectureInfoMono = request.bodyToMono(LectureInfo.class)
                .flatMap(lectureService::enrolment)
                .log()
                ;

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(lectureInfoMono, LectureInfo.class)
                .onErrorResume(error -> ServerResponse.badRequest().build())
                ;
    }

}
