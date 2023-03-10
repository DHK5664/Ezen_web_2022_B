-- create database jspweb;
use jspweb; -- 없으면 새로 생성하기
-- 회원테이블
drop table if exists member;
create table member(
	mno		int	auto_increment primary key , -- 식별번호
    mid		varchar(30) not null unique ,	-- 회원아이디 [ 공백불가 , 중복불가 ]
    mpwd	varchar(30) not null ,	-- 회원비밀번호 [ 공백불가 ]
    mimg	longtext , -- 서버에 저장된 사진 경로	[ 공백가능 ]
    memail	varchar(100) not null unique	-- 회원이메일	[ 공백불가 , 중복불가 ]
);
-- 친추 테이블
drop table if exists friend;
create table friend(
	fno int auto_increment primary key ,	-- 식별번호
    ffrom int ,	-- 친구 신청한 회원 fk
    fto int ,	-- 친구 신청 받은 회원 fk
    foreign key (ffrom) references member(mno) on delete set null, -- 
    foreign key (fto) references member(mno) on delete set null	-- 친구가 탈퇴하면 null
);
-- 포인트 테이블
drop table if exists mpoint;
create table mpoint(
	mpno		int auto_increment primary key ,	-- 포인트내역 식별번호
    mpcomment	varchar(1000) not null,	-- 포인트내역 내용
    mpamount	int default 0,			-- 포인트수량
    mpdate		datetime default now() ,-- 포인트내역 날짜
    mno			int ,					-- 포인트 주인
    foreign key (mno) references member(mno) on delete set null -- 탈퇴하면 포인트 null
);
select * from member;
select * from mpoint;

-- 카테고리 테이블 [ 카테고리 번호 , 카테고리 이름 ( 공지사항 , 커뮤니티 , QnA , 노하우 등등 ) ]
drop table if exists category;
create table category(
	cno		int auto_increment primary key ,
    cname	varchar(100)
);
-- 게시물 테이블 [ 번호 , 제목 , 내용 , 첨부파일 , 작성일 , 조회수 , 좋아요수 , 싫어요수 , 작성자 ]
create table board(
	bno			int auto_increment primary key,
    btitle		varchar(1000) not null ,
    bcontent	longtext not null ,
    bfile		longtext ,
    bdate		datetime default now() ,
    bview		int default 0 ,
    bup			int default 0 ,
    bdown		int default 0 ,
    mno			int,	-- 회원번호 fk
    cno			int,		-- 카테고리번호 fk
    foreign key(mno) references member (mno) on delete set null, -- [회원]pk가 삭제되면 게시물fk는 null 변경
    foreign key(cno) references category (cno) on delete cascade -- [카테고리]pk가 삭제되면 게시물 같이 삭제
);
-- on delete cascade	: pk가 삭제되면 fk 같이 삭제
-- on delete set null	: pk가 삭제되면 fk는 null로 변경
-- 생략					: fk에 존재하는 식별키[pk]는 삭제 불가능

-- 1.
insert into category(cname) values( '공지사항' );
insert into category(cname) values( '커뮤니티' );
insert into category(cname) values( 'QnA' );
insert into category(cname) values( '노하우' );
select * from category;
/*
	테이블 설계 주의점
		1. 서로 다른 테이블간의 중복필드 X
		2. 에외) 서로 다른 테이블간의 관계[연결 PK-FK] : 무결성 유지
			- 테이블당 pk 1개이상 권장
*/

-- 아이디에 해당하는 회원정보[레코드] 호출
select * from member where mid = 'uuu';
-- 아이디에 해당하는 회원정보[레코드] + 보유포인트 호출

-- 1. 특정 회원 포인트내역
select * from mpoint where mno = 11;
-- 2. 특정 회원 보유 포인트
select sum(mpamount) from mpoint where mno = 11;
-- 3. 아이디에 해당하는 회원의 보유 포인트	[ 조인 -- 교집합 /	pk	fk ]
select * from member m , mpoint p where m.mno = p.mno; -- 다른 조건과 헷갈릴 수 있다.
select * from member m natural join mpoint;
-- 4. (회원별 보유포인트)조인 후 필요한 필드와 통계[ 두개 이상 필드 출력시 그룹필수~ ]
select m.mno , m.mid , m.mimg , m.memail , sum(p.mpamount) as mpoint
from member m , mpoint p
where m.mno = p.mno
group by mno; -- 집계할 기준 [ ~~별 ]
-- 5. (특정1명 회원정보+보유포인트)
select m.mno , m.mid , m.mimg , m.memail , sum(p.mpamount) as mpoint
from member m , mpoint p
where m.mno = p.mno and m.mid='aasdasf'; -- 집계할 기준 [ ~~별 ]

--
select * from member where mid = 'asdasdas';

-- * 포인트 지급
insert into mpoint(mpcomment , mpamount , mno) values('회원가입축하' , 100 , 11);
select * from mpoint;
-- * 포인트 결제
insert into mpoint(mpcomment , mpamount , mno) values('포인트결제구매' , 5000 , 11);
-- * 포인트 사용
insert into mpoint(mpcomment , mpamount , mno) values('제품구매' , -3000 , 11);

insert into mpoint(mpcomment , mpamount , mno) values('회원가입축하' , 100 , 4);












