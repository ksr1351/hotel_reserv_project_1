---------------------------------------------------------------------예약 테이블
drop table booking;
drop sequence booking_code_seq;

-- 예약정보 테이블
CREATE TABLE booking (
    booking_code number CONSTRAINT booking_code_seq PRIMARY KEY,
    mem_code number not null, --FK
    hotel_code number not null, --FK
    room_code number not null, --FK
    guests number, --예약인원
    checkin date,
    checkout date,
    status varchar2(1), --예약상태 (대기중 1, 완료 2, 취소 3)
    regdate date default sysdate, --예약이 이루어진 날짜
    canceldate date --예약취소일
);

create sequence booking_code_seq
    start with 1
    increment by 1
    nocache
    nocycle;

select * from booking order by booking_code;

insert into booking values (booking_code_seq.nextval, 1, 1, 1, 2, '2023-03-01', '2023-03-02', 2, sysdate, sysdate);
insert into booking values (booking_code_seq.nextval, 1, 2, 2, 2, '2023-03-15', '2023-03-20', 2, sysdate, sysdate);
insert into booking values (booking_code_seq.nextval, 1, 3, 1, 2, '2023-03-15', '2023-03-20', 2, sysdate, sysdate);
insert into booking values (booking_code_seq.nextval, 1, 4, 1, 2, '2023-03-23', '2023-03-30', 2, sysdate, sysdate);
insert into booking values (booking_code_seq.nextval, 1, 5, 1, 2, '2023-02-01', '2023-02-02', 2, sysdate, sysdate);


------------------------------------------------------------------리뷰 테이블
drop table review;
drop sequence review_code_seq;

-- 리뷰댓글정보 테이블
CREATE TABLE review (
    review_code number CONSTRAINT review_code_seq primary key,
    booking_code number not null, --FK
    content varchar2(1000), --리뷰내용
    rating_value number, --평점
    regdate date default sysdate,
    moddate date default sysdate,
    business_comment varchar2(300)
);

create sequence review_code_seq
    start with 1
    increment by 1
    nocache
    nocycle;

select * from review order by review_code;



-- 평점 테이블
CREATE TABLE rating (
    hotel_code number, --FK
    rating_avg NUMBER DEFAULT 0,
    rating_cnt NUMBER DEFAULT 0 
);

-- 리뷰 이미지 테이블
CREATE TABLE review_images (
    review_code number,
    filename varchar2(300),
    filepath varchar2(300)
);

-- 호텔정보 테이블
CREATE TABLE hotel_banner_info(
    hotel_code number CONSTRAINT hotel_code_seq PRIMARY KEY,
    name varchar2(100), --호텔명
    type varchar2(100), --호텔유형
    address varchar2(200), --호텔주소
    price varchar(50), -- 최저가격
    regdate date default sysdate
);

create sequence hotel_code_seq
    start with 1
    increment by 1
    nocache
    nocycle;

--호텔 메인 이미지 파일
CREATE TABLE hotel_main_images(
    hotel_code number, --FK
    filename varchar2(300),
    filepath varchar2(300),
    regdate date default sysdate  
);

 --호텔 서브 이미지 파일
CREATE TABLE hotel_sub_images(
    hotel_code number, --FK
    filename varchar2(300),
    filepath varchar2(300),
    regdate date default sysdate
);   

-- 호텔 상세 주소
CREATE TABLE hotel_detail_address(
    hotel_code number, --FK
    hotel_detail_address varchar(200),
    regdate date default sysdate
);

-- 호텔 상세 정보
CREATE TABLE HOTEL_DETAIL_INFO (
  HOTEL_CODE NUMBER, 
  INFO VARCHAR2(50 BYTE), 
  DETAIL_INFO VARCHAR2(1500 BYTE), 
  REGDATE DATE DEFAULT sysdate 
);

-- 호텔 편의시설 
CREATE TABLE hotel_detail_con(
    hotel_code number, --FK
    hotel_detail_con varchar(400),
    regdate date default sysdate
);

-- 객실 배너 정보
CREATE TABLE room_banner_info(
    room_code number CONSTRAINT room_code_seq primary key,
    hotel_code number, --FK
    room_name varchar2(200),
    room_price varchar2(200),
    room_member varchar2(300),
    room_width varchar2(300),
    room_bed varchar2(200),
    regdate date default sysdate 
);

create sequence room_code_seq
    start with 1
    increment by 1
    nocache
    nocycle;

-- 객실 메인 이미지 파일
CREATE TABLE room_main_images(
    hotel_code number,
    room_code number,
    filename varchar2(300),
    filepath varchar2(300),
    regdate date default sysdate
);
drop table customer;

-- 고객 정보 테이블
CREATE TABLE customer(
    mem_code number CONSTRAINT customer_code_seq primary key, --FK
    mem_Id varchar2(100) NOT NULL,
    mem_Pwd varchar2(50) NOT NULL,
    mem_Name varchar2(50) NOT NULL,
    mem_Phone varchar2(50) NOT NULL,
    mem_Email varchar2(200) NOT NULL,
    memberType varchar2(10) NOT NULL   -- 1, 일반 회원 2 기업회원 3, 카카오회원 4.관리자
);

drop sequence customer_code_seq;

create sequence customer_seq
    start with 1
    increment by 1
    nocache
    nocycle;
    
insert into customer values(customer_code_seq.nextval, 'yeommy', '1234', '서여미', '01099999999', 'yeommy@naver.com', 1);

select * from customer;

commit;

drop table board;

create table board (
    board_code number CONSTRAINT board_code_seq primary key,
    customer_code number not null,
    title varchar2(50),
    content varchar2(1000),
    upload varchar2(300),
    regdate date default sysdate,
    moddate date default sysdate,
    readcount number
);

create sequence board_code_seq
    start with 1
    increment by 1
    nocache
    nocycle;
    
create table board_reply (
    board_code number not null,
    reply_code number CONSTRAINT board_reply_seq primary key,
    content varchar2(1000),
    customer_code number not null,
    regdate date default sysdate
);

create sequence board_reply_seq
    start with 1
    increment by 1
    nocache
    nocycle;

-- 공지사항 테이블
CREATE TABLE notice (
    notice_code number CONSTRAINT notice_code_seq PRIMARY KEY,
    admin_id varchar2(10) not null, --FK
    title varchar2(100),
    content varchar2(1000),
    upload varchar(300),
    regdate date default sysdate,
    readcount NUMBER DEFAULT 0
);

create sequence notice_code_seq
    start with 1
    increment by 1
    nocache
    nocycle;
    
commit;

CREATE TABLE kakaopay(
    booking_code number,
    cid VARCHAR2(100),
    tid VARCHAR2(100),
    cancel_amount VARCHAR2(100),
    cancel_tax_free_amount VARCHAR2(100),
    cancel_vat_amount VARCHAR2(100),
    regdate date default sysdate
);

SELECT A.*, rownum AS rn
		FROM(SELECT * FROM  board
oRDER BY board_code DESC) A
WHERE ROWNUM <= 5;

