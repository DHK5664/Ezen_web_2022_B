-- 1. DB 데이터베이스 [*여러개의 테이블 가지는 공간]
drop database if exists boarddb;
create database boardDb;
use boardDb;

-- 2. 테이블
	-- 1. 회원
drop table if exists member;
create table member(
	mno		int auto_increment primary key , 
	mid		varchar(20) not null unique , 
    mpw		varchar(10) not null ,
    mname	varchar(30) not null ,
    mphone	varchar(13) not null
);

	-- 2. 카테고리
drop table if exists category;
create table category(
	cno		int auto_increment primary key ,
    cname	varchar(20) not null
);
	-- 3. 게시물
drop table if exists board;
create table board(
	bno			int auto_increment primary key,
    btitle		varchar(1000) not null ,
    bcontent	longtext not null , -- 긴글 텍스트
    bdate		datetime default now() , -- insert 시 자동 날짜 / 시간 대입
    bview		int default 0 ,			-- 조회수 기본값 0
    mno_fk		int ,
    cno_fk		int ,
    foreign key (mno_fk) references member(mno) on delete set null ,-- fk --> pk	[pk 삭제시 fk 필드는 null]
    foreign key (cno_fk) references category(cno) on delete cascade -- fk --> pk	[pk 삭제시 fk 필드같이 삭제]
);

drop table if exists reply;
create table reply(
	rno			int auto_increment primary key ,
    rcontent	text not null,
    rdate		datetime default now() ,
    rindex		int , 	-- 상위댓글 [0:최상위	1~: 해당 댓글 하위 댓글]
    mno_fk		int,
    bno_fk		int,
    foreign key(mno_fk) references member(mno) on delete set null,
    foreign key(bno_fk) references board(bno) on delete cascade
);

-- 1. 아이디 중복체크 [ 해당 아이디 검색 ]
	-- 검색 후 레코드가 존재하면 이미 존재하는 아이디 / 레코드가 없으면 존재하지 않는 아이디
select * from member; -- 모든 회원 검색
select * from member where mid = 'qwe'; -- 특정 회원아이디가 일치하는 회원 검색
-- 2. 회원가입
insert into member(mid , mpw , mname , mphone)
values('qwe','qwe','유재석','010-4444-4444');
-- 3. 로그인
select * from member where mid = 'qwe' and mpw = 'qwe'; -- 아이디와 비밀번호가 일치한 회원 레코드 찾기













