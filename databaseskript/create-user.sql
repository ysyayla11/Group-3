create database if not exists MytestDB;
use MytestDB;
create table if not EXISTS users
(
    User_id                     int UNIQUE auto_increment,
    User_fullName               VARCHAR(255),
    User_email                  VARCHAR(255),
    User_phoneNumber            int,
    User_address                VARCHAR(255),
    User_access                 VARCHAR(255),
    User_union                  boolean,
    User_debt                   int,
    User_password               VARCHAR(255),
    CONSTRAINT U_User_ID_PK PRIMARY KEY (User_id)
    );

CREATE TABLE IF NOT EXISTS tools
(
    Tool_id                     int NOT NULL PRIMARY KEY auto_increment,
    Tool_name                   VARCHAR(255),
    Tool_type                   VARCHAR(255),
    Tool_condition              VARCHAR(255),
    Tool_price                  int,
    Tool_maxDays                VARCHAR(255),
    Tool_freeFirstDay           boolean,
    Tool_importantInformation   varchar(255),
    Tool_image                  longblob

);

CREATE TABLE IF NOT EXISTS booking
(
    Booking_id                      int NOT NULL PRIMARY KEY auto_increment,
    Tool_id                         int,
    User_id                         int,
    FOREIGN KEY (Tool_id)           REFERENCES tools(Tool_id),
    FOREIGN KEY (User_id)           REFERENCES users(User_id),
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
    FOREIGN KEY (User_id)           REFERENCES users(User_id)
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


