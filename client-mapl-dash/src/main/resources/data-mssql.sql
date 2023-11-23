
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (211, 'Tom1@gmail.com', 'password', 'Smith', 'Tom1', 3,  '5055087707',        'Tom1@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a1.jpg', 'photoPath', 0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (212, 'Tom2@gmail.com', 'password', 'Maestas', 'Tom2', 3, '5055087707',        'Tom2@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a2.jpg','photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (213,'Tom3@gmail.com', 'password', 'Smith', 'Tom3', 3,  '5055087707', 'Tom3@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a3.jpg', 'photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (214,'Tom4@gmail.com', 'password', 'Smith', 'Tom4', 0, '5055087707', 'Tom4@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a4.jpg', 'photoPath',  0, 0);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (215, 'Tom5@gmail.com', 'password', 'Smith', 'Tom5', 3, '5055087707','Tom5@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a6.jpg', 'photoPath',  0,    1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (216, 'Tom6@gmail.com', 'password', 'Smith', 'Tom6', 3, '5055087707','Tom6@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a7.jpg', 'photoPath',  0,    1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (217,'tom7@gmail.com', 'password', 'maestas', 'tom7', 4, '999-999-9999','tom7@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (218,'Tom8@gmail.com', 'password', 'Smith', 'Tom8', 3,  '5055087707','Tom8@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath', 0,     1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (219, 'thomas.maestas@hotmail.com', 'password', 'Maestas', 'thomas', 0, '5055087707','thomas.maestas@hotmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 0);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (220, 'thomasm1.maestas@gmail.com', 'password', 'Maestas', 'thomasm1', 3, '5055087707','thomasm1.maestas@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 1);


INSERT INTO ROLES (id, name) VALUES (1,'ROLE_USER');
INSERT INTO ROLES (id, name) VALUES (2,'ROLE_ADMIN');

insert into USERS_ROLES(id, userid, role_id)values (1, 211, 2);
insert into USERS_ROLES(id, userid, role_id)values (2, 212, 1);
insert into USERS_ROLES(id, userid, role_id)values (3, 213, 1);
insert into USERS_ROLES(id, userid, role_id)values (4, 214, 1);
insert into USERS_ROLES(id, userid, role_id)values (5, 215, 1);
insert into USERS_ROLES(id, userid, role_id)values (6, 216, 1);
insert into USERS_ROLES(id, userid, role_id)values (7, 217, 1);
insert into USERS_ROLES(id, userid, role_id)values (8, 218, 1);
insert into USERS_ROLES(id, userid, role_id)values (9, 219, 2);
insert into USERS_ROLES(id, userid, role_id)values (10,220 ,2);


Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (1, 'ethereum',   'ETH', 12000.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (2, 'polygon',    'MATIC', 9.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (3, 'binance',    'BNB', 19.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (4, 'avalanche',  'AVAX', 119.22, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (5, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (6, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (7, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (8, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (9, 'pulsechain', 'SAA', 123.33, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (10, 'Hex',        'HEX', 0.03, 1);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (11, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (12, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (13, 'ethereum',   'ETH', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (14, 'binance',    'bsc', 45000, 0);
Insert into COINTABLE (COINID, COINTOKEN, COINSYMBOL, PRICETOTAL, PURCHASED)values (15, 'binance',    'bnb', 45000, 0);


INSERT INTO weblink (id, url, host, htmlpage, downloadstatus) VALUES (1, 'https://thomasmaestas.net', 'https://thomasmaestas.net', '<html>thomasmaestas</html>', 1);
INSERT INTO weblink (id, url, host, htmlpage, downloadstatus) VALUES (2, 'https://cryptomaven.xyz', 'https://cryptomaven.xyz', '<html>cryptomaven</html>', 1);
INSERT INTO weblink (id, url, host, htmlpage, downloadstatus) VALUES (3, 'https://mapl.app', 'https://mapl.app', '<html>mapl</html>', 2);
INSERT INTO weblink (id, url, host, htmlpage, downloadstatus) VALUES (4, 'https://thomasmaestas.net', 'https://thomasmaestas.net', '<html></html>',  3);
INSERT INTO weblink (id, url, host, htmlpage, downloadstatus) VALUES (5, 'https://thomasmaestas.net', 'https://thomasmaestas.net', '<html></html>',  4);
--

-- create sequence id_maker start with 250 increment by 50;
-- create sequence chains_seq start with 12000 increment by 50;
-- create sequence cointable_seq start with 2066 increment by 50;
-- create sequence nft_ref_seq start with 500 increment by 50;
-- create sequence roles_seq start with 5 increment by 50;
-- create sequence weblinks_seq start with 800 increment by 50;
-- create sequence addresses_seq start with 10600 increment by 50;
-- create sequence movies_seq start with 900 increment by 50;