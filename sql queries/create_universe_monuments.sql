DROP TABLE UM_Image;
DROP TABLE UM_Video;
DROP TABLE UM_Link;
DROP TABLE UM_Monument;
DROP TABLE UM_Owner;
DROP TABLE UM_Address;
DROP TABLE UM_Coordinates;
DROP TABLE UM_Dictionary;
DROP TABLE UM_UserRole;
DROP TABLE UM_Role;
DROP TABLE UM_User;
DROP SEQUENCE user_seq;
DROP SEQUENCE role_seq;
DROP SEQUENCE dictionary_seq;
DROP SEQUENCE coordinates_seq;
DROP SEQUENCE address_seq;
DROP SEQUENCE owner_seq;
DROP SEQUENCE monument_seq;
DROP SEQUENCE link_seq;
DROP SEQUENCE video_seq;
DROP SEQUENCE image_seq;

CREATE TABLE UM_User (
	user_id INTEGER PRIMARY KEY,
	login VARCHAR(50),
	password VARCHAR(260),
	name VARCHAR(50),
	surname VARCHAR(50)
);

CREATE TABLE UM_Role (
	role_id INTEGER PRIMARY KEY,
	name VARCHAR(12)
);

CREATE TABLE UM_UserRole (
	user_id INTEGER NOT NULL,
	role_id INTEGER NOT NULL,
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES UM_User (user_id),
	CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES UM_Role (role_id),
	PRIMARY KEY (user_id, role_id)
);

CREATE TABLE UM_Dictionary (
	dictionary_id INTEGER PRIMARY KEY,
	type VARCHAR(50),
	kind VARCHAR(50),
	description VARCHAR(254)
);

CREATE TABLE UM_Coordinates (
	coordinates_id INTEGER PRIMARY KEY,
	longitude FLOAT,
	latitude FLOAT
);

CREATE TABLE UM_Address (
	address_id INTEGER PRIMARY KEY,
	street VARCHAR(254),
	house_number VARCHAR(5),
	flat_number VARCHAR(5),
	post_code VARCHAR(50),
	city VARCHAR(254),
	country VARCHAR(40)
);

CREATE TABLE UM_Owner (
	owner_id INTEGER PRIMARY KEY,
	name1 VARCHAR(40),
    name2 VARCHAR(80),
	contact VARCHAR(254)
);

CREATE TABLE UM_Monument (
	monument_id INTEGER PRIMARY KEY,
	name VARCHAR(254),
	function VARCHAR(254),
	address_id INTEGER,
	author_id INTEGER,
	owner_id INTEGER,
	creation_date DATE,
	archival_source VARCHAR(500),
	monument_kind INTEGER,
	legal_status INTEGER,
	coordinates_id INTEGER,
	approved INTEGER,
	CONSTRAINT fk_address_id FOREIGN KEY (address_id) REFERENCES UM_Address (address_id),
	CONSTRAINT fk_author_id FOREIGN KEY (author_id) REFERENCES UM_User (user_id),
	CONSTRAINT fk_owner_id FOREIGN KEY (owner_id) REFERENCES UM_Owner (owner_id),
	CONSTRAINT fk_monument_kind FOREIGN KEY (monument_kind) REFERENCES UM_Dictionary (dictionary_id),
	CONSTRAINT fk_legal_status FOREIGN KEY (legal_status) REFERENCES UM_Dictionary (dictionary_id),
	CONSTRAINT fk_coordinates_id FOREIGN KEY (coordinates_id) REFERENCES UM_Coordinates (coordinates_id)
);

CREATE TABLE UM_Link (
	link_id INTEGER PRIMARY KEY,
	path VARCHAR(254),
	description VARCHAR(254),
	monument_id INTEGER,
	CONSTRAINT fk_monument_id_l FOREIGN KEY (monument_id) REFERENCES UM_Monument (monument_id)
);

CREATE TABLE UM_Video (
	video_id INTEGER PRIMARY KEY,
	path VARCHAR(254),
	description VARCHAR(254),
	monument_id INTEGER,
	CONSTRAINT fk_monument_id_v FOREIGN KEY (monument_id) REFERENCES UM_Monument (monument_id)
);

CREATE TABLE UM_Image (
	image_id INTEGER PRIMARY KEY,
	path VARCHAR(254),
	description VARCHAR(254),
	monument_id INTEGER,
	CONSTRAINT fk_monument_id_i FOREIGN KEY (monument_id) REFERENCES UM_Monument (monument_id)
);

CREATE SEQUENCE user_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE role_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE dictionary_seq  MINVALUE 1 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE coordinates_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE address_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE owner_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE monument_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE link_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE video_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE image_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;