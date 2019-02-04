/* INSERTY */

INSERT INTO UM_ROLE (ROLE_ID, NAME) VALUES (role_seq.nextval, 'WOLONTARIUSZ');
INSERT INTO UM_ROLE (ROLE_ID, NAME) VALUES (role_seq.nextval, 'REDAKTOR');
INSERT INTO UM_ROLE (ROLE_ID, NAME) VALUES (role_seq.nextval, 'TURYSTA');

INSERT INTO UM_USER (USER_ID, LOGIN, PASSWORD, NAME, SURNAME) VALUES (user_seq.nextval, 'dzasta94', '1234' , 'Justyna', 'Makowska');
INSERT INTO UM_USER (USER_ID, LOGIN, PASSWORD, NAME, SURNAME) VALUES (user_seq.nextval, 'arksad95', '12345' , 'Arkadiusz', 'Sadowski');
INSERT INTO UM_USER (USER_ID, LOGIN, PASSWORD, NAME, SURNAME) VALUES (user_seq.nextval, 'jendi94', '123456' , 'Jedrzej', 'Antkiewicz');
INSERT INTO UM_USER (USER_ID, LOGIN, PASSWORD, NAME, SURNAME) VALUES (user_seq.nextval, 'blan95', '123' , 'Blanka', 'Sznyter');

INSERT INTO UM_UserRole (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO UM_UserRole (USER_ID, ROLE_ID) VALUES (2, 1);
INSERT INTO UM_UserRole (USER_ID, ROLE_ID) VALUES (3, 1);
INSERT INTO UM_UserRole (USER_ID, ROLE_ID) VALUES (4, 1);


INSERT INTO UM_DICTIONARY (DICTIONARY_ID, TYPE, KIND, DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'STATUS PRAWNY', 'REJESTR ZABYTKÓW', 'Wykaz obiektów uznanych za zabytki w danym kraju.');
INSERT INTO UM_DICTIONARY (DICTIONARY_ID, TYPE, KIND, DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'STATUS PRAWNY', 'POMNIK HISTORII', 'Przyznawany jest zabytkom nieruchomym o szczególnej wartości historycznej, naukowej i artystycznej, utrwalonym w powszechnej świadomości i mającym duże znaczenie dla dziedzictwa kulturalnego.');
INSERT INTO UM_DICTIONARY (DICTIONARY_ID, TYPE, KIND, DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'STATUS PRAWNY', 'PARK KULTUROWY', 'Chroni ona określony obszar krajobrazu kulturowego oraz wyróżniające się krajobrazowo tereny z zabytkami nieruchomymi.');
INSERT INTO UM_DICTIONARY (DICTIONARY_ID, TYPE, KIND, DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'STATUS PRAWNY', 'LOKALNA EWIDENCJA ZABYTKÓW', 'Ustalenie wymogów ochrony w miejscowym planie zagospodarowania przestrzennego lub w decyzji lokalizacyjnej');

INSERT INTO UM_DICTIONARY (DICTIONARY_ID, TYPE, KIND, DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'RODZAJ', 'NIERUCHOME', 'Np. krajobrazy, ukady urbanistyczne, budynki, obiekty techniki, cmentarze, parki, ogrody, miejsca upamiętniajace wydarzenia historyczne.');
INSERT INTO UM_DICTIONARY (DICTIONARY_ID, TYPE, KIND, DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'RODZAJ', 'RUCHOME', 'Np. dziela sztuki, kolekcje, numizmaty, wytwory techniki, ');
INSERT INTO UM_DICTIONARY (DICTIONARY_ID, TYPE, KIND, DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'RODZAJ', 'ARCHEOLOGICZNE', 'Np. pozostalosci terenowe, cmentarzyska, relikty dzialanosci gospodarczej, religijnej i artystycznej');




INSERT INTO UM_ADDRESS (ADDRESS_ID, STREET, POST_CODE, CITY, COUNTRY) VALUES
                    (address_seq.nextval, 'Dlugi Targ', '80-833', 'Gdańsk', 'Polska');
INSERT INTO UM_OWNER (OWNER_ID, NAME1, CONTACT) VALUES(owner_seq.nextval, 'Narodowy Instytut Dziedzictwa','228261714' );
INSERT INTO UM_COORDINATES (COORDINATES_ID, LONGITUDE, LATITUDE) VALUES (coordinates_seq.nextval, 54.348575, 18.653364);
INSERT INTO UM_MONUMENT (MONUMENT_ID,AUTHOR_ID, NAME, FUNCTION, ADDRESS_ID, OWNER_ID, CREATION_DATE, MONUMENT_KIND, LEGAL_STATUS, COORDINATES_ID, APPROVED) VALUES
                (MONUMENT_SEQ.NEXTVAL,4, 'Fontanna Neptuna w Gdańsku', 'FONTANNA',  1,  1, '1633-01-01', 1, 1 ,1, 1);
  
  
INSERT INTO UM_ADDRESS (ADDRESS_ID, STREET, POST_CODE, CITY, COUNTRY) VALUES
                    (address_seq.nextval, 'Zator-Przytockiego', '80-001', 'Gdańsk', 'Polska');
INSERT INTO UM_COORDINATES (COORDINATES_ID, LONGITUDE, LATITUDE)  VALUES (coordinates_seq.nextval, 54.379798, 18.608972);
  
INSERT INTO UM_MONUMENT (MONUMENT_ID,AUTHOR_ID, NAME, FUNCTION, ADDRESS_ID, OWNER_ID, CREATION_DATE, MONUMENT_KIND, LEGAL_STATUS, COORDINATES_ID, APPROVED) VALUES
                (MONUMENT_SEQ.NEXTVAL,3, 'Kolegiata Gdańska pw. Serca Jazusowego w Gdańsku Wrzeszczu', 'kościól',  2,1, '1911-04-01', 2, 2 ,2, 1);
                

INSERT INTO UM_ADDRESS (ADDRESS_ID, STREET, POST_CODE, CITY, COUNTRY) VALUES
                    (address_seq.nextval, 'Jana Pawla II', '81-817', 'Sopot', 'Polska');
INSERT INTO UM_COORDINATES (COORDINATES_ID, LONGITUDE, LATITUDE)  VALUES (coordinates_seq.nextval, 54.518646, 18.558488);
INSERT INTO UM_MONUMENT (MONUMENT_ID,AUTHOR_ID, NAME, FUNCTION, ADDRESS_ID, OWNER_ID, CREATION_DATE, MONUMENT_KIND, LEGAL_STATUS, COORDINATES_ID, APPROVED) VALUES
                    (MONUMENT_SEQ.NEXTVAL,1, 'Pomnik Józefa Teodora Konrada Korzeniowskiego', 'pomnik',  3,1, '1976-06-19', 3, 3 ,3, 1);


INSERT INTO UM_ADDRESS (ADDRESS_ID, STREET, POST_CODE, CITY, COUNTRY) VALUES
                    (address_seq.nextval, 'Malczewskiego', '81-345', 'Gdynia', 'Polska');
INSERT INTO UM_COORDINATES (COORDINATES_ID, LONGITUDE, LATITUDE) VALUES (coordinates_seq.nextval, 54.450833, 18.546111);
INSERT INTO UM_MONUMENT (MONUMENT_ID,AUTHOR_ID, NAME, FUNCTION, ADDRESS_ID, OWNER_ID, CREATION_DATE, MONUMENT_KIND, LEGAL_STATUS, COORDINATES_ID, APPROVED) VALUES
                (MONUMENT_SEQ.NEXTVAL,2, 'Cmentarz żydowski w Sopocie', 'cmentarz',  4,1, '1913-01-01', 4, 1 ,4, 1);
