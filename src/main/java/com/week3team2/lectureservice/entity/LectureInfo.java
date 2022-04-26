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
    private String lectureInfoId;

    @Column(value = "lectureId")
    private String lectureId;

    @Column(value ="memberId")
    private String memberId;

    @Column(value ="testScore")
    private String testScore;

    @Column(value="lectureState")
    private LectureInfoState lectureState;

    @Column(value ="lectureScore")
    private Integer lectureScore;

    @Column(value ="insertDt")
    private LocalDateTime insertDt;

    @Column(value ="updateDt")
    private LocalDateTime updateDt;
}
