package com.week3team2.lectureservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LectureInfo {
    @Id
    @Column(value = "lectureInfoId")
    private Integer lectureInfoId;

    @Column(value = "lectureId")
    private Integer lectureId;

    @Column(value ="memberId")
    private Integer memberId;

    @Column(value ="testScore")
    private Integer testScore;

    @Column(value="lectureInfoState")
    private String LectureInfoState;

    @Column(value ="lectureScore")
    private Integer lectureScore;

    @Column(value ="insertDt")
    private LocalDateTime insertDt;

    @Column(value ="updateDt")
    private LocalDateTime updateDt;
}