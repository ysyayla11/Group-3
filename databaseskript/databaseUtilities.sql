use MytestDB;

-- change user attribute

update user
set User_fullName = 'nytt'
where User_id = 1;

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
