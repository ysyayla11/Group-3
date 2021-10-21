use MytestDB;

-- change user attribute

update user
set User_Email = 'blabla@mail.no'
where User_id = 3;

-- delete user

delete from user where User_id = 3;

-- adding new tool

insert into tools(Tool_id,
                           Tool_name,
                           Tool_type,
                           Tool_condition,
                           Tool_price,
                           Tool_qualification,
                           Tool_freeFirstDay,
                           Tool_importantInformation,
                           Tool_maxDays,
                           Tool_delivered,
                           Tool_image)
         values();

-- delete database

drop database MytestDB;

-- delete everything from table

truncate table tools;

-- add booking
insert into booking(Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid) VALUES(Booking_id, 1, 1, '2000/12/02', '2000/12/04', false);

update tools set Tool_delivered = false where Tool_id = 1;