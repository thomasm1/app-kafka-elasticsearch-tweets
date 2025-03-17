-- DROP TABLE CHAIN_USERS  CASCADE CONSTRAINTS ;
-- DROP TABLE USERS_ROLES CASCADE CONSTRAINTS ;
-- DROP TABLE ROLES CASCADE CONSTRAINTS ;
-- DROP TABLE USERS CASCADE CONSTRAINTS ;
-- DROP TABLE ADDRESS CASCADE CONSTRAINTS ;
DROP TABLE METADATA CASCADE CONSTRAINTS;
DROP TABLE ATTRIBUTE CASCADE CONSTRAINTS;
DROP TABLE NFTADDRESS CASCADE CONSTRAINTS;
DROP TABLE nft_ref CASCADE CONSTRAINTS;
DROP TABLE CHAIN CASCADE CONSTRAINTS;
DROP TABLE NFT CASCADE CONSTRAINTS;


create table USERS_ROLES
(
  id NUMBER not null,
  userid NUMBER not null,
  role_id NUMBER not null,
  primary key (id)
);

--   drop table chain_users CASCADE  CONSTRAINTS;
create table chain_users
(
  id NUMBER not null,
  userid NUMBER not null,
  chain_id NUMBER not null,
  primary key (id)
);

--   drop table users CASCADE  CONSTRAINTS;
create table users
(
  USERID NUMBER not null,
  USERNAME  VARCHAR(255),
  PASSWORD  VARCHAR(120),
  LASTNAME  VARCHAR(255),
  FIRSTNAME VARCHAR(255),
  USERTYPE NUMBER (10, 0),
  PHONE     VARCHAR(50),
  EMAIL     VARCHAR(255),
  CUSURL    VARCHAR(255),
  PHOTOPATH VARCHAR(400),
  ISACTIVE NUMBER (10, 0),
  CONTACTTYPE NUMBER (10, 0),
  primary key (USERID)
);

--   drop table ROLES CASCADE  CONSTRAINTS;
create table ROLES
(
  id NUMBER not null,
  name varchar(255),
  primary key (id)
);


-- drop table chain CASCADE  CONSTRAINTS;
create table chain
(
  chain_id NUMBER not null,
  name               varchar(255),
  symbol             varchar(255),
  description        varchar(255),
  long_description   varchar(255),
  icon_url           varchar(255),
  category           varchar(255),
  chain_list_icon    varchar(255),
  rpc_url            varchar(255),
  id NUMBER,
  block_explorer_url varchar(255),
  primary key (chain_id)
);

-- drop table address CASCADE  CONSTRAINTS;
create table address
(
  id NUMBER not null,
  description        varchar(255),
  email              varchar(255),
  address            varchar(255), -- NFTADDRESS
  chain              varchar(255),
  icon_url           varchar(255),
  block_explorer_url varchar(255),
  users_userid NUMBER,
  chain_id NUMBER,
  primary key (id)
);
-- drop table coin CASCADE  CONSTRAINTS;
create table coin
(
  id NUMBER not null,
  amount NUMBER,
  name varchar(255),
  metadata_id NUMBER,
  primary key (id)
);
-- drop table NFTADDRESS CASCADE  CONSTRAINTS;
create table NFTADDRESS
(
  id NUMBER not null,
  address varchar(255),
  native_token NUMBER (13),
  tokens NUMBER (14),
  primary key (id)
);
-- drop table nft_ref CASCADE  CONSTRAINTS;
create table nft_ref
(
  id NUMBER not null,
  address varchar(255),
  chain   varchar(255),
  email   varchar(255),
  name    varchar(255),
  owner   varchar(255),
  primary key (id)
);

-- drop table COINTABLE CASCADE  CONSTRAINTS;
create table COINTABLE
(
  coinid NUMBER not null,
  coinsymbol varchar(255),
  cointoken  varchar(255),
  pricetotal NUMBER (13),
  purchased NUMBER not null,
  primary key (coinid)
);
CREATE TABLE BOOKMARK
(
  id NUMBER PRIMARY KEY,
  title      varchar(500),
  profileurl varchar(250),
  shared_by_userid NUMBER,
  owneremail varchar(255)
);
-- drop table WEBLINK CASCADE  CONSTRAINTS;
CREATE TABLE WEBLINK
(
  id NUMBER PRIMARY KEY,
  title    varchar(500),
  url      varchar(250) NOT NULL,
  host     varchar(250),
  downloadstatus NUMBER,
  htmlpage varchar(255)
);
-- drop table ATTRIBUTE CASCADE  CONSTRAINTS;
create table ATTRIBUTE
(
  attrid NUMBER,
  trait_type varchar(255),
  valu       varchar(255),
  metadata_metadata_id NUMBER,
  primary key (attrid)
);
-- drop TABLE METADATA CASCADE  CONSTRAINTS;
create table METADATA
(
  metadata_id NUMBER not null,
  description varchar(255),
  image       varchar(255),
  name        varchar(255),
  nft_id NUMBER,
  primary key (metadata_id)
);
--
--  create sequence address_seq start with 10 increment by 1;
--  create sequence attribute_seq start with 1000 increment by 1;
--  create sequence chain_seq start with 101 increment by 1;
--  create sequence cointable_seq start with 20 increment by 1;
--  create sequence id_maker start with 1 increment by 1;
--  create sequence metadata_seq start with 200 increment by 1;
--  create sequence nft_ref_seq start with 500 increment by 1;
--  create sequence nft_seq start with 600 increment by 1;
--  create sequence roles_seq start with 700 increment by 1;
--  create sequence weblinks_seq start with 800 increment by 1;
-- create sequence user_accounts_seq start with 800 increment by 1;

-- MANY TO ON
-- alter table attribute
--     add constraint FKik918ybmves03ibw6l10jj8d2 foreign key (metadata_metadata_id) references metadata;
--
-- alter table metadata
--     add constraint FK7xw0e76t7gnn5x9a254683a8 foreign key (nft_id) references coin;
--
--  -- MANY TO MANY
-- alter table chain_users
--     add constraint FKc12l3fx8me9k15hv0epjpjpbl foreign key (chain_id) references chain;
-- alter table chain_users
--     add constraint FK3psni4ui5db7mcih64fov3v39 foreign key (userid) references users;
