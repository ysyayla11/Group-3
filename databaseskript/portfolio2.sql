USE MytestDB;
-- Testing 2: Listing the first 5 rows of the 5 most important tables
SELECT * FROM user
LIMIT 5;

SELECT * FROM booking
LIMIT 5;

SELECT * FROM tools
LIMIT 5;
-- testing 5
SELECT user.User_fullName, COUNT(b.User_id) AS MOST_BOOKINGS
from booking b
inner join user ON b.User_id = user.User_id
GROUP BY b.User_id
ORDER BY COUNT(b.User_id) ASC
LIMIT  3;




-- testing 3
SELECT Tool_name, Tool_type from tools;
-- testing 4
SELECT Tool_name, Tool_delivered from tools where Tool_delivered is true;
-- testing 7
SELECT Tool_name, Tool_delivered from tools where Tool_delivered is false;

-- testing 5
SELECT user.User_id, b.Booking_dateStart, b.Booking_dateEnd
from booking b
         inner join user ON b.User_id = user.User_id
where b.User_id = count(b.User_id);


select *
from booking
    where user_id = 3
    order by User_id, Booking_dateStart;

select top 1 User_id, count(User_id) as TotalRepetitions
from booking
group by User_id
order by TotalRepetitions DESC;