create table IF NOT EXISTS lectureContent
(
    id int NOT NULL AUTO_INCREMENT,
    content_name VARCHAR(255) NOT NULL,
    content_body TEXT NOT NULL,
    lecture_id int NOT NULL,
    content_type VARCHAR(255) NOT NULL,
    insert_dt DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_dt DATETIME DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (id)
);

INSERT INTO lectureContent
VALUES (1, 'test1', 'content1', 1, 'exam', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lectureContent
VALUES (2, 'test2', 'content2', 2, 'lecture', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO lectureContent
VALUES (3, 'test2', 'content2', 3, 'lecture', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);