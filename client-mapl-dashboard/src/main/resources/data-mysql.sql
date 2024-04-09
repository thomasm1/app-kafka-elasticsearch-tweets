
Insert into USERS (ID, USER_ID, LAST_NAME, FIRST_NAME, USERTYPE, ORGANIZATIONCODE, EMAIL, CUSURL, DASHBOARDCODE, ISACTIVE, CONTACTTYPE)values (211, 'Tom1@gmail.com', 'password', 'Smith', 'Tom1', 3,  '5055087707',        'Tom1@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a1.jpg', 'dashboardCode', 0, 1);
Insert into USERS (ID, USER_ID, LAST_NAME, FIRST_NAME, USERTYPE, ORGANIZATIONCODE, EMAIL, CUSURL, DASHBOARDCODE, ISACTIVE, CONTACTTYPE)values (212, 'Tom2@gmail.com', 'password', 'Maestas', 'Tom2', 3, '5055087707',        'Tom2@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a2.jpg','dashboardCode',  0, 1);
Insert into USERS (ID, USER_ID, LAST_NAME, FIRST_NAME, USERTYPE, ORGANIZATIONCODE, EMAIL, CUSURL, DASHBOARDCODE, ISACTIVE, CONTACTTYPE)values (213,'Tom3@gmail.com', 'password', 'Smith', 'Tom3', 3,  '5055087707', 'Tom3@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a3.jpg', 'dashboardCode',  0, 1);
Insert into USERS (ID, USER_ID, LAST_NAME, FIRST_NAME, USERTYPE, ORGANIZATIONCODE, EMAIL, CUSURL, DASHBOARDCODE, ISACTIVE, CONTACTTYPE)values (214,'Tom4@gmail.com', 'password', 'Smith', 'Tom4', 0, '5055087707', 'Tom4@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a4.jpg', 'dashboardCode',  0, 0);
Insert into USERS (ID, USER_ID, LAST_NAME, FIRST_NAME, USERTYPE, ORGANIZATIONCODE, EMAIL, CUSURL, DASHBOARDCODE, ISACTIVE, CONTACTTYPE)values (215, 'Tom5@gmail.com', 'password', 'Smith', 'Tom5', 3, '5055087707','Tom5@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a6.jpg', 'dashboardCode',  0,    1);
Insert into USERS (ID, USER_ID, LAST_NAME, FIRST_NAME, USERTYPE, ORGANIZATIONCODE, EMAIL, CUSURL, DASHBOARDCODE, ISACTIVE, CONTACTTYPE)values (216, 'Tom6@gmail.com', 'password', 'Smith', 'Tom6', 3, '5055087707','Tom6@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a7.jpg', 'dashboardCode',  0,    1);
Insert into USERS (ID, USER_ID, LAST_NAME, FIRST_NAME, USERTYPE, ORGANIZATIONCODE, EMAIL, CUSURL, DASHBOARDCODE, ISACTIVE, CONTACTTYPE)values (217,'tom7@gmail.com', 'password', 'maestas', 'tom7', 4, '999-999-9999','tom7@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'dashboardCode',  0, 1);
Insert into USERS (ID, USER_ID, LAST_NAME, FIRST_NAME, USERTYPE, ORGANIZATIONCODE, EMAIL, CUSURL, DASHBOARDCODE, ISACTIVE, CONTACTTYPE)values (218,'Tom8@gmail.com', 'password', 'Smith', 'Tom8', 3,  '5055087707','Tom8@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'dashboardCode', 0,     1);
Insert into USERS (ID, USER_ID, LAST_NAME, FIRST_NAME, USERTYPE, ORGANIZATIONCODE, EMAIL, CUSURL, DASHBOARDCODE, ISACTIVE, CONTACTTYPE)values (219, 'thomas.maestas@hotmail.com', 'password', 'Maestas', 'thomas', 0, '5055087707','thomas.maestas@hotmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'dashboardCode',  0, 0);
Insert into USERS (ID, USER_ID, LAST_NAME, FIRST_NAME, USERTYPE, ORGANIZATIONCODE, EMAIL, CUSURL, DASHBOARDCODE, ISACTIVE, CONTACTTYPE)values (220, 'thomas1.maestas@gmail.com', 'password', 'Maestas', 'thomasm1', 3, '5055087707','thomas1.maestas@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'dashboardCode',  0, 1);


INSERT INTO ROLES (id, name) VALUES (2,'ROLE_ADMIN');
INSERT INTO ROLES (id, name) VALUES (1,'ROLE_USER');

insert into USERS_ROLES(id, role_id, user_userid)values (1, 211, 2);
insert into USERS_ROLES(id, role_id, user_userid)values (2, 212, 1);
insert into USERS_ROLES(id, role_id, user_userid)values (3, 213, 1);
insert into USERS_ROLES(id, role_id, user_userid)values (4, 214, 1);
insert into USERS_ROLES(id, role_id, user_userid)values (5, 215, 1);
insert into USERS_ROLES(id, role_id, user_userid)values (6, 216, 1);
insert into USERS_ROLES(id, role_id, user_userid)values (7, 217, 1);
insert into USERS_ROLES(id, role_id, user_userid)values (8, 218, 1);
insert into USERS_ROLES(id, role_id, user_userid)values (9, 219, 2);
insert into USERS_ROLES(id, role_id, user_userid)values (10,220 ,2);

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

INSERT INTO WEBLINKS (id, url, htmlpage, downloadstatus) VALUES (1, 'https://thomasmaestas.net', '<html>thomasmaestas</html>', 1);
INSERT INTO WEBLINKS (id, url, htmlpage, downloadstatus) VALUES (2, 'https://cryptomaven.xyz', '<html>cryptomaven</html>', 1);
INSERT INTO WEBLINKS (id, url, htmlpage, downloadstatus) VALUES (3, 'https://mapl.app', '<html>mapl</html>', 2);
INSERT INTO WEBLINKS (id, url, htmlpage, downloadstatus) VALUES (4, 'https://thomasmaestas.net', '<html></html>',  3);
INSERT INTO WEBLINKS (id, url, htmlpage, downloadstatus) VALUES (5, 'https://thomasmaestas.net', '<html></html>',  4);
