

create table USERS_ROLES
(
    id NUMBER NOT NULL,
    userid NUMBER NOT NULL,
    role_id     NUMBER NOT NULL,
    primary key (id)
);

--   drop table coin_users CASCADE  CONSTRAINTS;
-- create table coin_users
-- (
--     id       NUMBER  NOT NULL,
--     userid   NUMBER  NOT NULL,
--     coin_id NUMBER  NOT NULL,
--     primary key (id)
-- );

--   drop table users CASCADE  CONSTRAINTS;
create table users
(
    USERID      NUMBER NOT NULL,
    USERNAME    VARCHAR(255),
    PASSWORD    VARCHAR(120),
    LASTNAME    VARCHAR(255),
    FIRSTNAME   VARCHAR(255),
    USERTYPE    NUMBER(10, 0),
    ORGANIZATIONCODE       VARCHAR(50),
    EMAIL       VARCHAR(255),
    CUSURL      VARCHAR(255),
    DASHBOARDCODE   VARCHAR(400),
    ISACTIVE    NUMBER(10, 0),
    CONTACTTYPE NUMBER(10, 0) ,
    primary key (USERID)
);

--   drop table roles CASCADE  CONSTRAINTS;
create table  roles
(
    id   NUMBER NOT NULL,
    name VARCHAR(255),
    primary key (id)
);


-- drop table chain CASCADE  CONSTRAINTS;
create table chain
(
    chain_id           NUMBER NOT NULL,
    name               VARCHAR(255),
    symbol             VARCHAR(255),
    description        VARCHAR(255),
    long_description   VARCHAR(255),
    icon_url           VARCHAR(255),
    category           VARCHAR(255),
    chain_list_icon    VARCHAR(255),
    rpc_url            VARCHAR(255),
    id                 NUMBER,
    block_explorer_url VARCHAR(255),
    primary key (chain_id)
);

-- drop table address CASCADE  CONSTRAINTS;
create table address
(
    id                 NUMBER NOT NULL,
    description        VARCHAR(255),
    email              VARCHAR(255),
    address            VARCHAR(255), -- nft_address
    chain              VARCHAR(255),
    icon_url           VARCHAR(255),
    block_explorer_url VARCHAR(255),
    users_userid       NUMBER,
    chain_id            NUMBER,
    primary key (id)
);
-- drop table nft CASCADE  CONSTRAINTS;
create table nft
(
    id          NUMBER NOT NULL,
    amount      NUMBER,
    name        VARCHAR(255),
    metadata_id NUMBER,
    primary key (id)
);
-- drop table nft_address CASCADE  CONSTRAINTS;
create table nft_address
(
    id           NUMBER NOT NULL,
    address      VARCHAR(255),
    native_token NUMBER(13),
    native       NUMBER(13),
    tokens       NUMBER(14),
    primary key (id)
);
-- drop table nft_ref CASCADE  CONSTRAINTS;
create table nft_ref
(
    id      NUMBER NOT NULL,
    address VARCHAR(255),
    chain   VARCHAR(255),
    email   VARCHAR(255),
    name    VARCHAR(255),
    owner   VARCHAR(255),
    primary key (id)
);

-- drop table COINTABLE CASCADE  CONSTRAINTS;
create table COINTABLE
(
    coinid     NUMBER NOT NULL,
    coinsymbol VARCHAR(255),
    cointoken  VARCHAR(255),
    pricetotal NUMBER(13),
    purchased  NUMBER NOT NULL,
    primary key (coinid)
);
CREATE TABLE BOOKMARK(id NUMBER PRIMARY KEY ,
                     title VARCHAR(500) ,
                      profileurl VARCHAR(250)  ,
                      shared_by_userid NUMBER,
                      owneremail    VARCHAR(255)
);
-- drop table WEBLINK CASCADE  CONSTRAINTS;
CREATE TABLE WEBLINK(id NUMBER PRIMARY KEY ,
                     title VARCHAR(500) ,
                     url VARCHAR(250) NOT NULL ,
                     host VARCHAR(250) ,
                     downloadstatus NUMBER,
                     htmlpage    VARCHAR(255)
);
-- drop table ATTRIBUTE CASCADE  CONSTRAINTS;
create table ATTRIBUTE
(
    attrid               NUMBER,
    trait_type           VARCHAR(255),
    valu                 VARCHAR(255),
    metadata_metadata_id NUMBER,
    primary key (attrid)
);
-- drop TABLE METADATA CASCADE  CONSTRAINTS;
create table METADATA
(
    metadata_id NUMBER NOT NULL,
    description VARCHAR(255),
    image       VARCHAR(255),
    name        VARCHAR(255),
    nft_id      NUMBER,
    primary key (metadata_id)
);

 create sequence address_seq start with 10 increment by 50;
 create sequence attribute_seq start with 1000 increment by 50;
 create sequence chain_seq start with 101 increment by 50;
 create sequence cointable_seq start with 20 increment by 50;
 create sequence id_maker start with 1 increment by 50;
 create sequence metadata_seq start with 200 increment by 50;
 create sequence nft_ref_seq start with 500 increment by 50;
 create sequence nft_seq start with 600 increment by 50;
 create sequence roles_seq start with 700 increment by 50;
 create sequence weblinks_seq start with 800 increment by 50;
 create sequence bookmark_seq start with 800 increment by 50;

-- MANY TO ON
-- alter table attribute
--     add constraint FKik918ybmves03ibw6l10jj8d2 foreign key (metadata_metadata_id) references metadata;
--
-- alter table metadata
--     add constraint FK7xw0e76t7gnn5x9a254683a8 foreign key (nft_id) references nft;
--
--  -- MANY TO MANY
-- alter table chain_users
--     add constraint FKc12l3fx8me9k15hv0epjpjpbl foreign key (chain_id) references chain;
-- alter table chain_users
--     add constraint FK3psni4ui5db7mcih64fov3v39 foreign key (userid) references users;
