
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (211, 'Tom1@gmail.com', 'password', 'Smith', 'Tom1', 3,  '5055087707',        'Tom1@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a1.jpg', 'photoPath', 0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (212, 'Tom2@gmail.com', 'password', 'Maestas', 'Tom2', 3, '5055087707',        'Tom2@gmail.com', 'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a2.jpg','photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (213,'Tom3@gmail.com', 'password', 'Smith', 'Tom3', 3,  '5055087707', 'Tom3@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a3.jpg', 'photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (214,'Tom4@gmail.com', 'password', 'Smith', 'Tom4', 0, '5055087707', 'Tom4@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a4.jpg', 'photoPath',  0, 0);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (215, 'Tom5@gmail.com', 'password', 'Smith', 'Tom5', 3, '5055087707','Tom5@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a6.jpg', 'photoPath',  0,    1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (216, 'Tom6@gmail.com', 'password', 'Smith', 'Tom6', 3, '5055087707','Tom6@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a7.jpg', 'photoPath',  0,    1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (217,'tom7@gmail.com', 'password', 'maestas', 'tom7', 4, '999-999-9999','tom7@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (218,'Tom8@gmail.com', 'password', 'Smith', 'Tom8', 3,  '5055087707','Tom8@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath', 0,     1);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (219, 'thomas.maestas@hotmail.com', 'password', 'Maestas', 'thomas', 0, '5055087707','thomas.maestas@hotmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 0);
Insert into USERS (USERID, USERNAME, PASSWORD, LASTNAME, FIRSTNAME, USERTYPE, PHONE, EMAIL, CUSURL, PHOTOPATH, ISACTIVE, CONTACTTYPE)values (220, 'thomas1.maestas@gmail.com', 'password', 'Maestas', 'thomas1', 3, '5055087707','thomas1.maestas@gmail.com',        'https://doggywood-veterinary.s3.amazonaws.com/assets/Animals/random_a8.jpg', 'photoPath',  0, 1);


INSERT INTO ROLES (id, name) VALUES (2,'ROLE_ADMIN');
INSERT INTO ROLES (id, name) VALUES (1,'ROLE_USER');

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


-- INSERT CHAIN
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11501, 'polygon', 'MATIC_2', 'matic  Chain', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/images/crypto/polygon.jpg', 'Mainnet', null, 'https://api.matic.network/ext/bc/C/rpc', 2402, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11551, 'avalanche', 'avax', 'avalanche C-Chain', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/images/crypto/avax.png', 'Mainnet', null, 'https://api.avax.network/ext/bc/C/rpc', 3,        null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11601, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT   0x1',        'https://s3.amazonaws.com/tmm.net/images/crypto/pulsechain.png', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png', 'https://rpc.pulsechain.io', 4, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11651, 'solana', 'sol', 'solana Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/images/crypto/solana.jpg', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png','https://api.mainnet-beta.solana.com', 3, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11701, 'polygon', 'matic', 'polygon Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/images/crypto/polygon.jpg', 'Mainnet', null, ' https://rpc-mainnet.maticvigil.com/', 3,null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11751, 'pulsechain', 'TPLS', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/images/crypto/pulsechain.png', 'Mainnet', null, 'https://rpc.testnet.pulsechain.com',240, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11801, 'ethereum', 'ETH23', 'ethereum Mainnet 23', 'NFT  0x1',        'https://s3.amazonaws.com/tmm.net/images/crypto/ether.png', 'ethereum', null, 'ETH RPC23', 3, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11851, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/images/crypto/pulsechain.png', 'Mainnet','https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 4, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11901, 'pulsechain', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/images/crypto/pulsechain.png', 'Mainnet',  'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 434, null);
Insert into CHAIN (CHAIN_ID, NAME, SYMBOL, DESCRIPTION, LONG_DESCRIPTION, ICON_URL, CATEGORY, CHAIN_LIST_ICON, RPC_URL,ID, BLOCK_EXPLORER_URL)values (11951, 'pulsechain7', 'pls', 'pulsechain Mainnet', 'NFT - 0x1',        'https://s3.amazonaws.com/tmm.net/images/crypto/pulsechain.png', 'Mainnet',        'https://friends-of-groot-society.s3.amazonaws.com/assets/android-chrome-384x384.png',        'https://rpc.pulsechain.io', 23, null);

-- -- INSERT PROJECT_user_RELATION
insert into chain_users (id, userid, chain_id)values (1, 211, 11501);
insert into chain_users (id, userid, chain_id)values (2, 212, 11551);
insert into chain_users (id, userid, chain_id)values (3, 213, 11601);
insert into chain_users (id, userid, chain_id)values (4, 214, 11651);
insert into chain_users (id, userid, chain_id)values (5, 215, 11701);
insert into chain_users (id, userid, chain_id)values (6, 216, 11751);
insert into chain_users (id, userid, chain_id)values (7, 217, 11801);
insert into chain_users (id, userid, chain_id)values (8, 218, 11851);
insert into chain_users (id, userid, chain_id)values (9, 219, 11901);
insert into chain_users (id, userid, chain_id)values (10,220, 11951);


Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )values (10001, 'description', 'Tom1@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',             'ropstein', 'ICON_URL', 'BLOCK_EXPLORER_URL', 211,  11501);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )values (10002, 'description', 'Tom2@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',             'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL', 212,  11551);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )values (10003, 'description', 'Tom3@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',             'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',213,  11601);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )values(10004, 'description', 'Tom4@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',            'polygon', 'ICON_URL', 'BLOCK_EXPLORER_URL',  214,   11651);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )values(10005, 'description', 'Tom5@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',            'polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL', 215,   11701);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )values (10006, 'description', 'Tom6@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A',             'ropstein', 'ICON_URL', 'BLOCK_EXPLORER_URL', 216,  11751);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )values(10007, 'description', 'Tom7@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',            'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',217,   11801);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )values(10008, 'description', 'Tom8@gmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF',            'ethereum',  'ICON_URL', 'BLOCK_EXPLORER_URL',218,   11851);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL,  USERID, CHAIN_ID )values(10009, 'description', 'thomas.maestas@hotmail.com', '0x900bE021E38B8d08435A03c05657C8cFA837cAeF','polygon',  'ICON_URL', 'BLOCK_EXPLORER_URL', 219,   11901);
Insert into ADDRESS (ID, DESCRIPTION, EMAIL, ADDRESS, CHAIN, ICON_URL, BLOCK_EXPLORER_URL, USERID, CHAIN_ID )values (10010, 'description', 'thomas1.maestas@gmail.com', '0x399EEc3B8e889a2E0853dd254f09C4535061693A', 'goerli', 'ICON_URL', 'BLOCK_EXPLORER_URL',   220,  11951);




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

INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (1001,'ethereum',5656,1);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (4001,'ethereum',5656,1);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (4002,'polygon',454,  2);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (4003,'avalanche',75757,3);
INSERT INTO NFT (ID,NAME,AMOUNT,METADATA_ID) VALUES (4004,'ethereum',5656,1);
