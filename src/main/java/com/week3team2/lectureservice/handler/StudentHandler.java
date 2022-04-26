package com.week3team2.lectureservice.handler;

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


}
