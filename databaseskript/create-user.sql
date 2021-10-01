create database if not exists MyTestDB;
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

insert into tools (Tool_id, Tool_name, Tool_type, Tool_condition, Tool_price, Tool_freeFirstDay, Tool_importantInformation, Tool_image)
values (Tool_id, 'Makita drill', 'småutstyr', 'God Stand', 20, true, 'Returner til samme plass som hentet', 'webapp/Images/img_3.png');