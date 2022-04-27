package com.week3team2.lectureservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LectureserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LectureserviceApplication.class, args);
	}

}
