create database MessageMS
go

use MessageMS

create table MessageInfo(
	mid int identity primary key,
	mcontent varchar(200) not null,
	publish date default getdate()
)


insert into MessageInfo values('你好，Tom','2021-1-15')
insert into MessageInfo values('你好，Judy','2021-1-10')
insert into MessageInfo values('你好，Nancy','2021-1-5')