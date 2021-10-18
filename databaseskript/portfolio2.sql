USE MytestDB;

SELECT * FROM user
LIMIT 5;

SELECT * FROM booking
LIMIT 5;

SELECT * FROM tools
LIMIT 5;

SELECT User_id,
COUNT(User_id) AS 'Antall Bookings'
FROM booking
GROUP BY User_id
ORDER BY 'Antall Bookings' DESC
LIMIT 10;

SELECT user.User_fullName, COUNT(b.User_id) AS MOST_BOOKINGS
from booking b
inner join user ON b.User_id = user.User_id
GROUP BY b.User_id
ORDER BY COUNT(b.User_id) DESC
LIMIT  3;





SELECT Tool_name, Tool_type from tools;

SELECT Tool_name, Tool_delivered from tools where Tool_delivered is true;

SELECT Tool_delivered from tools where Tool_delivered is false;