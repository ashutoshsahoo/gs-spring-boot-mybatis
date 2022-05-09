
drop table if exists city;
create table city (
    id int primary key auto_increment,
    name varchar,
    state varchar,
    country varchar
);

drop table if exists hotel;
create table hotel (
    city_id int,
    name varchar,
    address varchar,
    zip varchar
);

drop table if exists articles;
create TABLE articles(
    id INTEGER PRIMARY KEY auto_increment,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL
);

drop table if exists employees;
create table employees
(
   id integer PRIMARY KEY,
   first_name varchar(100) not null,
   last_name varchar(100) not null,
   email_id varchar(200) not null
);