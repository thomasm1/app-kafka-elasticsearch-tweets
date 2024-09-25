create table ROLES
(
    id   INT not null AUTO_INCREMENT,
    name varchar(255),
    primary key (id)
);

drop table users;
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

# select * from USERS;

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
                     host varchar(250) ,
                     downloadstatus TINYINT,
                     htmlpage    varchar(255));

CREATE TABLE CATEGORIES
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    name          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    urls          VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE comments
(
    id      BIGINT       NOT NULL AUTO_INCREMENT,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    body    VARCHAR(255) NULL,
    post_id BIGINT       NOT NULL,
    CONSTRAINT pk_comments PRIMARY KEY (id)
);
CREATE TABLE post_entity
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

ALTER TABLE post_entity
    ADD CONSTRAINT uc_6cd2046030c442c12bf79a923 UNIQUE (id);

ALTER TABLE post_entity
    ADD CONSTRAINT FK_POST_ENTITY_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES categories (id);
ALTER TABLE comments
    ADD CONSTRAINT FK_COMMENTS_ON_POST FOREIGN KEY (post_id) REFERENCES post_entity (id);

CREATE TABLE offers
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
    CONSTRAINT pk_offers PRIMARY KEY (offerid)
);

CREATE TABLE offerlogic
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
    CONSTRAINT pk_offerlogic PRIMARY KEY (id)
);
CREATE TABLE authors
(
    id      INT          NOT NULL AUTO_INCREMENT,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    website VARCHAR(255) NULL,
    CONSTRAINT pk_authors PRIMARY KEY (id)
);

ALTER TABLE authors
    ADD CONSTRAINT uc_abce4f41cc0318786befbd2fe UNIQUE (id);

CREATE TABLE books
(
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    pubyear   INT          NULL,
    publisher VARCHAR(255) NULL,
    authors   VARCHAR(255) NULL,
    genre     VARCHAR(255) NULL,
    rating    DOUBLE       NOT NULL,
    title     VARCHAR(255) NULL,
    CONSTRAINT pk_books PRIMARY KEY (id)
);
