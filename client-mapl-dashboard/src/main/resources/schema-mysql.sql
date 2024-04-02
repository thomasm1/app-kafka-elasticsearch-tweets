create table ROLES
(
    id   INT not null AUTO_INCREMENT,
    name varchar(255),
    primary key (id)
);


create table  USERS
(
    USERID      INT not null AUTO_INCREMENT,
    USERNAME    VARCHAR(255),
    PASSWORD    VARCHAR(120),
    LASTNAME    VARCHAR(255),
    FIRSTNAME   VARCHAR(255),
    USERTYPE    FLOAT(10),
    ORGANIZATIONCODE       VARCHAR(50),
    EMAIL       VARCHAR(255),
    CUSURL      VARCHAR(255),
    DASHBOARDCODE   VARCHAR(400),
    ISACTIVE    FLOAT(10),
    CONTACTTYPE FLOAT(10),
    primary key (USERID)
);
create table USERS_ROLES
(
    id          INT not null AUTO_INCREMENT,
    role_id     INT not null,
    user_userid INT not null,
    primary key (id)
);

create table NFT_REF
(
    id      INT not null AUTO_INCREMENT,
    name    varchar(255),
    owner   varchar(255),
    chain_id   INT ,
    email_id    INT ,
    address_id  INT ,
    nft_id  INT ,
    primary key (id)
);



create table COINTABLE
(
    coinid     INT not null AUTO_INCREMENT,
    coinsymbol varchar(255),
    cointoken  varchar(255),
    pricetotal INT ,
    purchased  INT  ,
    primary key (coinid)
);
CREATE TABLE WEBLINK(id BIGINT PRIMARY KEY AUTO_INCREMENT,
                     title varchar(500) ,
                     url varchar(250) NOT NULL ,
#                      host varchar(250) ,
                     downloadstatus TINYINT,
                     htmlpage    varchar(255));

CREATE TABLE CATEGORIES
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    urls          VARCHAR(255) NULL,
    CONSTRAINT PK_CATEGORIES PRIMARY KEY (id)
);

CREATE TABLE COMMENTS
(
    id      BIGINT       NOT NULL AUTO_INCREMENT,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    body    VARCHAR(255) NULL,
    post_id BIGINT       NOT NULL,
    CONSTRAINT pk_comments PRIMARY KEY (id)
);
CREATE TABLE POST_ENTITY
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    did         VARCHAR(255) NOT NULL,
    date_       VARCHAR(255) NULL,
    author      VARCHAR(255) NULL,
    cat3        VARCHAR(255) NULL,
    title       VARCHAR(255) NOT NULL,
    post        VARCHAR(255) NOT NULL,
    blogcite    VARCHAR(255) NOT NULL,
    username    VARCHAR(255) NOT NULL,
    category_id BIGINT       NULL,
    CONSTRAINT pk_post_entity PRIMARY KEY (id)
);

ALTER TABLE POST_ENTITY
    ADD CONSTRAINT uc_6cd2046030c442c12bf79a923 UNIQUE (id);

ALTER TABLE POST_ENTITY
    ADD CONSTRAINT FK_POST_ENTITY_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES CATEGORIES (id);
ALTER TABLE COMMENTS
    ADD CONSTRAINT FK_COMMENTS_ON_POST FOREIGN KEY (post_id) REFERENCES POST_ENTITY (id);

CREATE TABLE OFFERS
(
    offerid       INT          NOT NULL AUTO_INCREMENT,
    username      VARCHAR(255) NULL,
    coinid        INT          NULL,
    offeramt      DOUBLE       NULL,
    offermos      INT          NULL,
    offerstatus   VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    target_date   date         NULL,
    done          BIT(1)       NOT NULL,
    CONSTRAINT PK_OFFERS PRIMARY KEY (offerid)
);
# ALTER TABLE post_entity RENAME TO POST_ENTITY;
CREATE TABLE OFFERLOGIC
(
    id              INT          NOT NULL AUTO_INCREMENT,
    offerid         INT          NOT NULL,
    coinid          INT          NOT NULL,
    username        VARCHAR(255) NULL,
    pricetotal      DOUBLE       NULL,
    offeramt        DOUBLE       NULL,
    balance         DOUBLE       NULL,
    offermos        INT          NOT NULL,
    monthsremaining INT          NULL,
    monthlypayments DOUBLE       NULL,
    CONSTRAINT PK_OFFERLOGIC PRIMARY KEY (id)
);
CREATE TABLE AUTHORS
(
    id      INT          NOT NULL AUTO_INCREMENT,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    website VARCHAR(255) NULL,
    CONSTRAINT PK_AUTHORS PRIMARY KEY (id)
);

ALTER TABLE AUTHORS
    ADD CONSTRAINT uc_abce4f41cc0318786befbd2fe UNIQUE (id);

CREATE TABLE BOOKS
(
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    pubyear   INT          NULL,
    publisher VARCHAR(255) NULL,
    authors   VARCHAR(255) NULL,
    genre     VARCHAR(255) NULL,
    rating    DOUBLE       NOT NULL,
    title     VARCHAR(255) NULL,
    CONSTRAINT PK_BOOKS PRIMARY KEY (id)
);
