use MytestDB;

-- change user attribute

update user
set User_Email = 'blabla@mail.no'
where User_id = 3;

-- delete user

delete from user where User_id = 3;

-- adding new tool

-- delete database

drop database MytestDB;

-- delete tool

delete from tools where Tool_id = 1;

-- delete everything from table

truncate table tools;

-- add booking
insert into booking(Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid) VALUES(Booking_id, 1, 1, '2000/12/02', '2000/12/04', false);

-- gjør et tool til ikke delivered

update tools set Tool_delivered = false where Tool_id = 1;

-- se hvor mange tools som er i databasen

select count(Tool_id) from tools;

-- see all unpaid bookings

select * from booking
    inner join user u on booking.User_id = u.User_id
where u.User_phoneNumber = 12345679 and Booking_paid is false;

select t.Tool_name, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered from booking inner join tools t on booking.Tool_id = t.Tool_id inner join user u on booking.User_id = u.User_id where u.User_phoneNumber = ?;




insert into user (User_id, User_fullName, User_email, User_phoneNumber, User_password, User_address, User_union, User_debt)values(User_id, 'kristian', 'lol', 12354321, sha2('yolo', 256), 'gata', true, 100);

-- insert longblob


insert into access(User_phoneNumber, Access_level) values(?,'user');

select * from booking where tool_id = ? and Booking_dateStart >= current_date();


show variables like 'max_allowed_packet';

SHOW VARIABLES LIKE 'secure_file_priv';

load data infile 'user.png' into table files;

select Booking_dateStart, Booking_dateEnd from booking;

select * from booking where tool_id = ? and Booking_dateStart >= current_date();

update booking set Booking_dateEnd = '2021-11-16' where Booking_id = 2;

select Tool_qualification from tools where Tool_id = ?;

select Tool_id from qualification where User_id = 0;

update tools set File_id = 1 where Tool_id = 1;

select * from tools;

-- insert new file template

select User_id, User_fullName, User_email, User_phoneNumber, User_password, User_address, User_union, User_debt from user;

select Access_level from access where User_phoneNumber = ? and Access_level = 'administrator';

update booking set Booking_dateDelivered = current_date where Booking_id = ?;

update booking set Booking_paid = true where Booking_id = 12;

update user set User_debt = (select User_debt from user where User_id = ?) + ? where User_id = ?;

update user set User_debt = 0 where User_id = *;

select count(3) from booking where User_id = 3 and Booking_paid = 0;

update user set User_debt = user.User_debt + ? where User_id = ?;

select ToolType_name from toolTypes where ToolType_id = ?;

insert into tools (Tool_id, Tool_name, ToolType_id, Tool_condition, Tool_price, Tool_qualification, Tool_freeFirstDay, Tool_importantInformation, Tool_maxDays, Tool_delivered, File_id)
values (ToolType_id,?,?,?,?,false,?,?,null,true,?);