create database if not exists MytestDB;
use MytestDB;
create table if not EXISTS user
(
    User_id                     int UNIQUE auto_increment,
    User_firstName              VARCHAR(255),
    User_lastName               VARCHAR(255),
    User_email                  VARCHAR(255),
    User_phoneNumber            int,
    User_password               VARCHAR(255),
    User_dob                    VARCHAR(255),
    User_address                VARCHAR(255),
    User_access                 VARCHAR(255),
    User_qualification          boolean,
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
    Booking_Tools                   int,
    Booking_User                    int,
    FOREIGN KEY (Booking_Tools)     REFERENCES tools(Tool_id),
    FOREIGN KEY (Booking_User)      REFERENCES user(User_id),
    Booking_Payment_method          VARCHAR(255),
    Booking_dateStart               Datetime NOT NULL,
    Booking_dateEnd                 Datetime NOT NULL
);

CREATE TABLE IF NOT EXISTS BookingLog
(
    BookingLog_id                      int NOT NULL PRIMARY KEY auto_increment,
    BookingLog_Tools                   int,
    BookingLog_User                    int,
    FOREIGN KEY (BookingLog_Tools)     REFERENCES tools(Tool_id),
    FOREIGN KEY (BookingLog_User)      REFERENCES user(User_id),
    BookingLog_Payment_method          VARCHAR(255),
    BookingLog_dateStart               Datetime NOT NULL,
    BookingLog_dateEnd                 Datetime NOT NULL,
    BookingLog_paid                    boolean
);


