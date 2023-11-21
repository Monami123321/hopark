-- 프로젝트 전체 DB입니다. 처음부터 실행하면 초기화됩니다.
drop schema if exists hopark_db;
create schema hopark_db;
use hopark_db;

/*
 운동 저장 테이블 (name - 운동이름 pk, eng_name - 영문이름, category - 대분류, season - 계절, goal - 몸만들기? 스트레스해소?,  individual - 혼자면 true,
indoor - 실내면 true, hardcore - 힘들면 true, minor - 생소하면 true, shaping cost - 비용크면 true) 

*/
create TABLE sports (
name varchar(20) PRIMARY KEY,
eng_name varchar(30) not null,
category varchar(20) not null,
season varchar(3) not null,
goal varchar(10) null,
individual boolean not null,
indoor boolean not null,
hardcore boolean not null,
minor boolean not null,
cost boolean not null
)ENGINE=InnoDB CHAR SET=utf8mb4;


-- 회원 테이블 ( id - pk, password 비밀번호 name 이름 location 주소지 email 이메일 age 나이, img 스프링에서 편집한 파일명 org-img 클라이언트에서 보낸 원래 파일명 추천운동 1,2,3,4 - sports 테이블에서 참조 )
create TABLE user (
id varchar(100) PRIMARY KEY,
password varchar(255) not null,
name varchar(20) not null,
location varchar(255) not null,
email varchar(30) not null,
age int not null,
img varchar(255) null,
org_img varchar(255) null,
work1 varchar(20) null,
work2 varchar(20) null,
work3 varchar(20) null,
work4 varchar(20) null,

CONSTRAINT work1_fk FOREIGN KEY (work1) references sports (name) ON DELETE SET NULL,
CONSTRAINT work2_fk FOREIGN KEY (work2) references sports (name) ON DELETE SET NULL,
CONSTRAINT work3_fk FOREIGN KEY (work3) references sports (name) ON DELETE SET NULL,
CONSTRAINT work4_fk FOREIGN KEY (work4) references sports (name) ON DELETE SET NULL
)ENGINE=InnoDB CHAR SET=utf8mb4;


select * from user;
select * from sports;






-- SET foreign_key_checks = 0;
-- drop table sports;
 -- SET foreign_key_checks = 1;


-- TRUNCATE user;

-- drop schema hopark_db;

INSERT INTO sports (category, name, eng_name, season, goal, individual, indoor, hardcore, minor, cost) VALUES ('구기', '축구', 'football', '사계절', '둘다', False, False, True, False, False),
('구기', '풋살', 'futsal', '사계절', '둘다', False, False, False, False, False),
('구기', '농구', 'basketball', '사계절', '둘다', False, True, False, False, False),
('구기', '야구', 'baseball', '여름', '둘다', False, False, False, False, False),
('구기', '발야구', 'kickball', '여름', '스트레스', False, False, False, False, False),
('구기', '배구', 'volleyball', '사계절', '스트레스', False, True, False, False, False),
('구기', '비치발리볼', 'beach_volleyball', '여름', '스트레스', False, False, False, True, False),
('구기', '족구', 'foot_volleyball', '사계절', '스트레스', False, False, False, False, False),
('구기', '소프트볼', 'softball', '여름', '스트레스', False, True, False, True, False),
('구기', '볼링', 'bowling', '사계절', '스트레스', False, True, False, False, False),
('구기', '크리켓', 'cricket', '여름', '스트레스', False, False, False, True, False),
('구기', '피구', 'dodge_ball', '사계절', '스트레스', False, True, False, False, False),
('구기', '게이트볼', 'gate_ball', '사계절', '스트레스', False, True, False, True, False),
('구기', '골프', 'golf', '여름', '스트레스', False, False, False, False, True),
('구기', '핸드볼', 'handball', '사계절', '둘다', False, True, False, True, False),
('육상', '달리기', 'running', '사계절', '둘다', True, False, False, False, False),
('육상', '마라톤', 'marathon', '사계절', '둘다', True, False, True, False, False),
('육상', '경보', 'walking', '사계절', '둘다', True, False, False, False, False),
('격투기', '태권도', 'taekwondo', '사계절', '둘다', False, True, False, False, False),
('격투기', '택견', 'taekkyeon', '사계절', '스트레스', False, True, False, True, False),
('격투기', '씨름', 'Korean_wrestling', '사계절', '둘다', False, True, False, False, False),
('격투기', '유도', 'judo', '사계절', '둘다', False, True, True, False, False),
('격투기', '복싱', 'boxing', '사계절', '둘다', False, True, True, False, False),
('격투기', '킥복싱', 'kickboxing', '사계절', '둘다', False, True, True, False, False),
('격투기', '레슬링', 'wrestling', '사계절', '둘다', False, True, True, True, False),
('격투기', '주짓수', 'jiu-jitsu', '사계절', '둘다', False, True, True, True, False),
('격투기', '합기도', 'hapkido', '사계절', '둘다', False, True, True, False, False),
('격투기', '무에타이', 'muay_thai', '사계절', '둘다', False, True, True, False, False),
('체조', '에어로빅', 'aerobics', '사계절', '스트레스', True, True, False, True, False),
('체조', '리듬체조', 'gymnastics', '사계절', '스트레스', True, True, False, True, True),
('체조', '트램폴린', 'trampoline', '사계절', '스트레스', True, True, False, True, True),
('동계', '피겨스케이팅', 'figure_skating', '겨울', '스트레스', True, True, False, True, True),
('동계', '스피드스케이팅', 'speed_skating', '겨울', '스트레스', True, True, True, True, True),
('동계', '아이스하키', 'ice_hockey', '겨울', '스트레스', False, True, True, True, True),
('동계', '쇼트트랙', 'short_track', '겨울', '스트레스', True, True, False, True, True),
('동계', '스키', 'skiing', '겨울', '스트레스', True, False, False, False, True),
('동계', '스노보드', 'snowboard', '겨울', '스트레스', True, False, False, False, True),
('등산', '하이킹', 'hiking', '사계절', '스트레스', True, False, False, False, True),
('등산', '등산', 'mountaineering', '사계절', '둘다', True, False, False, False, True),
('등산', '트레킹', 'trekking', '사계절', '스트레스', True, False, False, True, True),
('등산', '암벽등반', 'rock_climbing', '사계절', '스트레스', True, False, True, True, True),
('등산', '빙벽등반', 'ice_climbing', '사계절', '스트레스', True, False, True, True, True),
('라켓', '테니스', 'tennis', '여름', '둘다', False, False, False, False, False),
('라켓', '배드민턴', 'bedminton', '사계절', '둘다', False, True, False, False, False),
('라켓', '스퀴시', 'squash', '사계절', '둘다', True, True, False, True, False),
('라켓', '탁구', 'table_tennis', '사계절', '스트레스', False, True, False, False, False),
('댄스스포츠', '발레', 'ballet', '사계절', '스트레스', True, True, False, True, True),
('댄스스포츠', '폴댄스', 'pole_dance', '사계절', '스트레스', True, True, False, True, True),
('댄스스포츠', '탱고', 'tango', '사계절', '스트레스', False, True, False, True, True),
('댄스스포츠', '퀵스텝', 'Quickstep', '사계절', '스트레스', False, True, False, True, True),
('댄스스포츠', '삼바', 'samba', '사계절', '스트레스', False, True, False, True, True),
('수상', '수영_자유형', 'freestyle', '사계절', '둘다', True, True, False, False, False),
('수상', '수영_배영', 'backstroke', '사계절', '둘다', True, True, False, False, False),
('수상', '수영_평영', 'breaststroke', '사계절', '둘다', True, True, False, False, False),
('수상', '수영_접영', 'butterfly', '사계절', '둘다', True, True, False, False, False),
('수상', '다이빙', 'diving', '사계절', '스트레스', True, True, True, True, False),
('수상', '카누', 'canoe', '여름', '스트레스', False, True, True, True, True),
('수상', '조정', 'rowing', '여름', '스트레스', False, True, True, True, True),
('수상', '수구', 'water_polo', '여름', '스트레스', False, True, False, True, True),
('수상', '수상스키', 'water_skiing', '여름', '스트레스', True, False, False, True, True),
('수상', '서핑', 'surfing', '여름', '스트레스', True, False, True, True, True),
('기타', '헬스', 'weight_training', '사계절', '몸', True, True, False, False, False),
('기타', '자전거', 'cycle', '사계절', '둘다', True, False, False, False, False),
('기타', '요가', 'yoga', '사계절', '스트레스', True, True, False, False, False),
('기타', '승마', 'horseback_riding', '사계절', '스트레스', True, False, False, True, True),
('기타', '프리즈비', 'frisbee', '사계절', '스트레스', True, True, False, True, True),
('기타', '사격', 'shooting', '사계절', '스트레스', True, True, False, True, True),
('기타', '양궁', 'archery', '사계절', '스트레스', True, True, False, True, True);

INSERT INTO user (id, password, name, location, email, age)
VALUES
('alice', '$2a$10$l028uh16oN5dSPKFAO1bquu/w0nJotmSQbER2bMynMBIzyb6jg486', 'alice', 'London', 'alice@gmail.com', 30),
('bob', '$2a$10$vgXhGy/ZPTLqFz6CS1fXZOuu35tjbSOfL9OrHuGQuttI4YDRYF4Ey', 'bob', 'Paris', 'bob@gmail.com', 22),
('david', '$2a$10$vHB7naUs4RTFhKWMFTpc7e/umKa.zCLXBEw4UwhOhm/kFAfvAMaw2', 'david', 'Tokyo', 'david@gmail.com', 28),
('eva', '$2a$10$0REuh.t/LpVqmVYml8xnx.Mzoq4pJcJ14hegHm7BCW8Zq.lCv6oH2', 'eva', 'Berlin', 'eva@gmail.com', 35),
('john', '$2a$10$KXXO9ELjn8amLYiM9cUnYuW0alkSNYAb/ZBal3MfIHEM1yM2cuVNq', 'john', 'New York', 'john@gmail.com', 25),
('linda', '$2a$10$yjaYF.n1PmevRbX20vlizeVhhjaGiVWouYrP0qYZD1tz5xSKeyqtS', 'linda', 'Rio de Janeiro', 'linda@gmail.com', 29),
('michael', '$2a$10$gO.7J90IrmnGMU1ynIMpjeTVmRxytoLa97OaTBXmvFv6hOyh2S1sa', 'michael', 'Cape Town', 'michael@gmail.com', 45),
('momo', '$2a$10$OZawGcdGS/7cKdZKp4Hjmu93YuK95xAIU6I8WcT.xi/iXlG8c3MqS', 'momo', 'Seoul', 'momo@gmail.com', 100),
('peter', '$2a$10$UjfYX1S7V0edzoSg4pOCT.ikwkEO6.Kr43fA0XqRoapOuBP4oj/Wi', 'peter', 'Moscow', 'peter@gmail.com', 32),
('susan', '$2a$10$gUy6w8KbRKIMTIwyAh9.UuvVAYl0Na4KD7W/f4jO0bR0FzK9rl0OK', 'susan', 'Sydney', 'susan@gmail.com', 40);









