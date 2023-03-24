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

-- 댓글 테이블 [ 댓글번호 , 내용 , 작성일 , 인덱스(계층구분) , 작성자(*누가) , 게시물번호(*어디에다가)  ]
create table reply(
	rno			int auto_increment primary key ,
    rcontent	longtext ,
    rdate		datetime default now(),
    rindex		int default 0 , -- 0 이면 최상위계층 , 1~ 해당 댓글[부모]의 하위 댓글
    mno			int,
    bno			int,
    foreign key(mno) references member(mno) on delete set null ,
    foreign key(bno) references board(bno) on delete cascade
);
/*
	3번 게시물
		1번 댓글			[rno = 1 , rindex = 0]
			3번 댓글		[rno = 3 , rindex = 1]
			4번 댓글		[rno = 4 , rindex = 1]
				6번댓글	[rno = 6 , rindex = 4]
        2번 댓글			[rno = 2 , rindex = 0]
        5번 댓글			[rno = 5 , rindex = 0]
*/
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

-- 1. 조건[ where ] 조인[ 합집합 ]
drop table ex4;
create table ex4(
	mno int
);
insert into ex4 values(1) , (2) , (3) , (4) , (5);	-- 5개 레코드 추가
select * from ex4;

drop table ex5;
create table ex5(
	mno int
);
insert into ex5 values(3) , (4) , (5) , (6) , (7);	-- 5개 레코드 추가
select * from ex5;
-- --------------------------------
select * from ex4 , ex5; -- (5 X 5) = 25 레코드 검색 [ 합 집합 레코드개수 * 레코드개수 ]
select * from ex4 , ex5 where ex4.mno = ex5.mno; -- 3레코드[ 교 집합 두 레코드의 일치값 [ pk-fk ] ] 꼭 pk와 fk만으로 찾는게 아닌 동일한 데이터의 교집합을 이용하여 찾는것

select * from ex4 natural join ex5; -- natural join 자연조인 [ 암묵적으로 동일한 레코드의 일치값 -> 결론은 교집합 ]
-- board 테이블에는 mno가 있음 , 원하는건 mno[fk] ---> member테이블의 mno[pk] 외 다른 필드에 접근
select * from member , board;	-- 합집합
	-- 1. where 이용한 조인 [ * 다른 조건과 가독성 떨어짐 ]
	select * from member, board where member.mno=board.mno;
    -- 2. 테이블명 별칭[별명]
    select * from member m , board b where m.mno = b.mno;
    -- 3. A테이블 natural join B테이블 		:자연조인 [ * pk와fk 필드가 1개씩 존재하는 테이블에서 자주 사용 ]
    select * from member m natural join board;
    -- 4. A테이블 join B테이블 on 조인조건		: 조인 [ * on 키워드를 사용해서 교집합 조건 사용하면 다른 where과 구분됨 ]
    select * from member m join board b on m.mno = b.mno;
-- 결론
select board.*,member.mid from member natural join board;	-- board테이블 전체와 member테이블의 mid만 출력

select board.*,member.mid,member.mimg from board natural join member where board.bno=?;

-- 1. 출력
select board.*,member.mid from member natural join board;

-- 2. 특정 개수 만 출력 [ 페이징 조건 ] limit 시작인덱스(레코드인덱스)[0번부터 시작] , 개수
select b.* , m.mid from member m natural join board b limit 0 , 3;	-- 1페이지
select b.* , m.mid from member m natural join board b limit 3 , 3;	-- 2페이지
select b.* , m.mid from member m natural join board b limit 6 , 3;	-- 3페이지


select b.* , m.mid from member m natural join board b limit ? , ?;

-- 3. 레코드 수 구하기 count(*)
select count(*) from member m natural join board b;

-- 4. 조건식 [=같다]
select * from board where btitle = 'qwe';
-- 4. 조건식 [like포함된 패턴검색]		필드명 like %데이터%
select * from board where btitle = 'asd';		-- 제목이 asd인 레코드 찾기
select * from board where btitle like '%asd%';	-- asd가 포함된 제목의 레코드 찾기
select * from board where btitle like '_asd_';	-- asd가 2번째 글자에 있는 다 합쳐서 5글자인 제목의 레코드 찾기
	-- % : 모든 문자 대응 [문자개수 무시]	/	_:_	개수만큼 대응 [ 문자개수 중요 ]
/*    
	1asd2		like '_asd_'	--> true	/	like '%asd%'	--> true
    1asd23		like '_asd_'	--> false	/	like '%asd%'	--> true
*/

-- 결론
	-- 1. 검색이 없을때 레코드수 구하기
    select count(*) from member m natural join board b;
    -- 2. 검색이 있을때 레코드 수 구하기 [ 검색[조건]된 레코드수 ]
    select count(*) from member m natural join board b where b.btitle like'%asd%';
    select count(*) from member m natural join board b where ? like'%?%';
	-- 3. 자바에서 사용할 경우
    -- "select count(*) from member m natural join board b where "+key+" like'%"+keyword+"%'";

	-- 1. 검색이 없을때 레코드 출력
		select count(*) from member m natural join board b order by b.bdate desc limit ?,?;
	-- 2. 검색이 있을때 레코드 출력
		select count(*) from member m natural join board b where b.btitle like '%asd%' order by b.bdate desc limit 0,3;
	-- 3. 자바에서 사용할 경우
		-- "select count(*) from member m natural join board b where "+key+" like '%"+keyword+"%' order by b.bdate desc limit ? , ?;"
        
        -- 230316 DB 작성 완료
        select * from member limit 0 ,3 ;
        select count(*) from member;
        
        select * from member  where mid like '%asd%' limit 0 , 3;
        
        select * from member limit 0 , 5;
        
        
/* 제품 테이블 */ -- 2023-03-23
create table product(
	pno int	auto_increment primary key , -- 제품번호	
    pname varchar(500) not null , -- 제품명	
    pcomment text not null , -- 제품설명
    pprice bigint not null , -- 제품가격
    pstate int default 1, -- 상태[ 1:판매중 2:거래중 3:판매완료 등등 ]
    plat varchar(100) not null, -- 위도
    plng varchar(100) not null, -- 경도
    pview int default 0 , -- 조회수
    pdate datetime default now() -- 등록일
);
select * from jspweb.product where 동 >=plng  && 서 <= plng and  남<= plat and 북 >= plat; -- 얘도 포함해서
/* 제품 사진 테이블 */

/* 제품 찜하기 테이블 */ -- 2023-03-24
drop table if exists plike;
create table plike(
	plikeno bigint auto_increment primary key , /*식별키*/
    mno int , -- 회원번호 = 누가
    pno int , -- 제품번호 = 어떤제품 찜했는지
    foreign key (mno) references member(mno) on delete cascade ,
    foreign key (pno) references product(pno) on delete cascade
);

/* 제품 쪽지 테이블 */