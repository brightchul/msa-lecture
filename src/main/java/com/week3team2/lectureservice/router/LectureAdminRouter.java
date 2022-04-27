package com.week3team2.lectureservice.router;

import com.week3team2.lectureservice.handler.LectureAdminHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class LectureAdminRouter {

    @Bean
    public RouterFunction<ServerResponse> route(LectureAdminHandler lectureAdminHandler) {
        return RouterFunctions
                .route(POST("/lecture/admin/create"), lectureAdminHandler::createLecture)              // 강의개설
                .andRoute(POST("/lecture/admin/matching"), lectureAdminHandler::matchingLecture)       // 강사 매칭
                .andRoute(GET("/lecture/getLecture"), lectureAdminHandler::getLecture)                 // 강의 조회 (테스트)
                .andRoute(GET("/lecture/getTotalScore"), lectureAdminHandler::getLectureTotalScore)                 // 강의의 총 별점 조회
                .andRoute(PATCH("/lecture/admin/show"), lectureAdminHandler::changeLectureShowYn)        // 강의 노출, 강의 노출 종료(PATCH)
                ;
    }
}
