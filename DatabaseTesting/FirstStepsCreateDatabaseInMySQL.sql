#creating database
create database Qadbt;
#point to database
use Qadbt;

#create tables
create table Employeeinfo(name varchar(20), id int, location varchar(20), age int);
describe Employeeinfo;

insert into Employeeinfo values('sam', 1, 'newjersey', 21);
insert into Employeeinfo values('ram', 2, 'newyork', 22);
insert into Employeeinfo values('tam', 3, 'floria', 23);
insert into Employeeinfo values('nam', 4, 'charlotte', 24);
insert into Employeeinfo values('lam', 5, 'texas', 25);

select * from Employeeinfo;