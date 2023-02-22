-- 1. DB생성
create database 과제11;
-- 2. DB사용
use 과제11;
-- 3. 테이블 생성
drop table product;
create table product(
	pno	int auto_increment primary key,
    pname varchar(20),
    pprice int ,
    pstock int
);
-- 1.
insert into product (pname , pprice , pstock)values('아이스크림' , 3000 , 30);
select * from product;
insert into product(pname , pprice , pstock) values(? , ? , ?);
-- 2.
update product set pname =? , pprice=? where pno = ?;
-- 3.
update product set pstock =?  where pno =?;
-- 4.
delete from product where pno = ?