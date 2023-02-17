create database phonemanager;
use phonemanager;

create table Manufacture(
	Id varchar(254) primary key,
    Name varchar(254),
    Location varchar(254),
    Employee int
);

create table Phone(
	Id varchar(255) primary key,
    Name varchar(254),
    Price int,
    Color varchar(255),
    Country varchar(254),
    Quanlity int,
    Id_Manufacture varchar(254),
    FOREIGN KEY (Id_Manufacture) REFERENCES Manufacture(Id)
);

select * from Manufacture

