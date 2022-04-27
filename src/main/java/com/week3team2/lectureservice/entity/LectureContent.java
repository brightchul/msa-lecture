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
    @Column(value ="id")
    Integer id;

    @Column(value ="contentName")
    String contentName;

    @Column(value ="contentBody")
    String contentBody;

    @Column(value ="lectureId")
    Integer lectureId;

    @Column(value ="contentType")
    String contentType;

    @Column(value ="insertDt")
    private LocalDateTime insertDt;

    @Column(value ="updateDt")
    private LocalDateTime updateDt;
}
