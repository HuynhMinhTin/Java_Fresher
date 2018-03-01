create database Project
use Project
create table Users (
idUser varchar(50) not null,
name varchar(50) not null,
user_names varchar(20) not null ,
passwords varchar(20) not null,
dates datetime not null,
primary key (idUser)
);
create table Position(
idPosition varchar(20) not null,
idUser varchar(50) not null,
Name_Position varchar(50) not null,
primary key (idPosition),
foreign Key (idUser) REFERENCES Users(idUser)
);

create table Category (
IDcategory varchar(50) not null,
Name varchar(50) not null,
Images varchar(500) not null,
primary key (IDcategory)
);

create table Files (
idFile varchar(50) not null,
IDcategory varchar(50) not null,
idUser varchar(50) not null,
Name_files varchar(100),
size int not null,
comment varchar(1000) not null,
detail varchar(1500) not null,
dates datetime not null,
status_ bit not null,
imagelink varchar(1000) not null,
counts varchar(100),
primary key (idFile),
foreign Key (idUser) REFERENCES Users(idUser),
foreign Key (IDcategory) REFERENCES Category(IDcategory)

);
DROP TABLE Users;
DROP TABLE Category;
DROP TABLE Position;
DROP TABLE Files;

