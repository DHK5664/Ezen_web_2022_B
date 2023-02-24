/*
	메모리
		주기억장치 	: RAM 휘발성		전기O저장O		- 현재 실행중인 명령어 저장
			- JAVA , JVM , 게임중 , 
		보조기억장치	: ROM 비휘발성		전기X저장O		- 모든 명령어 저장
			- DB , 파일 , C드라이브 , CD , USB , 게임설치 등
            
	데이터베이스 : 표 만들어서 데이터 저장하는 공간
		1. 데이터[자료] 베이스[모임] -> 표 -> 관계형[열/행] 데이터베이스
        2. [워드,엑셀,한글] 마우스 표 제작 vs [데이터베이스] 대화식[명령어] 표 제작
        3. SQL 질의어
	
    표 제작 
    - 테이블 내 대표 되는 필드 선정 [ PK ] 기본키
		1. 중복이 없어야 한다.
		2. 절대적인 식별용 데이터 [ 공백 X null X ]
        3. 메모리 효율성 선택
	
    - 현 테이블 PK필드가 다른 테이블에서 사용되면 [FK] 외래키
		1. 중복 가능
        2. PK필드에 존재하는 데이터만 FK 작성 가능 [무결성 유지]
	
회원테이블( 회원번호 int primary key );
게시물테이블 ( 회원번호_fk int 작성자 int , foreign key( 회원번호_fk ) references 회원 (회원번호_pk) : 
    
쇼핑몰 표 만들기
	1. 저장할 데이터의 항목
		* 아이디 , 비밀번호 , 제품이름 , 가격 , 구매한제품이름 , 구매한일자
	
    2. 테이블 분해		--> 쪼개서 쓰는 이유?
						나눠서 하면 뭐 하나 오류 났을때 그 부분만 건들 수 있어서 편리함
			회원가입
				아이디 , 비번
            제품				--> 위로 표를 만들었을 시 이렇게 세가지로 나눌 수 있음
				제품이름 , 가격
            구매 
				구매한제품이름 , 구매한일자
                
	3. 분해된 테이블 관계
			1. 각 테이블의 PK 선정
            
            회원가입
				V회원번호[pk] , 아이디 , 비번
			제품
				V제품번호[pk] , 제품이름 , 가격
			구매
				V주문번호[pk] , 구매한제품이름 , 구매한일자

			2. FK 선정
            누가 어떤걸 했는지 선정해야 함
			즉 회원번호[pk]가 무엇(제품번호[pk])을 구매했는지
            이 과정들이 '구매'에서 일어나므로 구매에 FK로 회원번호와 제품번호를 선정해서 구분해줌
			주문번호[pk] , 구매한제품이름 , 구매한일자 , 회원번호[FK] , 제품번호[FK] <- 테이블헤드로 보면 이런느낌
            
*/
-- 1. DB 생성 / 선택
drop database if exists 관계테이블연습;
create database 관계테이블연습;
use 관계테이블연습;

drop table if exists 회원;
create table 회원(회원번호 int primary key , 아이디 varchar(20) , 비밀번호 varchar(10) );

drop table if exists 제품;
create table 제품( 제품번호 int primary key , 제품이름 varchar(20) , 제품가격 int);

drop table if exists 구매내역;
create table 구매내역 ( 
	구매번호 int primary key , 
	구매일자 datetime , 
	회원번호_fk int,
	제품번호_fk int,
    foreign key(회원번호_fk) references 회원(회원번호),
    foreign key(제품번호_fk) references 제품(제품번호)
    );

-- 예제1 : 매머드 커피 홈페이지 db 설계
	-- 제품 , 카테고리 , 주문테이블
-- 저장
	-- 제품명 
    -- 제품설명
    -- 카테고리
    -- 가격
    -- 주문번호
    -- 주문한 제품
    -- 주문 일시
    -- 주문 상태
    
-- 콜드브루라떼 , 부드러운 ~~ , 콜드브루 , 3000 , 1 , 콜드브루라떼 , 02/24 , 주문
-- 콜드브루라떼 , 부드러운 ~~ , 콜드브루 , 3000 , 2 , 콜드브루라떼 , 02/25 , 주문
-- 달고나콜드브루 , 부드러운 ~~ , 콜드브루 , 4500 , 3 , 콜드브루라떼 , 02/25 , 주문

-- 카테고리 테이블
	-- 카테고리번호[pk] , 카테고리명
drop table if exists category;
create table category(cno int auto_increment primary key , cname varchar(10) not null unique);
-- 제품테이블
	-- 제품번호[pk] , 제품명 , 제품설명 ,  가격 , 카테고리(카테고리번호(FK))
drop table if exists product;
create table product(
	pno int auto_increment primary key , 
    pname varchar(10) not null unique , 
    pcomment text not null , 
    pprice smallint not null ,
    cno_fk int ,
    foreign key(cno_fk) references category(cno) on delete cascade on update cascade -- pk 삭제/수성시 fk 같이 삭제 
    );
-- 주문테이블
	-- 주문번호[pk] , 주문한 제품[제품번호[fk]] , 주문 일시 , 주문 상태
drop table if exists porder;
create table porder(
	pono int auto_increment primary key ,
    podate datetime default now() ,
    postate tinyint default 1,
    pno_fk int,
    foreign key(pno_fk) references product(pno) on delete set null on update set null -- pk 삭제/수정시 fk null 만들기
);

-- 카테고리 등록
	-- 1. 콜드브루 등록
	insert into category (cname) values('콜드브루');	-- cno pk ->1
    insert into category (cname) values('커피');		-- cno pk ->2
select * from category;
    -- 2. 제품등록
    insert into product (pname , pcomment , pprice , cno_fk)values('콜드브루라떼' , '맛있는~~' , 3000 , 1 );	-- pno pk -> 1
    insert into product (pname , pcomment , pprice , cno_fk)values('오곡브루라떼' , '맛있는~~' , 4500 , 1 );	-- pno pk -> 2
    insert into product (pname , pcomment , pprice , cno_fk)values('꿀커피' , '맛있는~~' , 2000 , 2 );		-- pno pk -> 3
select * from product;
    -- 3. 주문 등록
    insert into porder (pno_fk) values(2); -- 오곡콜드브루 주문 -- pono pk -> 1
    insert into porder (pno_fk) values(3); -- 꿀커피 주문 	-- pono pk -> 2
    insert into porder (pno_fk) values(2); -- 오곡콜드브루 주문 -- pono pk -> 3
select * from porder;














