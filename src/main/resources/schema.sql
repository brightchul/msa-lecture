drop table IF EXISTS lecture; -- member 테이블이 존재할 경우 DROP

create TABLE IF NOT EXISTS lecture ( -- lecture 테이블이 없을 경우 테이블 생성
    lecture_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    lecture_name VARCHAR(50) NOT NULL ,
    member_id INT(20)  ,
    lecture_show_yn BOOLEAN NOT NULL DEFAULT false,
    lecture_total_score INT(10) ,
    insert_dt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ,
    update_dt DATETIME ON update CURRENT_TIMESTAMP
);

create TABLE IF NOT EXISTS lecture_content (
    content_id INT(20) AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    content_name VARCHAR(100) NOT NULL ,
    content VARCHAR NOT NULL,
    lecture_id INT(20) NOT NULL,
    content_type VARCHAR(20) NOT NULL,
    insert_dt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ,
    update_dt DATETIME ON update CURRENT_TIMESTAMP
)