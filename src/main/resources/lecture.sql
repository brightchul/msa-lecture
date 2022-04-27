create table IF NOT EXISTS lecture
(
    lectureId INT NOT NULL AUTO_INCREMENT,
    lectureName VARCHAR(255),
    memberId INT,
    memberName VARCHAR(255),
    lectureShowYn BOOLEAN(10) DEFAULT FALSE,
    lectureTotalScore BIGINT,
    insertDt DATETIME DEFAULT CURRENT_TIMESTAMP,
    updateDt DATETIME DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (lectureId)

    );

create table IF NOT EXISTS lectureInfo
(
    lectureInfoId INT NOT NULL AUTO_INCREMENT,
    lectureId INT,
    memberId INT,
    testScore INTEGER DEFAULT 0,
    lectureState VARCHAR(255),
    lectureScore  INTEGER DEFAULT 0,
    insertDt DATETIME DEFAULT CURRENT_TIMESTAMP,
    updateDt DATETIME DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (lectureInfoId)
    );

INSERT INTO lecture VALUES (1, 'testName', 1, 'teacherName', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lecture VALUES (2, 'testName', 1, 'teacherName', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lecture VALUES (3, 'testName', 1, 'teacherName', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lecture VALUES (4, 'testName', 2, 'teacherName', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lecture VALUES (5, 'testName', 3, 'teacherName', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lectureInfo VALUES (0, 0, 0, 0, '수강중', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

