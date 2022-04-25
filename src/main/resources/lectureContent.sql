create table IF NOT EXISTS lectureContent
(
    contentId VARCHAR(255)  NOT NULL,
    contentName VARCHAR(255),
    contentBody VARCHAR(255),
    lectureId VARCHAR(255),
    contentType BIGINT,
    insertDt DATETIME DEFAULT CURRENT_TIMESTAMP,
    updateDt DATETIME DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (lectureId)

);

INSERT INTO lectureContent VALUES ('testId', 'test1', 'blahblah', 'testId', 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lectureContent VALUES ('testId2', 'test2', 'blahblah', 'testId2', 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);