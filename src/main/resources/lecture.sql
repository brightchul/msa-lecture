-- create table IF NOT EXISTS lecture
-- (
--     lectureId VARCHAR(255)  NOT NULL,
--     lectureName VARCHAR(255),
--     memberId VARCHAR(255),
--     memberName VARCHAR(255),
--     lectureShowYn BOOLEAN(10) DEFAULT FALSE,
--     lectureTotalScore BIGINT,
--     insertDt DATETIME DEFAULT CURRENT_TIMESTAMP,
--     updateDt DATETIME DEFAULT CURRENT_TIMESTAMP,
--
--     PRIMARY KEY (lectureId)
--
-- );
--
-- INSERT INTO lecture VALUES ('testId', 'testName', 'teacherId', 'teacherName', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

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

INSERT INTO lecture VALUES (0, 'testName', 0, 'teacherName', false, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

