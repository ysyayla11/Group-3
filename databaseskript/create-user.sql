create database if not exists MytestDB;
use MytestDB;
create table if not EXISTS user
(
    User_id                     int UNIQUE auto_increment,
    User_firstName              VARCHAR(255),
    User_lastName               VARCHAR(255),
    User_email                  VARCHAR(255),
    User_phonenumber            int,
    User_password               VARCHAR(255),
    User_dob                    VARCHAR(255),
    User_address                VARCHAR(255),
    User_access                 VARCHAR(255),
    User_qualification          VARCHAR(255),
    CONSTRAINT U_User_ID_PK PRIMARY KEY (User_id)
);

CREATE TABLE IF NOT EXISTS tools
(
    Tool_id                     int NOT NULL PRIMARY KEY auto_increment,
    Tool_name                   VARCHAR(255),
    Tool_type                   VARCHAR(255),
    Tool_condition              VARCHAR(255),
    Tool_price                  VARCHAR(255),
    Tool_qualification          int

);

CREATE TABLE IF NOT EXISTS shopping_cart
(
    Order_id                    int NOT NULL PRIMARY KEY auto_increment,
    Tools                       int,
    User                        int,
    FOREIGN KEY (Tools)         REFERENCES tools(Tool_id),
    FOREIGN KEY (User)          REFERENCES user(User_id),
    Payment_method              VARCHAR(255),
    Rent_date                   DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS rent_log
(
    Rent_id                   int NOT NULL PRIMARY KEY auto_increment,
    Order_type                int,
    FOREIGN KEY (Order_type)  REFERENCES shopping_cart(Order_id)
);

#inserter en record av en bruker inn i databasen otra.
INSERT INTO user (User_id,
                  User_firstName,
                  User_lastName,
                  User_email,
                  User_phonenumber,
                  User_password,
                  User_dob,
                  User_address,
                  User_access,
                  User_qualification
)



VALUES (User_id,
            'Root',
            'Root',
            'root@example.com',
            '12345678',
            'Password123',
            '1990-01-01',
            'Henrik Wergelandsgate 01',
            'admin',
            'tillatelse'
       );

#inserter en record av et tool inn i databasen otra.
INSERT INTO tools ( Tool_id,
                    Tool_name,
                    Tool_type,
                    Tool_condition,
                    Tool_price,
                    Tool_qualification
)



VALUES (    Tool_id,
            'Eksentersliper 230VAC',
            'Småutstyr',
            'I stand',
            '20*',
            '0'
       );

#inserter en record av en shopping_cart inn i databasen otra.
INSERT INTO shopping_cart ( Order_id,
                            Tools,
    /*Price,*/
                            User,
                            Payment_method,
                            Rent_date
)



VALUES (    Order_id,
            Tools,
            User,
            '',
            Rent_date
       );

#inserter en record av en rent_log inn i databasen otra.
INSERT INTO rent_log (  Rent_id,
                        Order_type
    /*User,
    Tools
    Price,
    ent_date*/
)



VALUES (    Rent_id,
            Order_type
       );