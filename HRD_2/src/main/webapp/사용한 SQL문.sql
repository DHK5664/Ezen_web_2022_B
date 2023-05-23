1. 테이블 생성 
create table student_tbl_03( 
   sno varchar2(6) not null, 
   sname varchar2(10) ,
   sphone varchar2(15) , 
   sgender varchar2(4) , 
   saddress varchar2(40) , 
   primary key(sno) 
);


2. 샘플 데이터 추가
insert into student_tbl_03 values( '10101' , '김행복' , '010-1111-2222','M','서울 동대문구 휘경1동');
insert into student_tbl_03 values( '10102' , '이축복' , '010-1111-3333','F','서울 동대문구 휘경2동');
insert into student_tbl_03 values( '10103' , '장믿음' , '010-1111-4444','M','울릉군 울릉읍 독도 1리');
insert into student_tbl_03 values( '10104' , '최사랑' , '010-1111-5555','F','울릉군 울릉읍 독도 2리');
insert into student_tbl_03 values( '10105' , '진평화' , '010-1111-6666','M','제주도 제주시 외나무골');
insert into student_tbl_03 values( '10106' , '차공단' , '010-1111-7777','M','제주도 제주시 감나무골');

1. 테이블 생성
create table exam_tbl_03(
	sno varchar2(6) not null ,
	ekor number(4),
	emath number(4),
	eeng number(4),
	ehist number(4),
	primary key( sno )
);
2. 샘플 데이터 추가
insert into exam_tbl_03 values( '10101' , 98 , 91 , 95 , 90 );
insert into exam_tbl_03 values( '10102' , 87 , 89 , 92 , 82 );