use MytestDB;




-- change user attribute

update user
set User_fullName = 'Jacob Olsen'
where User_id = 1;

-- delete user

delete from user where User_id = 3;


