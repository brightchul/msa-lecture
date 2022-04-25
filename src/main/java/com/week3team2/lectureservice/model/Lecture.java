package com.week3team2.lectureservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.*;

@Table(value = "lecture")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Lecture {
    @Id
    @Column(value = "lectureId")
    private String lectureId;

    @Column(value = "lectureName")
    private String lectureName;

    @Column(value = "teacherId")
    private String teacherId;

    @Column(value = "teacherName")
    private String teacherName;

    @Column(value = "lectureShowYn")
    private Boolean lectureShowYn;

    @Column(value = "insertDt")
    private LocalDateTime insertDt;

    @Column(value = "updateDt")
    private LocalDateTime updateDt;

}
