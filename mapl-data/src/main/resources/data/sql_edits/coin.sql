CREATE TABLE cointable (
    coinid NUMBER(10) NOT NULL,
    cointoken VARCHAR(30 ),
    coinsymbol VARCHAR(10 ),
    pricetotal NUMBER(10,2),
    purchased NUMBER(1));
    commit;

CREATE TABLE nfttable (
    nftid NUMBER(10) NOT NULL UNIQUE,
    name VARCHAR(100),
    amount NUMBER(10),
    metadata  NUMBER(10) NOT NULL   );

CREATE TABLE nftMetadata (
    metaid number(10) not null unique,
    name VARCHAR(100),
    description VARCHAR(400),
    image VARCHAR(200),
    attributes NUMBER(10) NOT NULL);


