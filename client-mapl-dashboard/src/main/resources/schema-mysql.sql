create table ROLES
(
    id   BIGINT not null AUTO_INCREMENT,
    'name' varchar(255),
    primary key (id),
    authority varchar(255),
    reference_id varchar(255),
    created_by BIGINT NOT NULL,
    updated_by BIGINT NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    constraint fk_rols_created_by foreign key (created_by) references USERS (ID) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    constraint fk_rols_updated_by foreign key (updated_by) references USERS (ID) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE

);
# drop table USER_PROFILE;
create table USER_PROFILE
(
    id  BIGINT not null AUTO_INCREMENT,
    user_id  VARCHAR(255) not null,
    first_name varchar(255),
    last_name  varchar(255),
    email      varchar(255),
    phone      varchar(255),
    bio       varchar(255),
    reference_id VARCHAR(255),
    qr_code_secret    varchar(255),
    qr_code_image_uri   TEXT,
    image_url    varchar(255),
    last_login    timestamp,
    login_attempts   INT DEFAULT  0,
    mfa BOOLEAN NOT NULL DEFAULT FALSE,
    account_non_expired  BOOLEAN  NOT NULL DEFAULT FALSE,
    account_non_locked   BOOLEAN  NOT NULL DEFAULT FALSE,
    created_by BIGINT NOT NULL,
    updated_by BIGINT NOT NULL,
    created_at timestamp,
    updated_at timestamp,
    constraint uq_users_email UNIQUE (email),
    constraint uq_users_user_id UNIQUE (user_id),
    constraint fk_users_created_by foreign key (created_by) references USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    constraint fk_users_updated_by foreign key (updated_by) references USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    enabled    BOOLEAN DEFAULT TRUE,
    primary key (id)
);
# DROP TABLE CONFIRMATIONS;
CREATE TABLE CONFIRMATIONS (
    id  BIGINT PRIMARY KEY AUTO_INCREMENT,
    keyz VARCHAR(255),
    user_id BIGINT NOT NULL,
    reference_id VARCHAR(255) NOT NULL,
    created_by BIGINT NOT NULL,
    updated_by BIGINT NOT NULL,
    created_at timestamp   DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp   DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT  uq_confirmations_user_id UNIQUE (user_id),
    CONSTRAINT  uq_confirmations_key UNIQUE (keyz),
    CONSTRAINT  fk_confirmations_user_id FOREIGN KEY (user_id) REFERENCES USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT  fk_confirmations_created_by FOREIGN KEY (created_by) REFERENCES USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT  fk_confirmations_updated_by FOREIGN KEY (updated_by) REFERENCES USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE

);
CREATE TABLE CREDENTIALS (
    id  BIGINT PRIMARY KEY AUTO_INCREMENT,
    password VARCHAR(255) NOT NULL,
    reference_id VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL,
    created_by BIGINT NOT NULL,
    updated_by BIGINT NOT NULL,
    created_at timestamp   DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp   DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT  uq_credentials_user_id UNIQUE (user_id),
    CONSTRAINT  fk_credentials_user_id FOREIGN KEY (user_id) REFERENCES USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT  fk_credentials_created_by FOREIGN KEY (created_by) REFERENCES USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT  fk_credentials_updated_by FOREIGN KEY (updated_by) REFERENCES USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE DOCUMENTS (
    id  BIGINT PRIMARY KEY AUTO_INCREMENT,
    document_id VARCHAR(255) NOT NULL,
    extension VARCHAR(10) NOT NULL,
    formatted_size VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    icon VARCHAR(255) NOT NULL,
    reference_id VARCHAR(255) NOT NULL,
    uri VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    size BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created_by BIGINT NOT NULL,
    updated_by BIGINT NOT NULL,
    created_at timestamp   DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp   DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT  fk_documents_document_id UNIQUE (document_id),
    CONSTRAINT  fk_documents_created_by FOREIGN KEY (created_by) REFERENCES USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT  fk_documents_updated_by FOREIGN KEY (updated_by) REFERENCES USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);

create table  USER_ROLES
(
    id   INT not null AUTO_INCREMENT,
    role_id BIGINT not null,
    user_id BIGINT not null,
    CONSTRAINT fk_user_roles_user_id FOREIGN KEY (user_id) REFERENCES USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_user_roles_role_id FOREIGN KEY (role_id) REFERENCES ROLES (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    primary key (id)
);

CREATE INDEX index_users_email ON USER_PROFILE (email);
CREATE INDEX index_users_user_id ON USER_PROFILE (user_id);
CREATE INDEX index_confirmations_user_id ON CONFIRMATIONS (user_id);
CREATE INDEX index_credentials_user_id ON CREDENTIALS (user_id);
CREATE INDEX index_user_roles_user_id ON USER_ROLES (user_id);
CREATE INDEX index_user_roles_role_id ON USER_ROLES (role_id);

# create table  USER_PERMISSIONS
# (
#     id          INT not null AUTO_INCREMENT,
#     permission_id     BIGINT not null,
#     user_id BIGINT not null,
#     CONSTRAINT fk_user_permissions_user_id FOREIGN KEY (user_id) REFERENCES USER_PROFILE (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
#     CONSTRAINT fk_user_permissions_permission_id FOREIGN KEY (permission_id) REFERENCES PERMISSIONS (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
#     primary key (id)
# );




-- deprecated users and users_roles tables


create table USERS
(
    ID                  INT auto_increment
        primary key,
    USER_ID             VARCHAR(255)                                                                        not null,
    USERNAME            VARCHAR(255)                                                                       null,
    FIRST_NAME          VARCHAR(50)                                                                         null,
    LAST_NAME           VARCHAR(50)                                                                         null,
    EMAIL               VARCHAR(100)                                                                        null,
    PHONE               VARCHAR(30)                                                                         null,
    USER_TYPE           INTEGER      default 4                                                              null,
    IMAGE_URL           VARCHAR(255) default 'https://s3.amazonaws.com/friendsofgroot.com/assets/groot.png' null,
    ORGANIZATION_CODE   VARCHAR(50)                                                                         null,
    DASHBOARD_CODE      VARCHAR(400)                                                                        null,
    BIO                 VARCHAR(255)                                                                        null,
    REFERENCE_ID        VARCHAR(255)                                                                        null,
    QR_CODE_SECRET      VARCHAR(255)                                                                        null,
    QR_CODE_IMAGE_URI   TEXT                                                                                null,
    LAST_LOGIN          TIMESTAMP                                                                           null,
    LOGIN_ATTEMPTS      INT          default 0                                                              null,
    MFA                 BOOLEAN      default FALSE                                                          not null,
    ENABLED             BOOLEAN      default FALSE                                                          null,
    ACCOUNT_NON_EXPIRED BOOLEAN      default FALSE                                                          null,
    ACCOUNT_NON_LOCKED  BOOLEAN      default FALSE                                                          not null,
    CREATED_BY          BIGINT                                                                              not null,
    UPDATED_BY          BIGINT                                                                              not null,
    CREATED_AT          TIMESTAMP                                                                           null,
    UPDATED_AT          TIMESTAMP                                                                           null,
    constraint uq_users_email
        unique (EMAIL),
    constraint uq_users_user_id
        unique (USER_ID),
    constraint fk_users_created_by
        foreign key (CREATED_BY) references USER_PROFILE (ID)
            on update cascade on delete cascade,
    constraint fk_users_updated_by
        foreign key (UPDATED_BY) references USER_PROFILE (ID)
            on update cascade on delete cascade
);

#
# -- deprecated users and users_roles tables
# create table USERS_ROLES
# (
#     id          INT not null AUTO_INCREMENT,
#     role_id     INT not null,
#     user_userid INT not null,
#     primary key (id)
# );

create table NFT_REF
(
    id      INT not null AUTO_INCREMENT,
    'name'    varchar(255),
    'owner'   varchar(255),
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
    'name'          VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    urls          VARCHAR(255) NULL,
    CONSTRAINT PK_CATEGORIES PRIMARY KEY (id)
);

CREATE TABLE COMMENTS
(
    id      BIGINT       NOT NULL AUTO_INCREMENT,
    'name'    VARCHAR(255) NULL,
    email   VARCHAR(255) NULL,
    'body'    VARCHAR(255) NULL,
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
    'name'    VARCHAR(255) NULL,
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
    'authors'   VARCHAR(255) NULL,
    genre     VARCHAR(255) NULL,
    rating    DOUBLE       NOT NULL,
    title     VARCHAR(255) NULL,
    CONSTRAINT PK_BOOKS PRIMARY KEY (id)
);
