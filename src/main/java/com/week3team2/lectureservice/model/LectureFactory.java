package com.week3team2.lectureservice.model;

import com.week3team2.lectureservice.entity.Lecture;

import java.util.List;

public interface LectureFactory {
    Lecture lectureBuilder(String lectureName);
    List<Lecture> adminSetupListBuilder();
}
