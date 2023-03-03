drop database if exists console;
create database console;
use console;

drop table if exists 회원;
create table 회원(
   회원번호_pk int auto_increment primary key , 
    아이디 varchar(20) not null unique,
    비밀번호 varchar(20) not null,
    전화번호 varchar(20) not null,
    이름 varchar(20) not null,
    등급 int not null       -- 1:일반회원[회원가입] 2:강사[강사등록화면]
);

drop table if exists 스케줄;
create table 스케줄(
   스케줄번호_pk  int auto_increment primary key,
   수강일시 datetime not null,
    금액 int not null,
    회원번호_fk int,
    foreign key( 회원번호_fk ) references 회원( 회원번호_pk ) on delete set null -- 회원탈퇴시 수업 보존
);

drop table if exists 수강내역;
create table 수강내역(
   수강내역번호 int auto_increment primary key , 
    회원번호_fk int,   -- 누가 
    스케줄번호_fk int,   -- 어떤 스케줄~
    foreign key( 회원번호_fk ) references 회원( 회원번호_pk ) on delete set null , -- 회원탈퇴시 예약내역 보존
    foreign key( 스케줄번호_fk ) references 스케줄( 스케줄번호_pk ) on delete set null -- 수업을 삭제하면 해당수업 예약도 삭제
);

-- 1. 회원가입
insert into 회원( 아이디 , 비밀번호 , 전화번호 , 이름 , 등급 ) values( 'qwe' ,'qwe' ,'010-4444-4444' ,'유재석' , 1 );
insert into 회원( 아이디 , 비밀번호 , 전화번호 , 이름 , 등급 ) values( 'qqq' ,'qqq' ,'010-1234-1234' ,'김현수' , 1 );
insert into 회원( 아이디 , 비밀번호 , 전화번호 , 이름 , 등급 ) values( 'aaa' ,'aaa' ,'010-4321-4321' ,'서장훈' , 1 );
select * from 회원;
-- 2. 강사가입
insert into 회원( 아이디 , 비밀번호 , 전화번호 , 이름 , 등급 ) values( 'asd' ,'asd' ,'010-5555-5555' ,'강호동' , 2 );
insert into 회원( 아이디 , 비밀번호 , 전화번호 , 이름 , 등급 ) values( 'zxc' ,'zxc' ,'010-1234-4897' ,'신동엽' , 2 );

-- 2-1. 관리자 비밀번호 등록
insert into 회원( 아이디 , 비밀번호 , 전화번호 , 이름 , 등급 ) values( '관리자' ,'1234' ,'관리자' ,'관리자' , 3 );

-- 2-2. 관리자 로그인
select * from 회원 where 등급 = 3 and 비밀번호 = 1234;

-- 2. 관리자가 수업 등록 
insert into 스케줄( 수강일시 , 금액 , 회원번호_fk ) values( '2023-02-02 10:00:00' , 30000 , 4 );
insert into 스케줄( 수강일시 , 금액 , 회원번호_fk ) values( '2023-03-02 11:00:00' , 30000 , 4 );
insert into 스케줄( 수강일시 , 금액 , 회원번호_fk ) values( '2023-03-06 16:00:00' , 30000 , 4 );
insert into 스케줄( 수강일시 , 금액 , 회원번호_fk ) values( '2023-03-13 14:00:00' , 30000 , 4 );
insert into 스케줄( 수강일시 , 금액 , 회원번호_fk ) values( '2023-03-15 17:00:00' , 30000 , 5 );
insert into 스케줄( 수강일시 , 금액 , 회원번호_fk ) values( '2023-03-16 14:00:00' , 30000 , 5 );

select * from 회원;
select * from 스케줄;

-- 3. 회원이 수강신청 
insert into 수강내역( 회원번호_fk , 스케줄번호_fk ) values( 1 , 2 );


--  전체 강사들의 스케줄 
select * from 회원 , 스케줄 where 회원.회원번호_pk = 스케줄.회원번호_fk;

-- 4. 특정 강사의 스케줄만 확인 
select * from 회원 , 스케줄 where 회원.회원번호_pk = 스케줄.회원번호_fk and 스케줄.회원번호_fk = 2; -- 강사 본인것만
select * from 회원;
select * from 스케줄;
select * from 수강내역;

select * from 회원 , 수강내역 where 회원.회원번호_pk = 수강내역.회원번호_fk and 수강내역.회원번호_fk = 1; -- 학생 본인것만

-- 모든 강사 출력
select * from 회원 where 등급 = 2;
select 회원번호_pk , 아이디 , 전화번호 , 이름 from 회원 where 등급 = 2;
-- 모든 회원 출력
select * from 회원 where 등급 = 1;
select 회원번호_pk , 아이디 , 전화번호 , 이름 from 회원 where 등급 = 1;

select * from 회원;
select * from 스케줄;
select * from 수강내역;
-- 예약
insert into 수강내역( 회원번호_fk , 스케줄번호_fk ) values( 1 , 1 );
insert into 수강내역( 회원번호_fk , 스케줄번호_fk ) values( 2 , 4 );
insert into 수강내역( 회원번호_fk , 스케줄번호_fk ) values( 3 , 5 );
insert into 수강내역( 회원번호_fk , 스케줄번호_fk ) values( 3 , 3 );

-- 수강번호 스케줄 일시 , 금액 , 아이디 출력
select 수강내역번호 , 수강일시 , 금액 , 아이디 , 회원번호_pk , 스케줄번호_pk from 회원 m , 스케줄 s , 수강내역 r where m.회원번호_pk = s.회원번호_fk and s.스케줄번호_pk = r.스케줄번호_fk;

select 수강내역번호 , 수강일시 , 금액 , 아이디 , 회원번호_pk , 스케줄번호_pk from 회원 m , 스케줄 s , 수강내역 r where m.회원번호_pk = s.회원번호_fk and s.스케줄번호_pk = r.스케줄번호_fk and s.회원번호_fk = 4;

drop table if exists 강사순위;
create table 강사순위(
	회원번호_fk int,
    예약수 int ,
    순위 int ,
    foreign key( 회원번호_fk ) references 회원( 회원번호_pk )
);
select * from 강사순위;
select * from 회원;
select * from 스케줄;

-- 수강내역에 존재하는 스케줄 들 
select * from 수강내역 , 스케줄 where 수강내역.스케줄번호_fk = 스케줄.스케줄번호_pk;
-- 수강내역 테이블과 스케줄 테이블을 가져오는데 수강내역의 스케줄번호는 예약된 스케줄번호이고 스케줄테이블의 스케줄번호는 모든 스케줄의 스케줄 번호이므로
-- 만약 스케줄테이블의 스케줄번호만 출력하면 모든 스케줄이 나오니까 둘이 같은 부분만 출력하면 예약된 부분만 나온다.

-- 수강내역에 존재하는 스케줄이면 강사 정보 
select * from 수강내역 , 스케줄 , 회원 where 수강내역.스케줄번호_fk = 스케줄.스케줄번호_pk and 스케줄.회원번호_fk = 회원.회원번호_pk;
-- 위에서 추가로 회원테이블까지 출력하는데 예약이 된 스케줄이면서 동시에 회원의 회원번호는 모든 회원이고 스케줄의 회원번호는 강사이므로 둘이 같은 부분을 출력하면
-- 예약이 됐고 동시에 해당 레슨의 강사까지 출력하게 되는 것이다.


-- 회원번호 별 그룹 후 이름과 레코드수 표시 후 레코드수 기준으로 내림차순 
select 회원.이름 as 강사명 , count(*) as 누적수강생 , sum( 스케줄.금액) as 총매출액  from 수강내역 , 스케줄 , 회원 where 수강내역.스케줄번호_fk = 스케줄.스케줄번호_pk and 스케줄.회원번호_fk = 회원.회원번호_pk group by 회원.회원번호_pk order by count(*) desc ;
-- count(*)로 예약된 전체 강의수(레코드수)를 구하고 수강내역에 예약된 스케줄들의 금액을 sum으로 강사별로 모두 합쳐서 총 매출액을 구한다음 group by를 사용해서 중복되는 강호동을 강호동,강호동,강호동,강호동으로 하는게 아닌 강호동 하나만 나타내고 order by count(*) desc 즉 레코드수로 내림차순한다.