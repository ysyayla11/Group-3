create database if not exists MytestDB character set utf8;
use MytestDB;

create table if not EXISTS user
(
    User_id                     int UNIQUE auto_increment,
    User_fullName               VARCHAR(255) not null,
    User_email                  VARCHAR(255) unique,
    User_phoneNumber            Varchar(255) unique not null,
    User_password               VARCHAR(255) not null,
    User_address                VARCHAR(255),
    User_union                  boolean,
    User_debt                   int,
    CONSTRAINT U_User_ID_PK PRIMARY KEY (User_id)
    ) character set utf8;

CREATE TABLE IF NOT EXISTS toolTypes
(
    ToolType_id                 int not null primary key,
    ToolType_name               varchar(100)
);

CREAte TABLE IF NOT EXISTS files
(
    File_id                         int NOT NULL PRIMARY KEY auto_increment unique,
    File_name                       varchar(40),
    File_contents                   longblob,
    File_type                       varchar(20)
);

CREATE TABLE IF NOT EXISTS tools
(
    Tool_id                     int NOT NULL PRIMARY KEY auto_increment,
    Tool_name                   VARCHAR(255) not null,
    ToolType_id                 int,
    FOREIGN KEY (ToolType_id)   REFERENCES toolTypes(ToolType_id) on delete cascade,
    Tool_condition              VARCHAR(255) not null,
    Tool_price                  int,
    Tool_qualification          boolean,
    Tool_freeFirstDay           boolean not null,
    Tool_importantInformation   varchar(2000),
    Tool_maxDays                int,
    Tool_delivered              boolean not null,
    File_id                     int,
    FOREIGN KEY (File_id)       references files(File_id)
) character set utf8;

CREATE TABLE IF NOT EXISTS booking
(
    Booking_id                      int NOT NULL PRIMARY KEY auto_increment,
    Tool_id                         int,
    User_id                         int,
    FOREIGN KEY (Tool_id)           REFERENCES tools(Tool_id) on delete set null,
    FOREIGN KEY (User_id)           REFERENCES user(User_id) on delete cascade,
    Booking_dateStart               Datetime NOT NULL,
    Booking_dateEnd                 Datetime NOT NULL,
    Booking_paid                    boolean,
    Booking_dateDelivered           datetime -- null if not delivered yet
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
    FOREIGN KEY (Tool_id)           REFERENCES tools(Tool_id) on delete set null,
    FOREIGN KEY (User_id)           REFERENCES user(User_id) on delete cascade
);

CREATE TABLE IF NOT EXISTS access
(
    User_phoneNumber                varchar(255),
    Access_level                    varchar(25),
    FOREIGN KEY (User_phoneNumber)  REFERENCES user(User_phoneNumber) on delete cascade on update cascade
);


