package com.week3team2.lectureservice.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "lectureContent")
public class LectureContent {

    @Id
    @Column(value = "contentId")
    String contentId;

    @Column(value ="contentName")
    String contentName;

    @Column(value ="contentBody")
    String contentBody;

    @Column(value = "lectureId")
    String lectureId;

    @Column(value = "contentType")
    String contentType;

    @CreatedDate
    private LocalDateTime insertDt;

    @LastModifiedDate
    private LocalDateTime updateDt;
}
