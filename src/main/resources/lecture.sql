create table IF NOT EXISTS lecture
(
    lectureId VARCHAR(255)  NOT NULL,
    lectureName VARCHAR(255),
    teacherId VARCHAR(255),
    teacherName VARCHAR(255),
    lectureShowYn BOOLEAN(10) DEFAULT FALSE,
    lectureTotalScore BIGINT,
    insertDt DATETIME DEFAULT CURRENT_TIMESTAMP,
    updateDt DATETIME DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (lectureId)

);

INSERT INTO lecture VALUES ('testId', 'testName', 'teacherId', 'teacherName', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lecture VALUES ('testId2', '테스트강의', 'teacherId2', 'teacherName2',
false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
