#creating database
create database demo;
#point to database
use demo;
create table credentials(scenario varchar(20), username varchar(20), password varchar(20));

insert into credentials values('zerobalancecard', 'zerobcc', '1234ee');
insert into credentials values('outstbalancecard', 'osbcc', '12344ee');
insert into credentials values('rewardscard', 'rcbcc', '122234ee');
insert into credentials values('shoppingcard', 'scbcc', '1234444ee');
insert into credentials values('basiccard', 'bsbcc', '123234ee');

select * from credentials where scenario = 'zerobalancecard';