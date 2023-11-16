--문제 1번
create table account(
    idx number(20) primary key,
    userid varchar(20) unique not null,
    userpw varchar(20) not null,
    nick varchar(20) unique not null,
    jdate date DEFAULT sysdate
)

--문제 2번
insert into account values(20231001, 'itbank' , 'it123' , '구름달' , '2023/02/13');
insert into account values(20231002, 'user' , '1234' , '별똥별' , '2023/02/14');
insert into account values(20231003, 'hong22' , '2222' , '콩콩' , '2023/02/22');
select * from account order by idx desc;

/
--문제 3번
update account set nick = '은하수' where nick ='별똥별';

/
--문제 4번
delete from account where userid ='hong22';
select * from account order by idx asc;
/
--문제 5번
create table board(
    idx number(10) primary key,
    title varchar(20) not null,
    contents varchar(30) not null,
    writer varchar(20) constraint fk_nick references account(nick),
    wdate date default sysdate
)
/
--문제 6번
insert into board values(1000, '안녕하세요', 'hello', '은하수','23/02/14');
insert into board values(1001, '오늘 점심은', '햄버거나 먹을까?', '은하수','23/02/14');
insert into board values(1002, '퇴근~', '차가 막히네', '구름달','23/02/14');
select * from board order by idx desc;

--문제 7번
select * from board where writer ='은하수' order by idx desc;

--문제 8번
select a.idx, a.userid, a.nick, b.idx, b.title 
from account a inner join board b on(a.nick = b.writer);

--문제 9번
create or replace view acc_jo_brd 
as 
select a.idx user_index, a.userid, a.nick, b.idx board_index, b.title 
from account a inner join board b on(a.nick = b.writer);
select * from acc_jo_brd;

--문제 10번
create table board_back
(   idx number(10) unique,
    title varchar(20),
    contents varchar(30),
    writer varchar(20),
    wdate date,
    ddate date default sysdate
)
/
create or replace trigger brd_del 
after delete on board
for each row
declare
begin
    insert into board_back values( :old.idx, :old.title, :old.contents,
     :old.writer, :old.wdate ,sysdate);
end;
/

--문제 11번
delete from board where idx = 1001;
select * from board;
select * from board_back;



