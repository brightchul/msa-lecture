package com.week3team2.lectureservice.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(value = "lectureContent")
public class LectureContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String contentName;

    String contentBody;

    Integer lectureId;

    String contentType;

    @CreatedDate
    private LocalDateTime insertDt;

    @LastModifiedDate
    private LocalDateTime updateDt;
}
