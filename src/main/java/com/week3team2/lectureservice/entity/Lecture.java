package com.week3team2.lectureservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "lecture")
public class Lecture {
    @Id
    @Column(value = "lecture_id")
    private Integer lectureId;

    @Column(value ="lecture_name")
    private String lectureName;

    @Column(value ="member_id")
    private Integer memberId;

    @Column(value ="lecture_show_yn")
    private Boolean lectureShowYn;

    @Column(value ="lecture_total_score")
    private Integer lectureTotalScore;

    @Column(value ="insert_dt")
    private Timestamp insertDt;

    @Column(value ="update_dt")
    private Timestamp updateDt;
}
