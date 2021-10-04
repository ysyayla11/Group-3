create database if not exists MytestDB;
use MytestDB;

create table if not EXISTS user
(
    User_id                     int UNIQUE auto_increment,
    User_fullName               VARCHAR(255),
    User_email                  VARCHAR(255),
    User_phoneNumber            int,
    User_password               VARCHAR(255),
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
    Tool_importantInformation   varchar(2000),
    Tool_maxDays                int,
    Tool_delivered              boolean,
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