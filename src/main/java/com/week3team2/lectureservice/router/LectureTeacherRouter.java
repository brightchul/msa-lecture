package com.week3team2.lectureservice.router;

import com.week3team2.lectureservice.handler.TeacherHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class LectureTeacherRouter {

    @Bean
    public RouterFunction<ServerResponse> route2(TeacherHandler teacherHandler) {
        return RouterFunctions
                .route(POST("/lecture/content/exam").and(accept(MediaType.APPLICATION_JSON)), teacherHandler::updateNewTest)   // 시험 컨텐츠 생성
                .andRoute(POST("/lecture/content/lecture").and(accept(MediaType.APPLICATION_JSON)), teacherHandler::uploadContent) // 강의 컨텐츠 생성
                .andRoute(POST("/lecture/matching").and(accept(MediaType.APPLICATION_JSON)), teacherHandler::getLectureOnTeacher) // 강사에 매칭된 강의목록 조회
                ;
    }
}
