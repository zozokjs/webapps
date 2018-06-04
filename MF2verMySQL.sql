drop table ordering;
drop table message;
drop table product;
drop table member;
drop table weather;

create table member(
    mid varchar(50) primary key not null,
    mpwd varchar(50) not null,
    mname varchar(50) not null,
    mbirth date,
    memail varchar(50),
    mphone varchar(50),
    maddr varchar(200),
    mjanre varchar(50),
    mgrade int not null,
    mopnum int,
    mwarning int
); 

create table product(
    pnumber int primary key not null,
    pname varchar(50) not null,
    pdate date,
    ppicture varchar(50),
    pscore int,
    pprice int not null,
    pjanre varchar(50),
    pauthor varchar(50),
    mid varchar(50) not null,
    pamount int,
    pyoutube varchar(1000) default 'zero',
    constraint product_fk1 foreign key( mid ) references member( mid ) on delete cascade  
);

alter table product modify pnumber int not null auto_increment;



insert into member values('master','1234','최고관리자','18/01/01','master@naver.com',01012345678,'here','dance',1,0,0);
insert into member values('seller','1234','판매자1','18/02/01','seller@naver.com',01012345678,'there','rock',2,0,0);
insert into member values('buyer','1234','구매자1','18/03/01','buyer@naver.com',01012345678,'where','ballad',3,0,0);
insert into member values('seller2','1234','판매자2','18/02/02','seller2@naver.com',01012345678,'there','rock',2,0,0);
insert into member values('buyer2','1234','구매자2','18/03/01','buyer2@naver.com',01012345678,'where','ballad',3,0,0);

insert into product values(1,'Welcome to the Black Parade','18/01/01','1.png',5,1000,'rock','My Chemical Romance', 'seller',0,'https://www.youtube.com/embed/RRKJiM9Njr8');
insert into product values(2,'Polaroid','18/02/02','2.png',5,2000,'ballad','신승훈', 'seller',0,'https://www.youtube.com/embed/xa6S_ZYU6hI');
insert into product values(3,'Without Me','18/03/03','3.png',5,3000,'hiphop','Eminem', 'seller',0,'https://www.youtube.com/embed/YVkUvmDQ3HY');
insert into product values(4,'바람처럼','18/03/03','4.png',5,1000,'ballad','이시은', 'seller2',0,'https://www.youtube.com/embed/9GDlmkSfG0M');
insert into product values(5,'목소리','18/03/03','5.png',5,2000,'ballad','정승환', 'seller2',0,'https://www.youtube.com/embed/783LrnbebIU');
insert into product values(6,'야생화','18/03/03','6.png',5,9000,'ballad','박효신', 'seller',0,'https://www.youtube.com/embed/OxgiiyLp5pk');
insert into product values(7,'Think About','18/03/03','7.png',5,300,'ballad','서지안', 'seller',0,'https://www.youtube.com/embed/EGbOMJgsQe4');
insert into product values(8,'마지막처럼','18/03/03','8.png',5,300,'dance','블랙핑크', 'seller',0,'https://www.youtube.com/embed/EGbOMJgsQe4');
insert into product values(9,'Bad Boy','18/03/03','9.png',5,300,'dance','레드벨벳', 'seller',0,'https://www.youtube.com/embed/J_CFBjAyPWE');

alter table product auto_increment=10;

create table ordering
(
    mid varchar(50) not null,
    pnumber int not null,
    ovolume int not null,
    onumber  int auto_increment primary key not null,
    otf int,
    constraint ordering_fk1_mid foreign key( mid ) references member( mid ) on delete cascade,  
    constraint ordering_fk1_pnumber foreign key( pnumber ) references product( pnumber ) on delete cascade  
);

create table message(
    gnumber int primary key auto_increment not null,
    greceiver varchar(20) not null,
    gdate date,
    gcontent varchar(1000)
);

create table weather(
wnx int, wny int, wcity varchar(20), wcitynum int 
);

insert into weather values(60,127,'서울',1);
insert into weather values(67,100,'대전',2);
insert into weather values(89,90,'대구',3);
insert into weather values(98,76,'부산',4);
insert into weather values(58,74,'광주',5);
insert into weather values(102,84,'울산',6);
insert into weather values(55,124,'인천',7);

