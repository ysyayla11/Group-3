use MytestDB ;

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

-- users and access level

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'god',
        'god@gmail.com',
        '12345678',
        sha2('12345', 256),
        'lommedalen',
        true,
        0
    );

insert into access(User_phoneNumber, Access_level)
values(
       '12345678',
       'administrator'
      );

insert into access(User_phoneNumber, Access_level)
values(
          '12345678',
          'user'
      );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'Ronny Johansen',
        'Ronny56@gmail.com',
        '98979691',
        sha2('Passord123', 256),
        'Gate 23',
        true,
        0
    );

insert into access(User_phoneNumber, Access_level)
values(
          '98979691',
          'user'
      );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'leif erikson',
        'leifebass@gmail.com',
        '12345679',
        sha2('P23eee2', 256),
        'bringebærstien 23',
        true,
        0
    );

insert into access(User_phoneNumber, Access_level)
values(
          '12345679',
          'user'
      );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'Ronny Johansen',
        'Ronny52@gmail.com',
        '87654321',
        sha2('Passord123', 256),
        'vekekjoppgata 90',
        true,
        0
    );

insert into access(User_phoneNumber, Access_level)
values(
          '87654321',
          'user'
      );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'Emil emilson',
        'emils@gmail.com',
        '87654322',
        sha2('Passord123', 256),
        'slottsveien 90',
        true,
        0
    );

insert into access(User_phoneNumber, Access_level)
values(
          '87654322',
          'user'
      );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'Jon Hansen Yayla',
        'Jhyayla@gmail.com',
        '345655323',
        sha2('Passord456', 256),
        'Kongens gate 7',
        true,
        0
    );

insert into access(User_phoneNumber, Access_level)
values(
          '345655323',
          'user'
      );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'Anders Jensen',
        'Crazyjensen@gmail.com',
        '89765445',
        sha2('Passord965', 256),
        'Seasam Street 7',
        true,
        0
    );

insert into access(User_phoneNumber, Access_level)
values(
          '89765445',
          'user'
      );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'Abdurrezzak Sheih',
        'Abdurrez@gmail.com',
        '98654326',
        sha2('Passord896', 256),
        'Madridveien 35',
        true,
        0
    );

insert into access(User_phoneNumber, Access_level)
values(
          '98654326',
          'user'
      );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'Luigi Ferrari',
        'Luigimario@gmail.com',
        '57483988',
        sha2('Passord321', 256),
        'Juventus gate 43',
        false,
        500000000
    );

insert into access(User_phoneNumber, Access_level)
values(
          '57483988',
          'user'
      );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'Camel Stock ',
        'CamelRichman@gmail.com',
        '57684562',
        sha2('Passord897', 256),
        'Krakov 95',
        false,
        0
    );

insert into access(User_phoneNumber, Access_level)
values(
          '57684562',
          'user'
      );

insert into user (User_fullName,
                  User_email,
                  User_phoneNumber,
                  User_password,
                  User_address,
                  User_union,
                  User_debt)
values
    (
        'Vladimir Trump',
        'VladimirTrump@gmail.com',
        '82354321',
        sha2('Passord666', 256),
        'Moskov 43',
        true,
        0
    );

insert into access(User_phoneNumber, Access_level)
values(
          '82354321',
          'user'
      );

-- tool types

insert into toolTypes(ToolType_id, ToolType_name)
values
    (
        1,
        'Diverse småutstyr'
    );

insert into toolTypes(tooltype_id, tooltype_name)
values
    (
        2,
        'Spikerpistoler o.l.'
    );

insert into toolTypes(tooltype_id, tooltype_name)
values
    (
        3,
        'Utstyr for vedhogst'
    );

insert into toolTypes(tooltype_id, tooltype_name)
values
    (
        4,
        'Tilhengere'
    );

insert into toolTypes(tooltype_id, tooltype_name)
values
    (
        5,
        'Større Utstyr'
    );

-- tools and images

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Eksentersliper 230VAC',
       1,
       'God',
       20,
       false,
       true,
       'Må betale papir',
       NULL,
       false,
       (select File_id from files where File_name = 'Eksentersliper 230V.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Båndsliper 230VAC',
       1,
       'God',
       20,
       false,
       true,
       'Må betale papir',
       NULL,
       false,
       (select File_id from files where File_name = 'Bandsliper 230v.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Høvel 230VAC',
       1,
       'God',
       20,
       false,
       true,
       null,
       NULL,
       false,
       (select File_id from files where File_name = 'Hovel 230v.PNG')
      );

-- no image

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Gjære-/kombisag 230VAC',
       1,
       'God',
       20,
       false,
       true,
       null,
       Null,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       '9` vinkelsliper 230VAC',
       1,
       'God',
       20,
       false,
       true,
       null,
       NULL,
       true,
       (select File_id from files where File_name = '9 Vinkelsliper Stein.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Meislemaskin 230VAC',
       1,
       'God',
       20,
       false,
       true,
       null,
       NULL,
       true,
       (select File_id from files where File_name = 'Meiselmaskin 230v.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Slagdrill, Batteri, Milwaukee',
       1,
       'God',
       20,
       false,
       true,
       null,
       NULL,
       true,
       (select File_id from files where File_name = 'Milwaukee Slagdrill.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Kantklipper -Bensin',
       1,
       'God',
       20,
       false,
       true,
       'Bruker oljeblandet bensin. Bruk kun ferdigblandet 2-takt alkylatbensin (2%)\n Dette er spesialbeninen med lang holdbarhet som kan kjøpes på bl.a. Felleskjøpet, Biltema og Jula (bilde)',
       NULL,
       true,
       (select File_id from files where File_name = 'Kantklipper Bensin.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Kompressor, 230VAC',
       1,
       'God',
       20,
       false,
       true,
       'Maks. trykk: 10 bar \nAvgitt luftmengde: 255 l/min \nEffekt: 1,5 kW',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Diagnoseringsverktøy, bil',
       1,
       'God',
       50,
       false,
       true,
       'Utstyres oppbevares hos Frank Welde \nBrukermanual oppbavares sammen med diagnoseringsverktøyet',
       NULL,
       true,
       (select File_id from files where File_name = 'Bildiagnose.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Vibratorplate "Hoppetusse", bensin',
       1,
       'God',
       50,
       false,
       true,
       'Vekt: 86kg\nBruker ren bensin minimum oktantall 95\nMotoroljenivå skjekkes før og etter bruk.\nOljetype: Shell Ultra Ect (AMV nr. 0095-0069)',
       NULL,
       true,
       (select File_id from files where File_name = 'Hoppetusse bensin.PNG')
      );


insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Flisekutter for keramiske fliser',
       1,
       'God',
       20,
       false,
       true,
       null,
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Skruautomat',
       1,
       'God',
       20,
       false,
       true,
       'Må betale skruer\nSe egen bruksanvisning vedlagt i oppbevaringskasse til skruautomat',
       NULL,
       true,
       (select File_id from files where File_name = 'Skruemaskin.PNG')
      );


insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Motorisert trillebår',
       1,
       'God',
       50,
       false,
       true,
       'Se egen bruksanvisning lagret her: [link] Brukermanual er også lagret i beholder\nViktig å lese brukermanual før bruk\n Bruk kun ren blyfri 95 oktan bensin\nSkjekk alltid motoroljenivå før oppstart\nSørg for å få en rask opplæring i bruk av dette utstyret før første gangs bruk',
       NULL,
       true,
       (select File_id from files where File_name = 'Motorisert trillebar.PNG')
      );



insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Spikerpistol, stor (trykkluft)',
       2,
       'God',
       20,
       false,
       true,
       null,
       NULL,
       true,
       NULL
      );



insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Spikerpistol, liten (trykkluft)',
       2,
       'God',
       20,
       false,
       true,
       null,
       NULL,
       true,
       (select File_id from files where File_name = 'Spikerpistol liten luft.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
          Tool_id,
          'Spikerpistol, stor (Milwaukee)',
          2,
          'God',
          20,
          false,
          true,
          null,
          NULL,
          true,
          (select File_id from files where File_name = 'Spikerpistol Milwaukee spiker stor.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
          Tool_id,
          'Spikerpistol, mellom (Milwaukee)',
          2,
          'God',
          20,
          false,
          true,
          null,
          NULL,
          true,
          (select File_id from files where File_name = 'Spikerpistol Milwaukee krampe mellom.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
          Tool_id,
          'Spikerpistol, liten (Milwaukee)',
          2,
          'God',
          20,
          false,
          true,
          null,
          NULL,
          true,
          (select File_id from files where File_name = 'Spikerpistol Milwaukee Dykk liten.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Vedkløyver bensindrevet',
       3,
       'God',
       50,
       false,
       true,
       'Bruker ren bensin, minimum oktantall 95\nMotoroljenivå skjekkes før og etter bruk. Oljetype: Shell Ultra Ect 5W-30 (AMV nr. 0095-0069)\nHydraulikkoljenivå skjekkes før og etter bruk. Oljetype: Shell Tellus S2VX 46 (AMV nr.0095-0069)\nKløyveren har ikke fjæring og tyngdepunktet er forholdsvis høyt så det må utvises forsiktighet med sleping etter kjøretøy. Dvs. tilpass farten etter forholdene',
       NULL,
       true,
       (select File_id from files where File_name = 'Vedkloyver bensin.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Fliskutter for trevirke',
       3,
       'God',
       50,
       false,
       true,
       'Se egen bruksanvisning lagret her [link]\nBrukermanual er også lagret i beholder på selve utstyret\nViktig å lese dette før bruk!\nskjekk alltid motoroljenivået før oppstart\nSørg for å få en rask opplæring i dette utstyret før første gang',
       NULL,
       true,
       (select File_id from files where File_name = 'Flisekutter Trevirke.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Tilhenger, boggi; RD 5702 \nKassemål LxBxH: 297x153x29cm\nNyttelast max. 1150kg',
       4,
       'God',
       50,
       false,
       true,
       'Hentes og leveres ved gassbu/kaldtlager\nHusk å ta med vognkort og el. kabel. Hentes i verktøy- eller lagerluke\nNB! Pass på at ikke el. kabel sleper i bakken slik at den blir ødelagt\nNormalt bør ikke parkeringsbrems settes på ved lagring da dette ofte fører til at bremser "henger seg" og blir vanskelige å løsne\nDet er leiers ansvar å sørge for at en ikke trekker tilhenger som er tyngre enn det førerkort og bil tillater\nBoggihenger har 13-polet el.kontakt\nHar du ikke rett kontakt på bilen kan overgang/adapter kjøpes på Biltema, Jula og de fleste bensinstasjoner',
       NULL,
       true,
       (select File_id from files where File_name = 'Tilhenger Boggi.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
          Tool_id,
          'Tilhenger, liten; RC 8834 \nKassemål LxBxH: 197x153x29cm\nNyttelast max. 645kg',
          4,
          'God',
          50,
          false,
          true,
          'Hentes og leveres ved gassbu/kaldtlager\nHusk å ta med vognkort og el. kabel. Hentes i verktøy- eller lagerluke\nNB! Pass på at ikke el. kabel sleper i bakken slik at den blir ødelagt\nNormalt bør ikke parkeringsbrems settes på ved lagring da dette ofte fører til at bremser "henger seg" og blir vanskelige å løsne\nDet er leiers ansvar å sørge for at en ikke trekker tilhenger som er tyngre enn det førerkort og bil tillater\nLiten henger har 7-polet el.kontakt\nHar du ikke rett kontakt på bilen kan overgang/adapter kjøpes på Biltema, Jula og de fleste bensinstasjoner',
          NULL,
          true,
          (select File_id from files where File_name = 'Tilhenger liten.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
          Tool_id,
          'Tilhenger, skap; JP 2591 \nKassemål LxBxH: 292x154x194cm\nNyttelast max. 1090kg',
          4,
          'God',
          50,
          false,
          true,
          'Hentes og leveres ved gassbu/kaldtlager\nHusk å ta med vognkort og el. kabel. Hentes i verktøy- eller lagerluke\nNB! Pass på at ikke el. kabel sleper i bakken slik at den blir ødelagt\nNormalt bør ikke parkeringsbrems settes på ved lagring da dette ofte fører til at bremser "henger seg" og blir vanskelige å løsne\nDet er leiers ansvar å sørge for at en ikke trekker tilhenger som er tyngre enn det førerkort og bil tillater\nSkaphenger er tenkt brukt til frakt av litt "finere ting" som ikke tåler vann og grus\nDet er derfor viktig at denne tilhengeren ikke brukes til frakt av grus, stein eller andre veldig skitne gjenstander\nSkaphenger har 13-polet el.kontakt\nHar du ikke rett kontakt på bilen kan overgang/adapter kjøpes på Biltema, Jula og de fleste bensinstasjoner',
          NULL,
          true,
          (select File_id from files where File_name = 'Tilhenger liten.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Personløfter, arb.høyde 12m\nSWL 200kg, 230VAC',
       5,
       'God',
       100,
       true,
       false,
       'NB! Dette utstyret kan kun benyttes av personer som har hatt dokumentert sikkerhetsopplæringiht. Forskrift om utførelse av arbeid §10-1 og 10-2. En slik opplæring består av teoretisk og praktisk opplæringsom gir kunnskap om oppbygging, betjening, bruksegenskaper og bruksområde samt vedlikehold og kontroll. Kursbevisutstedestil de som har gjennomført dette kurset.\nMaks løftekapasitet (SWL): 200kg inkl. 2personer.\nMaks hastighet ved kjøring langs vei er 72 km/t, men tilpass alltid hastighet etter veiforhold.\nHusk også å festetransportlås(eksenterstrammer)før transport, samt å frigjøredenne før bruk.\nLiften er ikke registrert og det er heller ikke nødvendig, men det er påbudt med lys. Siden lysbøyle bakpå liften er demonterbar er det viktig at bruker sjekker at denne er montert og virker.\nDet fins en egen manual kalt «Brukerens sikkerhetsveiledning»og «Brukermanual»som skal leses før utstyret tas i bruk.\nDisse skal alltid oppbevares i plastlomme i arbeidskorg\nI samme plastlomme er det også en tegning som viser liftens dekningsareal/rekkevidde.\nVed arbeid som kan innebære en del søl f.eks. malerarbeid er det brukers ansvar å dekke til nødvendige deler av utstyret med plast. Dette vil kunne spare en formye arbeid i ettertid.\nHusk å ta med nøkkel ved leie, samt å fjerne denne når utstyret ikke er i bruk.\nMaks. totalvekt på tilhengerlift er 1.432kg.\nDet er leiers ansvar å sørge for at en ikke trekker tilhenger som er tyngre enn det førerkort og bil tillater.\nSiden liften er relativt kostbar er det tegnet ansvar-og kaskoforsikring på denne. Skulle liften bli utsatt for skade som skyldes feil eller uvøren bruk, kan bruker bli erstatningspliktig. Erstatningsplikten vil kunne beløpe seg til egenandelen som for tiden er kr. 6000,-',
       NULL,
       true,
       (select File_id from files where File_name = 'Personloft Niftylift.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Strømaggregat, 3.7 kW (Diesel)',
       5,
       'God',
       50,
       false,
       true,
       'Bruker avgiftsfri diesel.\nMotoroljenivå sjekkes før og etter bruk. Oljetype: Shell Ultra Ect 5W-30 (AMV nr. 0095-0069)',
       NULL,
       true,
       (select File_id from files where File_name = 'Stromaggregat 3,7kw.PNG')
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Dekkomleggingsmaskin',
       5,
       'God',
       NULL,
       false,
       false,
       '1.Den som ønsker å legge om dekk må skrive seg på liste som er hengt opp på oppslagstavle i verkstedet ved lagerluke. Omlegging av dekk foregårkunetter avtale med Kenneth Glendrange. Hanhar hovedansvar for dette utstyretogkan kontaktes på mob. 97 15 19 97. Alt. kan Ingvar Pedersen kontaktes på mob. 48 99 58 85.\n2.Dekkomlegging skjer i den rekkefølge som en har skrevet seg på listen og foregår innerst i hall ved lakkeringsboks. Jekk og nødvendig verktøy samt trykkluft er tilgjengelig.\n3.Det er den enkeltes ansvar å skru av hjul å gjøre disse klare for omlegging til rett tid (det er selvfølgelig lov å spørre om hjelp (-: ), ellers hopper en til nestemann på listen.\n4.Etter omlegging/balansering er det den enkeltes ansvar å montere hjul igjen.\nRetur av gamle dekk er den enkeltes ansvar. Forhandlere har plikt til å ta kasserte dekk vederlagsfritt i retur. \nPris for omlegging av dekk inkl. avbalansering: 50,-/stk\nLapping av punktert dekk: 100,-/stk\nNB! AMV eller person som er ansvarlig for omlegging er ikke erstatningsansvarlig ved eventuell skade på dekk, felg eller kjøretøy.',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Avbalanseringsmaskin',
       5,
       'God',
       NULL,
       false,
       false,
       '1.Den som ønsker å legge om dekk må skrive seg på liste som er hengt opp på oppslagstavle i verkstedet ved lagerluke. Omlegging av dekk foregårkunetter avtale med Kenneth Glendrange. Hanhar hovedansvar for dette utstyretogkan kontaktes på mob. 97 15 19 97. Alt. kan Ingvar Pedersen kontaktes på mob. 48 99 58 85.\n2.Dekkomlegging skjer i den rekkefølge som en har skrevet seg på listen og foregår innerst i hall ved lakkeringsboks. Jekk og nødvendig verktøy samt trykkluft er tilgjengelig.\n3.Det er den enkeltes ansvar å skru av hjul å gjøre disse klare for omlegging til rett tid (det er selvfølgelig lov å spørre om hjelp (-: ), ellers hopper en til nestemann på listen.\n4.Etter omlegging/balansering er det den enkeltes ansvar å montere hjul igjen.\nRetur av gamle dekk er den enkeltes ansvar. Forhandlere har plikt til å ta kasserte dekk vederlagsfritt i retur. \nPris for omlegging av dekk inkl. avbalansering: 50,-/stk\nLapping av punktert dekk: 100,-/stk\nNB! AMV eller person som er ansvarlig for omlegging er ikke erstatningsansvarlig ved eventuell skade på dekk, felg eller kjøretøy.',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
       Tool_id,
       'Leilighet på Hovden',
       5,
       'God',
       NULL,
       false,
       false,
       'Kontakt resepsjonen hos AMV',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  ToolType_id,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  File_id)
values(
          Tool_id,
          'Testverktøy',
          1,
          'God',
          20,
          false,
          true,
          'Må erstattes om borte',
          NULL,
          true,
          NULL
      );


-- qualify some users

insert into qualification(Tool_id, User_id)
values(
        25,
        1
      );

insert into qualification(Tool_id, User_id)
values(
        25,
        4
      );

      insert into qualification(Tool_id, User_id)
values(
        25,
        6
      );

insert into qualification(Tool_id, User_id)
values(
        25,
        8
      );

insert into qualification(Tool_id, User_id)
values(
        25,
       3
      );
-- insert bookings (portfolio 2)
insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered)
values (
        Booking_id,
        1,
        7,
        '2021-11-20',
        '2021-11-24',
        0,
        '2021-11-24'
       );
update user set User_debt = User_debt +50 where User_id = 7;

insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered)
values (
           Booking_id,
           10,
           7,
           '2021-11-13',
           '2021-11-14',
           0,
            '2021-11-14'

       );
update user set User_debt = User_debt +50 where User_id = 7;

insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered)
values (
           Booking_id,
           5,
           3,
           '2021-11-23',
           '2021-11-26',
           0,
            null
       );
update user set User_debt = User_debt +60 where User_id = 3;

insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered)
values (
           Booking_id,
           8,
           4,
           '2021-11-22',
           '2021-11-23',
           0,
            null
       );
update user set User_debt = User_debt +50 where User_id = 4;

insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered)
values (
           Booking_id,
           20,
           3,
           '2021-11-23',
           '2021-11-27',
           0,
            null
       );
update user set User_debt = User_debt +200 where User_id = 3;

insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered)
values (
           Booking_id,
           13,
           3,
           '2021-11-21',
           '2021-11-22',
           0,
            null
       );
update user set User_debt = User_debt +20 where User_id = 3;

insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered)
values (
           Booking_id,
           9,
           3,
           '2021-11-01',
           '2021-11-10',
           0,
            '2021-11-11'
       );
update user set User_debt = User_debt +200 where User_id = 3;

insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered)
values (
           Booking_id,
           5,
           3,
           '2021-11-26',
           '2021-11-27',
           0,
            NULL
       );
update user set User_debt = User_debt +20 where User_id = 3;

insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid, Booking_dateDelivered)
values (
           Booking_id,
           10,
           3,
           '2021-11-26',
           '2021-11-27',
           0,
            null
       );
update user set User_debt = User_debt +50 where User_id = 3;

insert into damageReport(damagereport_id, user_id, tool_id, damagereport_message)
values (
        DamageReport_id,
        3,
        4,
        'ødelagt håndtaket'
       );

insert into damageReport(damagereport_id, user_id, tool_id, damagereport_message)
values (
        DamageReport_id,
        3,
        2,
        'mistet i bakken, klarer ikke spinne lenger'
       );

insert into damageReport(damagereport_id, user_id, tool_id, damagereport_message)
values (
        DamageReport_id,
        2,
        6,
        'meisler ikke lenger'
       );

insert into damageReport (DamageReport_id, User_id, Tool_id, DamageReport_message)
values (
        DamageReport_id,
        2,
        10,
        'diagnoserer bilene feil'
       );

insert into damageReport (DamageReport_id, User_id, Tool_id, DamageReport_message)
values (
        DamageReport_id,
        4,
        3,
        'blitt slapp i motoren'
       );






