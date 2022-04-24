package com.week3team2.lectureservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "lecture")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Lecture {
    @Id
    @Column(value = "lectureId")
    private Integer lectureId;

    // TODO
}
