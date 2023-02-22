-- 1. DB 생성
create database day15;
-- 2. DB 선택
use day15;
-- 3. 테이블 생성
create table member(
	mno	int auto_increment primary key,	-- 회원번호 [ 자동번호 , 식별자 ]
    mid	varchar(20),					-- 회원아이디 [ 최대 20글자 저장 ]
    mpw	varchar(20)						-- 회원비밀번호 [ 최대 20글자 저장 ]
);
-- SQL 처리구문
-- 4. 회원가입
insert into member (mid , mpw) values(?,?);
-- 5. 모든 회원 검색 [* 모든 레코드 검색]
select * from member;
-- 6. 2번 회원 비밀번호 수정
update member set mpw = "zxc" where mno = 2;
-- 매개변수 ?
update member set mpw = ? where mno = ?;