use MytestDB;

-- payment methods

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

-- users
insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_access,
                  User_union,
                  User_debt)
values
    (
        'Ronny Johansen',
        'Ronny56@gmail.com',
        98979691,
        'Passord123',
        'Gate 23',
        'Nei',
        true,
        500
    );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_access,
                  User_union,
                  User_debt)
values
    (
        'leif erikson',
        'leifebass@gmail.com',
        12345678,
        'P23eee2',
        'bringebærstien 23',
        'Nei',
        true,
        0
    );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_access,
                  User_union,
                  User_debt)
values
    (
        'Ronny Johansen',
        'Ronny56@gmail.com',
        87654321,
        'Passord123',
        'vekekjoppgata 90',
        'Nei',
        true,
        5000
    );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_access,
                  User_union,
                  User_debt)
values
    (
        'Emil emilson',
        'emils@gmail.com',
        87654321,
        'Passord123',
        'slottsveien 90',
        'Nei',
        true,
        5000
    );

-- tools

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_image               )

values
    (
        Tool_id,
        'Makita drill',
        'drill',
        'God stand',
        '20',
        true,
        'må leveres til samme sted som hentet',
        'Group-3\src\main\webapp\Images\img.png'
        );
