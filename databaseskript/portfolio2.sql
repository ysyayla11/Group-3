USE MytestDB;
-- Query 1: Listing the 5 first rows of the 5 most important tables (your judgement), sorted.
SELECT * FROM user
LIMIT 5;

SELECT * FROM booking
LIMIT 5;

SELECT * FROM tools
LIMIT 5;

SELECT * FROM damageReport
LIMIT 5;

SELECT * FROM access
LIMIT 5;


-- Query 2: List all equipment in the system with their type
SELECT Tool_name, ToolType_name from tools inner join toolTypes tT on tools.ToolType_id = tT.ToolType_id;


-- Query 3: List all the available (at the moment – not already borrowed) equipment
SELECT Tool_name, Tool_delivered from tools where Tool_delivered is true;


-- Query 4: List the names and number of borrows of the three users with most equipment borrowed, sorted by number of borrows
SELECT user.User_fullName, COUNT(b.User_id) AS MOST_BOOKINGS
from booking b
inner join user ON b.User_id = user.User_id
GROUP BY b.User_id
ORDER BY COUNT(b.User_id) DESC
LIMIT  3;


-- Query 5: List all the equipment borrowed by the user with the highest number of equipment borrowed, sorted by date/time
select User_id, t.Tool_id,Tool_name,Booking_dateStart as TotalRepetitions
from booking INNER JOIN tools t on booking.Tool_id = t.Tool_id
where User_id = (select User_id
                 from booking
                 group by User_id
                 order by count(User_id) DESC
                 limit 1)
order by TotalRepetitions, Booking_dateStart DESC;


-- Query 6: List all equipment that is borrowed at the moment
SELECT Tool_name, Tool_delivered from tools where Tool_delivered is false;


-- Query 7: List all overdue equipment with their borrowers
select b.Booking_id, Tool_name, User_fullName
from booking b
         inner join tools t on b.Tool_id = t.Tool_id
         inner join user u on b.User_id = u.User_id
where b.Booking_dateEnd <= current_date and b.Booking_dateDelivered is null;

-- delete booked tool

delete from tools where Tool_id = 1;