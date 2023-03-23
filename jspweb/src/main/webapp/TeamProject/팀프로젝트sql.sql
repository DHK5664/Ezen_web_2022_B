drop database if exists jsp_project;
create database jsp_project;
use jsp_project;

drop table if exists member;
create table member(
	mno			int auto_increment primary key ,	-- 회원 고유번호
    mname 		varchar(20) not null ,				-- 회원 이름
    mid 		varchar(30) not null unique ,		-- 회원 아이디
    mpwd 		varchar(20) not null ,				-- 회원 비밀번호
    mresidence	varchar(40) not null ,				-- 회원 사는장소 
    memail		varchar(30) not null unique ,		-- 회원 이메일
    mmw			varchar(10) ,						-- 회원 성별
    mphone		varchar(13) not null unique ,				-- 회원 핸드폰번호
    mimg		longtext 							-- 회원 프로필
);

select * from member;