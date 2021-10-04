create database if not exists MytestDB;
use MytestDB;
create table if not EXISTS user
(
    User_id                     int UNIQUE auto_increment,
    User_fullName               VARCHAR(255),
    User_email                  VARCHAR(255),
    User_phoneNumber            int,
    User_password               VARCHAR(255),
    User_dob                    VARCHAR(255),
    User_address                VARCHAR(255),
    User_access                 VARCHAR(255),
    User_union                  boolean,
    User_debt                   int,
    CONSTRAINT U_User_ID_PK PRIMARY KEY (User_id)
    );

CREATE TABLE IF NOT EXISTS tools
(
    Tool_id                     int NOT NULL PRIMARY KEY auto_increment,
    Tool_name                   VARCHAR(255),
    Tool_type                   VARCHAR(255),
    Tool_condition              VARCHAR(255),
    Tool_price                  int,
    Tool_qualification          boolean,
    Tool_freeFirstDay           boolean,
    Tool_importantInformation   varchar(255),
    Tool_image                  varchar(255)

);

CREATE TABLE IF NOT EXISTS booking
(
    Booking_id                      int NOT NULL PRIMARY KEY auto_increment,
    Tool_id                         int,
    User_id                         int,
    FOREIGN KEY (Tool_id)           REFERENCES tools(Tool_id),
    FOREIGN KEY (User_id)           REFERENCES user(User_id),
    Booking_dateStart               Datetime NOT NULL,
    Booking_dateEnd                 Datetime NOT NULL,
    Booking_paid                    boolean
);

CREATE TABLE IF NOT EXISTS paymentMethod
(
    Payment_id                      int NOT NULL PRIMARY KEY auto_increment,
    Payment_name                    VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS qualification
(
    Qualification_id                int NOT NULL PRIMARY KEY auto_increment,
    Tool_id                         int,
    User_id                         int,
    FOREIGN KEY (Tool_id)           REFERENCES tools(Tool_id),
    FOREIGN KEY (User_id)           REFERENCES user(User_id)
);

insert into paymentMethod (Payment_id, Payment_name)
values
(
 Payment_id,
 'Cash'

);

insert into paymentMethod (Payment_id, Payment_name)
values
(
 Payment_id,
 'Vipps'


);

insert into user (User_fullName, User_email, User_phoneNumber, User_password, user_dob, User_address, User_access, User_union, User_debt)
values
(
 'Ronny Johansen',
 'Ronny56@gmail.com',
  98979691,
 'Passord123',
  NULL,
 'Gate 23',
 'Nei',
  true,
  500
);

insert into user (User_fullName, User_email, User_phoneNumber, User_password, user_dob, User_address, User_access, User_union, User_debt)
values
(
 'leif erikson',
 'leifebass@gmail.com',
  12345678,
 'P23eee2',
  NULL,
 'bringebærstien 23',
 'Nei',
  true,
  0
);

insert into user (User_fullName, User_email, User_phoneNumber, User_password, user_dob, User_address, User_access, User_union, User_debt)
values
(
 'Ronny Johansen',
 'Ronny56@gmail.com',
  87654321,
 'Passord123',
  NULL,
 'vekekjoppgata 90',
 'Nei',
  true,
  5000
);

insert into user (User_fullName, User_email, User_phoneNumber, User_password, user_dob, User_address, User_access, User_union, User_debt)
values
    (
        'Emil emilson',
        'emils@gmail.com',
        87654321,
        'Passord123',
        NULL,
        'slottsveien 90',
        'Nei',
        true,
        5000
    );




update user
set User_fullName = 'Jacob Olsen'
where User_id = 1;

delete from user where User_id = 3;


