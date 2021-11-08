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