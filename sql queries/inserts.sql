/* INSERTY */

INSERT INTO MROLE (ROLE_ID, ROLE_NAME) VALUES (role_seq.nextval, 'WOLONTARIUSZ');
INSERT INTO MROLE (ROLE_ID, ROLE_NAME) VALUES (role_seq.nextval, 'REDAKTOR');
INSERT INTO MROLE (ROLE_ID, ROLE_NAME) VALUES (role_seq.nextval, 'TURYSTA');

INSERT INTO MUSER (USER_ID, USER_LOGIN, USER_PASSWORD, USER_NAME, USER_SURNAME) VALUES (user_seq.nextval, 'dzasta94', '1234' , 'Justyna', 'Makowska');
INSERT INTO MUSER (USER_ID, USER_LOGIN, USER_PASSWORD, USER_NAME, USER_SURNAME) VALUES (user_seq.nextval, 'arksad95', '12345' , 'Arkadiusz', 'Sadowski');
INSERT INTO MUSER (USER_ID, USER_LOGIN, USER_PASSWORD, USER_NAME, USER_SURNAME) VALUES (user_seq.nextval, 'jendi94', '123456' , 'Jedrzej', 'Antkiewicz');
INSERT INTO MUSER (USER_ID, USER_LOGIN, USER_PASSWORD, USER_NAME, USER_SURNAME) VALUES (user_seq.nextval, 'blan95', '123' , 'Blanka', 'Sznyter');

INSERT INTO UserRole (USER_ID, ROLE_ID) VALUES (1, 1);
INSERT INTO UserRole (USER_ID, ROLE_ID) VALUES (2, 1);
INSERT INTO UserRole (USER_ID, ROLE_ID) VALUES (3, 1);
INSERT INTO UserRole (USER_ID, ROLE_ID) VALUES (4, 1);


INSERT INTO MDICTIONARY (DICTIONARY_ID, DICTIONARY_TYPE, DICTIONARY_KIND, DICTIONARY_DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'STATUS PRAWNY', 'REJESTR ZABYTKÓW', 'Wykaz obiektów uznanych za zabytki w danym kraju.');
INSERT INTO MDICTIONARY (DICTIONARY_ID, DICTIONARY_TYPE, DICTIONARY_KIND, DICTIONARY_DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'STATUS PRAWNY', 'POMNIK HISTORII', 'Przyznawany jest zabytkom nieruchomym o szczególnej wartości historycznej, naukowej i artystycznej, utrwalonym w powszechnej świadomości i mającym duże znaczenie dla dziedzictwa kulturalnego.');
INSERT INTO MDICTIONARY (DICTIONARY_ID, DICTIONARY_TYPE, DICTIONARY_KIND, DICTIONARY_DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'STATUS PRAWNY', 'PARK KULTUROWY', 'Chroni ona określony obszar krajobrazu kulturowego oraz wyróżniające się krajobrazowo tereny z zabytkami nieruchomymi.');
INSERT INTO MDICTIONARY (DICTIONARY_ID, DICTIONARY_TYPE, DICTIONARY_KIND, DICTIONARY_DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'STATUS PRAWNY', 'LOKALNA EWIDENCJA ZABYTKÓW', 'Ustalenie wymogów ochrony w miejscowym planie zagospodarowania przestrzennego lub w decyzji lokalizacyjnej');

INSERT INTO MDICTIONARY (DICTIONARY_ID, DICTIONARY_TYPE, DICTIONARY_KIND, DICTIONARY_DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'RODZAJ', 'NIERUCHOME', 'Np. krajobrazy, ukady urbanistyczne, budynki, obiekty techniki, cmentarze, parki, ogrody, miejsca upamiętniajace wydarzenia historyczne.');
INSERT INTO MDICTIONARY (DICTIONARY_ID, DICTIONARY_TYPE, DICTIONARY_KIND, DICTIONARY_DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'RODZAJ', 'RUCHOME', 'Np. dziela sztuki, kolekcje, numizmaty, wytwory techniki, ');
INSERT INTO MDICTIONARY (DICTIONARY_ID, DICTIONARY_TYPE, DICTIONARY_KIND, DICTIONARY_DESCRIPTION) VALUES (dictionary_seq.NEXTVAL, 'RODZAJ', 'ARCHEOLOGICZNE', 'Np. pozostalosci terenowe, cmentarzyska, relikty dzialanosci gospodarczej, religijnej i artystycznej');




INSERT INTO ADDRESS (ADRDESS_ID, STREET, POST_CODE, CITY, COUNTRY) VALUES
                    (address_seq.nextval, 'Dlugi Targ', '80-833', 'Gdańsk', 'Polska');
INSERT INTO OWNER (OWNER_ID, OWNER_NAME1, CONTACT) VALUES(owner_seq.nextval, 'Narodowy Instytut Dziedzictwa','228261714' );
INSERT INTO COORDINATES (COORDINATES_ID, LONGITUDE, LATITUDE) VALUES (coordinates_seq.nextval, 54.348575, 18.653364);
INSERT INTO MONUMENT (MONUMENT_ID, MONUMENT_NAME, MONUMENT_FUNCTION, ADDRESS_ID, OWNER_ID, CREATION_DATE, MONUMENT_KIND, LEGAL_STATUS, COORDINATES_ID, IS_APPROVED) VALUES
                (MONUMENT_SEQ.NEXTVAL, 'Fontanna Neptuna w Gdańsku', 'FONTANNA',  1,  1, '1633-01-01', 1, 1 ,1, 1);
  
  
INSERT INTO ADDRESS (ADRDESS_ID, STREET, POST_CODE, CITY, COUNTRY) VALUES
                    (adres_seq.nextval, 'Zator-Przytockiego','3', '80-001', 'Gdańsk', 'Polska');
INSERT INTO COORDINATES (COORDINATES_ID, LONGITUDE, LATITUDE) VALUES (coordinates_seq.nextval, 54.379798, 18.608972);
  
INSERT INTO MONUMENT (MONUMENT_ID, MONUMENT_NAME, MONUMENT_FUNCTION, ADDRESS_ID, OWNER_ID, CREATION_DATE, MONUMENT_KIND, LEGAL_STATUS, COORDINATES_ID, IS_APPROVED) VALUES
                (MONUMENT_SEQ.NEXTVAL, 'Kolegiata Gdańska pw. Serca Jazusowego w Gdańsku Wrzeszczu', 'kościól',  2, '1911-04-01', 2, 2 ,2, 1);
                

INSERT INTO ADDRESS (ADRDESS_ID, STREET, POST_CODE, CITY, COUNTRY) VALUES
                    (address_seq.nextval, 'Jana Pawla II','1', '81-817', 'Sopot', 'Polska');
INSERT INTO COORDINATES (COORDINATES_ID, LONGITUDE, LATITUDE) VALUES (coordinates_seq.nextval, 54.518646, 18.558488);
INSERT INTO MONUMENT (MONUMENT_ID, MONUMENT_NAME, MONUMENT_FUNCTION, ADDRESS_ID, OWNER_ID, CREATION_DATE, MONUMENT_KIND, LEGAL_STATUS, COORDINATES_ID, IS_APPROVED) VALUES
                (MONUMENT_SEQ.NEXTVAL, 'Pomnik Józefa Teodora Konrada Korzeniowskiego', 'pomnik',  3, '1976-06-19', 3, 3 ,3, 1);


INSERT INTO ADDRESS (ADRDESS_ID, STREET, POST_CODE, CITY, COUNTRY) VALUES
                    (address_seq.nextval, 'Malczewskiego', '81-345', 'Gdynia', 'Polska');
INSERT INTO COORDINATES (COORDINATES_ID, LONGITUDE, LATITUDE) VALUES (coordinates_seq.nextval, 54.450833, 18.546111);
INSERT INTO MONUMENT (MONUMENT_ID, MONUMENT_NAME, MONUMENT_FUNCTION, ADDRESS_ID, OWNER_ID, CREATION_DATE, MONUMENT_KIND, LEGAL_STATUS, COORDINATES_ID, IS_APPROVED) VALUES
                (MONUMENT_SEQ.NEXTVAL, 'Cmentarz żydowski w Sopocie', 'cmentarz',  4, '1913-01-01', 4, 1 ,4, 1);
