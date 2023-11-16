-- 프로젝트 전체 DB입니다. 
create schema ssafit_db;
use ssafit_db;

/*
 운동 저장 테이블 (name - 운동이름 pk, category - 대분류, season - 계절, goal - 몸만들기? 스트레스해소?,  individual - 혼자면 true,
indoor - 실내면 true, hardcore - 힘들면 true, minor - 생소하면 true, shaping cost - 비용크면 true) 

*/
create TABLE sports (
name varchar(20) PRIMARY KEY,
category varchar(20) not null,
season varchar(3) not null,
goal varchar(10) null,
individual boolean not null,
indoor boolean not null,
hardcore boolean not null,
minor boolean not null,
cost boolean not null
)ENGINE=InnoDB CHAR SET=utf8mb4;

-- 회원 테이블 ( id - pk, password 비밀번호 name 이름 location 주소지 email 이메일 age 나이, 추천운동 1,2,3,4 - sports 테이블에서 참조 )
create TABLE user (
id varchar(20) PRIMARY KEY,
password varchar(30) not null,
name varchar(20) not null,
location varchar(255) not null,
email varchar(30) not null,
age int not null,
work1 varchar(20) null,
work2 varchar(20) null,
work3 varchar(20) null,
work4 varchar(20) null,

CONSTRAINT work1_fk FOREIGN KEY (work1) references sports (name) ON DELETE SET NULL,
CONSTRAINT work2_fk FOREIGN KEY (work2) references sports (name) ON DELETE SET NULL,
CONSTRAINT work3_fk FOREIGN KEY (work3) references sports (name) ON DELETE SET NULL,
CONSTRAINT work4_fk FOREIGN KEY (work4) references sports (name) ON DELETE SET NULL
)ENGINE=InnoDB CHAR SET=utf8mb4;






