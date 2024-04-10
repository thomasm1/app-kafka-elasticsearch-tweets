create table ROLES
(
    id   INT NOT NULL,
    name VARCHAR(255),
    primary key (id)
);
commit;
create table USERS_ROLES
(
    id          INT NOT NULL,
    role_id     INT NOT NULL,
    user_userid INT NOT NULL,
    primary key (id)
);

create table  USERS
(
    USERID      INT NOT NULL,
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

create table NFT_REF
(
    id      INT NOT NULL,
    name    VARCHAR(255),
    owner   VARCHAR(255),
    chain_id   INT ,
    email_id    INT ,
    address_id  INT ,
    nft_id  INT ,

    primary key (id)
);

select * from Users;

create table COINTABLE
(
    coinid     INT NOT NULL,
    coinsymbol VARCHAR(255),
    cointoken  VARCHAR(255),
    pricetotal INT ,
    purchased  INT  ,
    primary key (coinid)
);
CREATE TABLE WEBLINK(id BIGINT PRIMARY KEY ,
                     title VARCHAR(500) ,
                     url VARCHAR(250) NOT NULL ,
                     host VARCHAR(250) ,
                     downloadstatus TINYINT,
                     htmlpage    VARCHAR(255));


create sequence cointable_seq start with 20 increment by 50;
create sequence id_maker start with 1 increment by 50;
create sequence nft_ref_seq start with 500 increment by 50;
create sequence roles_seq start with 700 increment by 50;
create sequence weblinks_seq start with 800 increment by 50;
create sequence movies_seq start with 900 increment by 50;

CREATE TABLE WEBLINK(id BIGINT PRIMARY KEY ,
                     title VARCHAR(500) ,
                     url VARCHAR(250) NOT NULL ,
                     host VARCHAR(250) ,
                     downloadstatus TINYINT,
                     htmlpage    VARCHAR(255));

CREATE TABLE CATEGORIES
(
    id            BIGINT       NOT NULL ,
    name          VARCHAR(255) NULL,
    description VARCHAR(255) NULL,
    urls          VARCHAR(255) NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id)
);

CREATE TABLE comments
(
    id      BIGINT       NOT NULL ,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    body    VARCHAR(255) NULL,
    post_id BIGINT       NOT NULL,
    CONSTRAINT pk_comments PRIMARY KEY (id)
);
CREATE TABLE post_entity
(
    id          BIGINT       NOT NULL ,
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
    offerid       INT          NOT NULL ,
    username      VARCHAR(255) NULL,
    coinid        INT          NULL,
    offeramt      DOUBLE PRECISION           NULL,
    offermos      INT          NULL,
    offerstatus   VARCHAR(255) NULL,
    description VARCHAR(255) NULL,
    target_date   date         NULL,
    done          INT          NULL,
    CONSTRAINT pk_offers PRIMARY KEY (offerid)
);

CREATE TABLE offerlogic
(
    id              INT          NOT NULL ,
    offerid         INT          NOT NULL,
    coinid          INT          NOT NULL,
    username        VARCHAR(255) NULL,
    pricetotal      DOUBLE PRECISION       NULL,
    offeramt        DOUBLE PRECISION           NULL,
    balance         DOUBLE PRECISION           NULL,
    offermos        INT          NOT NULL,
    monthsremaining INT          NULL,
    monthlypayments DOUBLE PRECISION           NULL,
    CONSTRAINT pk_offerlogic PRIMARY KEY (id)
);
CREATE TABLE authors
(
    id      INT          NOT NULL ,
    name    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    website VARCHAR(255) NULL,
    CONSTRAINT pk_authors PRIMARY KEY (id)
);

ALTER TABLE authors
    ADD CONSTRAINT uc_abce4f41cc0318786befbd2fe UNIQUE (id);

CREATE TABLE books
(
    id        BIGINT       NOT NULL ,
    pubyear   INT          NULL,
    publisher VARCHAR(255) NULL,
    authors   VARCHAR(255) NULL,
    genre     VARCHAR(255) NULL,
    rating    DOUBLE PRECISION           NOT NULL,
    title     VARCHAR(255) NULL,
    CONSTRAINT pk_books PRIMARY KEY (id)
);
