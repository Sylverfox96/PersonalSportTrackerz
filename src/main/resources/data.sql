drop table if exists users;
drop table if exists course;


create table users (id bigint not null auto_increment, firstName varchar(64), lastName varchar(64), email varchar(128), age int(11), role enum('USER', 'COACH'), primary key (id)) engine=MyISAM;
create table course (id bigint not null, localisation varchar(64), date date, isIndoorOrOutdoorActivity boolean,noOfAvailablePlaces INTEGER, primary key (id)) engine=MyISAM;

INSERT INTO users (id, firstName, lastName,email, age, role) VALUES (1, "User", "user", "user@mail.com", 23, 'USER');
INSERT INTO users (id, firstName, lastName,email, age, role) VALUES (1, "Coach", "coach", "coach@mail.com", 23, 'COACH');

INSERT INTO course (id, localisation, date,isIndoorOrOutdoorActivity, noOfAvailablePlaces) VALUES (1L, "Localisation", new DATE(), true, 5);
