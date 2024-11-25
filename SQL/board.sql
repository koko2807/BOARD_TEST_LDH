CREATE TABLE `board` (
	`no`	BIGINT	NOT NULL AUTO_INCREMENT PRIMARY KEY	COMMENT 'PK',
	`id`	VARCHAR(255)	NOT NULL	COMMENT 'UK',
	`title`	VARCHAR(100)	NOT NULL	COMMENT '제목',
	`writer`	VARCHAR(100)	NOT NULL	COMMENT '작성자',
	`content`	TEXT	NULL	COMMENT '내용',
	`created_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '등록일자',
	`updated_at`	TIMESTAMP	NOT NULL	DEFAULT CURRENT_TIMESTAMP	COMMENT '수정일자'
);

DROP Table IF EXISTS board;

TRUNCATE TABLE board;
-- 샘플데이터 추가

INSERT INTO board (id, title, writer, content )
VALUES (UUID(), '제목1', '작성자1', '내용1')
			,(UUID(), '제목2', '작성자2', '내용2')
 		  ,(UUID(), '제목3', '작성자3', '내용3')
 			,(UUID(), '제목4', '작성자4', '내용4')
 			,(UUID(), '제목5', '작성자5', '내용5')