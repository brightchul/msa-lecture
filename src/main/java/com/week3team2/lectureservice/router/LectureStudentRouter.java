package com.week3team2.lectureservice.router;

import com.week3team2.lectureservice.handler.StudentHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class LectureStudentRouter {
    @Bean
    public RouterFunction<ServerResponse> studentRouter(StudentHandler studentHandler) {
        return RouterFunctions
                .route(POST("/lecture/student/setScores"), studentHandler::setLectureScore)              // 수강한 강의에 별점 남기기
                ;
    }
}
