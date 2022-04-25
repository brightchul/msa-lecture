package com.week3team2.lectureservice.webClient;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class LectureWebClient {

    private final WebClient client;
    public LectureWebClient(WebClient.Builder builder) {
        this.client = builder.baseUrl("http://localhost:8083").build();
    }
}
