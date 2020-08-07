CREATE TABLE T_ROLE ( 
	ID          number primary key, 
	ROLE_NAME   varchar2(100) not null, 
	DESCRIPTION varchar2(100)
);

CREATE TABLE T_USER ( 
	ID        number primary key, 
	LOGIN_ID  varchar2(20) not null, 
	PASSWORD  varchar2(200) not null, 
	FULL_NAME varchar2(100) not null, 
	DEPT_NAME varchar2(100) not null
);

CREATE TABLE T_USER_ROLE ( 
	ROLE_ID number, 
	USER_ID number, 
	foreign key (role_id) references t_role(id), 
	foreign key (user_id) references t_user(id), 
	primary key(role_id, user_id)
);



CREATE TABLE T_PROGRAM ( 
	ID              number not null, 
	PROGRAM_NAME    varchar2(200), 
	PROGRAM_URL     varchar2(200),
	PROGRAM_GROUP   varchar2(1),
	primary key(PROGRAM_ID)
);


CREATE TABLE T_ROLE_PROGRAM ( 
	ROLE_ID     number, 
	PROGRAM_ID  number, 
	foreign key (ROLE_ID) references t_role(ID), 
	foreign key (PROGRAM_ID) references t_program(ID), 
	primary key(ROLE_ID, PROGRAM_ID)
);


insert into t_user values( 1,'user', '1234','사용자','인사');
insert into t_user values( 2,'admin', '1234','관리자','기획');

insert into t_role values(1, 'ROLE_USER','일반사용자');
insert into t_role values(2, 'ROLE_ADMIN','시스템관리자');

insert into t_user_role values(1, 1);
insert into t_user_role values(2, 2);

insert into T_PROGRAM values(1, '관리자메인', 'admin', '1');
insert into T_PROGRAM values(2, '회원등록', 'insertUser', '1');
insert into T_PROGRAM values(3, '사용자메인', 'user', '1');

insert into T_ROLE_PROGRAM values(1, 2);
insert into T_ROLE_PROGRAM values(1, 3);
insert into T_ROLE_PROGRAM values(2, 1);
insert into T_ROLE_PROGRAM values(2, 2);
insert into T_ROLE_PROGRAM values(2, 3);

