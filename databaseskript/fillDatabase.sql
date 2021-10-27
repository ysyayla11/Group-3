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
        'god',
        'god@gmail.com',
        98979691,
        '12345',
        'lommedalen',
        'Nei',
        true,
        500
    );

insert into access(User_FullName, Access_level)
values(
       'god',
       'Administrator'
      );

insert into access(User_FullName, Access_level)
values(
          'god',
          'user'
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
        'Jon Hansen Yayla',
        'Jhyayla@gmail.com',
        345655321,
        'Passord456',
        'Kongens gate 7',
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
        'Anders Jensen',
        'Crazyjensen@gmail.com',
        89765444,
        'Passord965',
        'Seasam Street 7',
        'Nei',
        true,
        50
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
        'Abdurrezzak Sheih',
        'Abdurrez@gmail.com',
        98654321,
        'Passord896',
        'Madridveien 35',
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
        'Luigi Ferrari',
        'Luigimario@gmail.com',
        57483988,
        'Passord321',
        'Juventus gate 43',
        'Nei',
        false,
        500000000
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
        'Camel Stock ',
        'CamelRichman@gmail.com',
        57684567,
        'Passord897',
        'Krakov 95',
        'Nei',
        false,
        100
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
        'Vladimir Trump',
        'VladimirTrump@gmail.com',
        87654321,
        'Passord666',
        'Moskov 43',
        'Ja',
        true,
        5000
    );
-- tools

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Eksentersliper 230VAC',
       'Diverse småutstyr',
       'God',
       20,
       false,
       true,
       'Må betale papir',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Båndsliper 230VAC',
       'Diverse småutstyr',
       'God',
       20,
       false,
       true,
       'Må betale papir',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Høvel 230VAC',
       'Diverse småutstyr',
       'God',
       20,
       false,
       true,
       '',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Gjære-/kombisag 230VAC',
       'Diverse småutstyr',
       'God',
       20,
       false,
       true,
       '',
       Null,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       '9` vinkelsliper 230VAC',
       'Diverse småutstyr',
       'God',
       20,
       false,
       true,
       '',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Meislemaskin 230VAC',
       'Diverse småutstyr',
       'God',
       20,
       false,
       true,
       '',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Slagdrill, Batteri, Milwaukee',
       'Diverse småutstyr',
       'God',
       20,
       false,
       true,
       '',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Kantklipper -Bensin',
       'Diverse småutstyr',
       'God',
       20,
       false,
       true,
       'Bruker oljeblandet bensin. Bruk kun ferdigblandet 2-takt alkylatbensin (2%)\n Dette er spesialbeninen med lang holdbarhet som kan kjøpes på bl.a. Felleskjøpet, Biltema og Jula (bilde)',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Kompressor, 230VAC',
       'Diverse småutstyr',
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
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Diagnoseringsverktøy, bil',
       'Diverse småutstyr',
       'God',
       50,
       false,
       true,
       'Utstyres oppbevares hos Frank Welde \nBrukermanual oppbavares sammen med diagnoseringsverktøyet',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Vibratorplate "Hoppetusse", bensin',
       'Diverse småutstyr',
       'God',
       50,
       false,
       true,
       'Vekt: 86kg\nBruker ren bensin minimum oktantall 95\nMotoroljenivå skjekkes før og etter bruk.\nOljetype: Shell Ultra Ect (AMV nr. 0095-0069)',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Flisekutter for keramiske fliser',
       'Diverse småutstyr',
       'God',
       20,
       false,
       true,
       '',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Skruautomat',
       'Diverse småutstyr',
       'God',
       20,
       false,
       true,
       'Må betale skruer\nSe egen bruksanvisning vedlagt i oppbevaringskasse til skruautomat',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Motorisert trillebår',
       'Diverse småutstyr',
       'God',
       50,
       false,
       true,
       'Se egen bruksanvisning lagret her: [link] Brukermanual er også lagret i beholder\nViktig å lese brukermanual før bruk\n Bruk kun ren blyfri 95 oktan bensin\nSkjekk alltid motoroljenivå før oppstart\nSørg for å få en rask opplæring i bruk av dette utstyret før første gangs bruk',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Spikerpistol, stor (trykkluft)',
       'Spikerpistoler o.l.',
       'God',
       20,
       false,
       true,
       '',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Spikerpistol, liten (trykkluft)',
       'Spikerpistoler o.l.',
       'God',
       20,
       false,
       true,
       '',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
          Tool_id,
          'Spikerpistol, stor (Milwaukee)',
          'Spikerpistoler o.l.',
          'God',
          20,
          false,
          true,
          '',
          NULL,
          true,
          NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
          Tool_id,
          'Spikerpistol, mellom (Milwaukee)',
          'Spikerpistoler o.l.',
          'God',
          20,
          false,
          true,
          '',
          NULL,
          true,
          NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
          Tool_id,
          'Spikerpistol, liten (Milwaukee)',
          'Spikerpistoler o.l.',
          'God',
          20,
          false,
          true,
          '',
          NULL,
          true,
          NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Vedkløyver bensindrevet',
       'Utstyr for VedHogst',
       'God',
       50,
       false,
       true,
       'Bruker ren bensin, minimum oktantall 95\nMotoroljenivå skjekkes før og etter bruk. Oljetype: Shell Ultra Ect 5W-30 (AMV nr. 0095-0069)\nHydraulikkoljenivå skjekkes før og etter bruk. Oljetype: Shell Tellus S2VX 46 (AMV nr.0095-0069)\nKløyveren har ikke fjæring og tyngdepunktet er forholdsvis høyt så det må utvises forsiktighet med sleping etter kjøretøy. Dvs. tilpass farten etter forholdene',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Fliskutter for trevirke',
       'Utstyr for vedhogst',
       'God',
       50,
       false,
       true,
       'Se egen bruksanvisning lagret her [link]\nBrukermanual er også lagret i beholder på selve utstyret\nViktig å lese dette før bruk!\nskjekk alltid motoroljenivået før oppstart\nSørg for å få en rask opplæring i dette utstyret før første gang',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Tilhenger, boggi; RD 5702 \nKassemål LxBxH: 297x153x29cm\nNyttelast max. 1150kg',
       'Tilhengere',
       'God',
       50,
       false,
       true,
       'Hentes og leveres ved gassbu/kaldtlager\nHusk å ta med vognkort og el. kabel. Hentes i verktøy- eller lagerluke\nNB! Pass på at ikke el. kabel sleper i bakken slik at den blir ødelagt\nNormalt bør ikke parkeringsbrems settes på ved lagring da dette ofte fører til at bremser "henger seg" og blir vanskelige å løsne\nDet er leiers ansvar å sørge for at en ikke trekker tilhenger som er tyngre enn det førerkort og bil tillater\nBoggihenger har 13-polet el.kontakt\nHar du ikke rett kontakt på bilen kan overgang/adapter kjøpes på Biltema, Jula og de fleste bensinstasjoner',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
          Tool_id,
          'Tilhenger, liten; RC 8834 \nKassemål LxBxH: 197x153x29cm\nNyttelast max. 645kg',
          'Tilhengere',
          'God',
          50,
          false,
          true,
          'Hentes og leveres ved gassbu/kaldtlager\nHusk å ta med vognkort og el. kabel. Hentes i verktøy- eller lagerluke\nNB! Pass på at ikke el. kabel sleper i bakken slik at den blir ødelagt\nNormalt bør ikke parkeringsbrems settes på ved lagring da dette ofte fører til at bremser "henger seg" og blir vanskelige å løsne\nDet er leiers ansvar å sørge for at en ikke trekker tilhenger som er tyngre enn det førerkort og bil tillater\nLiten henger har 7-polet el.kontakt\nHar du ikke rett kontakt på bilen kan overgang/adapter kjøpes på Biltema, Jula og de fleste bensinstasjoner',
          NULL,
          true,
          NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
          Tool_id,
          'Tilhenger, skap; JP 2591 \nKassemål LxBxH: 292x154x194cm\nNyttelast max. 1090kg',
          'Tilhengere',
          'God',
          50,
          false,
          true,
          'Hentes og leveres ved gassbu/kaldtlager\nHusk å ta med vognkort og el. kabel. Hentes i verktøy- eller lagerluke\nNB! Pass på at ikke el. kabel sleper i bakken slik at den blir ødelagt\nNormalt bør ikke parkeringsbrems settes på ved lagring da dette ofte fører til at bremser "henger seg" og blir vanskelige å løsne\nDet er leiers ansvar å sørge for at en ikke trekker tilhenger som er tyngre enn det førerkort og bil tillater\nSkaphenger er tenkt brukt til frakt av litt "finere ting" som ikke tåler vann og grus\nDet er derfor viktig at denne tilhengeren ikke brukes til frakt av grus, stein eller andre veldig skitne gjenstander\nSkaphenger har 13-polet el.kontakt\nHar du ikke rett kontakt på bilen kan overgang/adapter kjøpes på Biltema, Jula og de fleste bensinstasjoner',
          NULL,
          true,
          NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Personløfter, arb.høyde 12m\nSWL 200kg, 230VAC',
       'Større utstyr',
       'God',
       100,
       true,
       false,
       'NB! Dette utstyret kan kun benyttes av personer som har hatt dokumentert sikkerhetsopplæringiht. Forskrift om utførelse av arbeid §10-1 og 10-2. En slik opplæring består av teoretisk og praktisk opplæringsom gir kunnskap om oppbygging, betjening, bruksegenskaper og bruksområde samt vedlikehold og kontroll. Kursbevisutstedestil de som har gjennomført dette kurset.\nMaks løftekapasitet (SWL): 200kg inkl. 2personer.\nMaks hastighet ved kjøring langs vei er 72 km/t, men tilpass alltid hastighet etter veiforhold.\nHusk også å festetransportlås(eksenterstrammer)før transport, samt å frigjøredenne før bruk.\nLiften er ikke registrert og det er heller ikke nødvendig, men det er påbudt med lys. Siden lysbøyle bakpå liften er demonterbar er det viktig at bruker sjekker at denne er montert og virker.\nDet fins en egen manual kalt «Brukerens sikkerhetsveiledning»og «Brukermanual»som skal leses før utstyret tas i bruk.\nDisse skal alltid oppbevares i plastlomme i arbeidskorg\nI samme plastlomme er det også en tegning som viser liftens dekningsareal/rekkevidde.\nVed arbeid som kan innebære en del søl f.eks. malerarbeid er det brukers ansvar å dekke til nødvendige deler av utstyret med plast. Dette vil kunne spare en formye arbeid i ettertid.\nHusk å ta med nøkkel ved leie, samt å fjerne denne når utstyret ikke er i bruk.\nMaks. totalvekt på tilhengerlift er 1.432kg.\nDet er leiers ansvar å sørge for at en ikke trekker tilhenger som er tyngre enn det førerkort og bil tillater.\nSiden liften er relativt kostbar er det tegnet ansvar-og kaskoforsikring på denne. Skulle liften bli utsatt for skade som skyldes feil eller uvøren bruk, kan bruker bli erstatningspliktig. Erstatningsplikten vil kunne beløpe seg til egenandelen som for tiden er kr. 6000,-',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Strømaggregat, 3.7 kW (Diesel)',
       'Større utstyr',
       'God',
       50,
       false,
       true,
       'Bruker avgiftsfri diesel.\nMotoroljenivå sjekkes før og etter bruk. Oljetype: Shell Ultra Ect 5W-30 (AMV nr. 0095-0069)',
       NULL,
       true,
       NULL
      );

insert into tools(Tool_id,
                  Tool_name,
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Dekkomleggingsmaskin',
       'Større utstyr',
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
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Avbalanseringsmaskin',
       'Større Utstyr',
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
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
       Tool_id,
       'Leilighet på Hovden',
       'Større utstyr',
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
                  Tool_type,
                  Tool_condition,
                  Tool_price,
                  Tool_qualification,
                  Tool_freeFirstDay,
                  Tool_importantInformation,
                  Tool_maxDays,
                  Tool_delivered,
                  Tool_image)
values(
          Tool_id,
          'Testverktøy',
          'Diverse småutstyr',
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
insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid)
values (
        Booking_id,
        1,
        7,
        '2021-07-01',
        '2021-07-03',
        0

       );
insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid)
values (
           Booking_id,
           10,
           7,
           '2021-07-01',
           '2021-07-03',
           0

       );
insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid)
values (
           Booking_id,
           7,
           3,
           '2021-07-01',
           '2021-07-03',
           0

       );
insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid)
values (
           Booking_id,
           2,
           4,
           '2021-07-01',
           '2021-07-03',
           0

       );
insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid)
values (
           Booking_id,
           7,
           3,
           '2021-07-01',
           '2021-07-03',
           0

       );
insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid)
values (
           Booking_id,
           7,
           3,
           '2021-07-01',
           '2021-07-03',
           0

       );
insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid)
values (
           Booking_id,
           7,
           3,
           '2021-07-01',
           '2021-07-03',
           0

       );
insert into booking (Booking_id, Tool_id, User_id, Booking_dateStart, Booking_dateEnd, Booking_paid)
values (
           Booking_id,
           7,
           3,
           '2021-07-01',
           '2021-07-03',
           0

       );

