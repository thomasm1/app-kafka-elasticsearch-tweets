create table ROLES
(
  id   INT not null auto_increment,
  name varchar(255),
  primary key (id)
);

create table USERS_ROLES
(
  ID      INT not null auto_increment,
  USERID  INT not null,
  ROLE_ID INT not null,
  primary key (id)
);

create table USERS
(
  USERID      INT not null auto_increment,
  USERNAME    VARCHAR(255),
  PASSWORD    VARCHAR(120),
  LASTNAME    VARCHAR(255),
  FIRSTNAME   VARCHAR(255),
  USERTYPE    FLOAT(10),
  PHONE       VARCHAR(50),
  EMAIL       VARCHAR(255),
  CUSURL      VARCHAR(255),
  PHOTOPATH   VARCHAR(400),
  ISACTIVE    FLOAT(10),
  CONTACTTYPE FLOAT(10),
  primary key (USERID)
);

create table CHAIN
(
  chain_id           INT not null auto_increment,
  name               varchar(255),
  symbol             varchar(255),
  description        varchar(255),
  long_description   varchar(255),
  icon_url           varchar(255),
  category           varchar(255),
  chain_list_icon    varchar(255),
  rpc_url            varchar(255),
  id                 INT,
  block_explorer_url varchar(255),
  primary key (chain_id)
);
create table CHAIN_USERS
(
  id       INT not null auto_increment,
  chain_id INT not null,
  userid   INT not null,
  primary key (id)
);
--     create table attribute (attrid INT, trait_type varchar(255), valu varchar(255), metadata_metadata_id INT, primary key (attrid));

create table ADDRESS
(
  id                 INT not null auto_increment,
  description        varchar(255),
  email              varchar(255),
  address            varchar(255), -- NFTADDRESS
  chain              varchar(255),
  icon_url           varchar(255),
  block_explorer_url varchar(255),
  userid             INT,
  chain_id           INT,
  primary key (id)
);
create table NFT
(
  id          INT not null auto_increment,
  amount      INT,
  name        varchar(255),
  metadata_id INT,
  primary key (id)
);
create table NFTADDRESS
(
  id           INT not null auto_increment,
  address      varchar(255),
  native_token INT,
  tokens       INT,
  primary key (id)
);
create table NFT_REF
(
  id      INT not null auto_increment,
  address varchar(255),
  chain   varchar(255),
  email   varchar(255),
  name    varchar(255),
  owner   varchar(255),
  primary key (id)
);
create table NFT_TOKEN
(
  id      INT not null auto_increment,
  address varchar(255),
  chain   varchar(255),
  email   varchar(255),
  name    varchar(255),
  owner   varchar(255),
  primary key (id)
);

create table ATTRIBUTE
(
  attrid               INT auto_increment,
  trait_type           varchar(255),
  valu                 varchar(255),
  metadata_metadata_id INT,
  primary key (attrid)
);

create table METADATA
(
  metadata_id INT not null auto_increment,
  description varchar(255),
  image       varchar(255),
  name        varchar(255),
  nft_id      INT,
  primary key (metadata_id)
);
