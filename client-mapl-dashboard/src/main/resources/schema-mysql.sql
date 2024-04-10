
CREATE TABLE ROLES
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    'name'        VARCHAR(255) NULL,
    authority   VARCHAR(255) NULL,
    reference_id VARCHAR(255) NULL,
    created_by  BIGINT       NOT NULL,
    updated_by  BIGINT       NOT NULL,
    created_at  TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_rols_created_by FOREIGN KEY (created_by) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_rols_updated_by FOREIGN KEY (updated_by) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (id)
);

create table USER_ENTITY
(
    id  BIGINT NOT NULL AUTO_INCREMENT,
    user_id  VARCHAR(255) NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255),
    email      VARCHAR(255),
    phone      VARCHAR(255),
    bio       VARCHAR(255),
    reference_id VARCHAR(255),
    qr_code_secret    VARCHAR(255),
    qr_code_image_uri   text,
    image_url    VARCHAR(255),
    last_login    TIMESTAMP,
    login_attempts   INT DEFAULT  0,
    mfa BOOLEAN NOT NULL DEFAULT FALSE,
    account_non_expired  BOOLEAN  NOT NULL DEFAULT FALSE,
    account_non_locked   BOOLEAN  NOT NULL DEFAULT FALSE,
    enabled    BOOLEAN DEFAULT TRUE,
    created_by BIGINT NOT NULL,
    updated_by BIGINT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    constraint uq_users_email UNIQUE (email),
    constraint uq_users_user_id UNIQUE (user_id),
    constraint fk_users_created_by foreign key (created_by) references USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT,
    constraint fk_users_updated_by foreign key (updated_by) references USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT,
    PRIMARY KEY (id)
);

create table  USER_ROLES
(
    id   INT NOT NULL AUTO_INCREMENT,
    role_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT fk_user_roles_user_id FOREIGN KEY (user_id) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT,
    CONSTRAINT fk_user_roles_role_id FOREIGN KEY (role_id) REFERENCES ROLES (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE RESTRICT,
    PRIMARY KEY (id)
);

CREATE INDEX index_users_email ON USER_ENTITY (email);
CREATE INDEX index_users_user_id ON USER_ENTITY (user_id);
CREATE INDEX index_confirmations_user_id ON CONFIRMATIONS (user_id);
CREATE INDEX index_credentials_user_id ON CREDENTIALS (user_id);
CREATE INDEX index_user_roles_user_id ON USER_ROLES (user_id);
CREATE INDEX index_user_roles_role_id ON USER_ROLES (role_id);



-- deprecated users and users_roles tables


-- #
-- # -- deprecated users and users_roles tables
-- # create table USERS_ROLES
--     # (
--           #     id          INT NOT NULL AUTO_INCREMENT,
--           #     role_id     INT NOT NULL,
--           #     user_userid INT NOT NULL,
--           #     PRIMARY KEY (id)
--     # );
create table USERS
(
    ID                  INT auto_increment
        PRIMARY KEY,
    USER_ID             VARCHAR(255)                                                                        NOT NULL,
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
    MFA                 BOOLEAN      default FALSE                                                          NOT NULL,
    ENABLED             BOOLEAN      default FALSE                                                          null,
    ACCOUNT_NON_EXPIRED BOOLEAN      default FALSE                                                          null,
    ACCOUNT_NON_LOCKED  BOOLEAN      default FALSE                                                          NOT NULL,
    CREATED_BY          BIGINT                                                                              NOT NULL,
    UPDATED_BY          BIGINT                                                                              NOT NULL,
    CREATED_AT          TIMESTAMP                                                                           null,
    UPDATED_AT          TIMESTAMP                                                                           null,
    constraint uq_users_email
        unique (EMAIL),
    constraint uq_users_user_id
        unique (USER_ID),
    constraint fk_users_created_by
        foreign key (CREATED_BY) references USER_ENTITY (ID)
            on update cascade on delete cascade,
    constraint fk_users_updated_by
        foreign key (UPDATED_BY) references USER_ENTITY (ID)
            on update cascade on delete cascade
);


create table NFT_REF
(
    id      INT NOT NULL AUTO_INCREMENT,
    'name'    VARCHAR(255),
    'owner'   VARCHAR(255),
    chain_id   INT ,
    email_id    INT ,
    address_id  INT ,
    nft_id  INT ,
    PRIMARY KEY (id)
);



create table COINTABLE
(
    coinid     INT NOT NULL AUTO_INCREMENT,
    coinsymbol VARCHAR(255),
    cointoken  VARCHAR(255),
    pricetotal INT ,
    purchased  INT  ,
    PRIMARY KEY (coinid)
);
CREATE TABLE WEBLINK(id BIGINT PRIMARY KEY AUTO_INCREMENT,
                     title VARCHAR(500) ,
                     url VARCHAR(250) NOT NULL ,
#                      host VARCHAR(250) ,
                     downloadstatus TINYINT,
                     htmlpage    VARCHAR(255));

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

CREATE TABLE BOOKS_AUTHORS
(
    id       INT NOT NULL AUTO_INCREMENT,
    book_id  BIGINT       NOT NULL,
    author_id INT          NOT NULL,
    CONSTRAINT PK_BOOKS_AUTHORS PRIMARY KEY (id)
);

CREATE TABLE CONFIRMATIONS (
                               id  BIGINT PRIMARY KEY AUTO_INCREMENT,
                               keyz VARCHAR(255),
                               user_id BIGINT NOT NULL,
                               reference_id VARCHAR(255) NOT NULL,
                               created_by BIGINT NOT NULL,
                               updated_by BIGINT NOT NULL,
                               created_at TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
                               CONSTRAINT  uq_confirmations_user_id UNIQUE (user_id),
                               CONSTRAINT  uq_confirmations_key UNIQUE (keyz),
                               CONSTRAINT  fk_confirmations_user_id FOREIGN KEY (user_id) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
                               CONSTRAINT  fk_confirmations_created_by FOREIGN KEY (created_by) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
                               CONSTRAINT  fk_confirmations_updated_by FOREIGN KEY (updated_by) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE

);
CREATE TABLE CREDENTIALS (
                             id  BIGINT PRIMARY KEY AUTO_INCREMENT,
                             password VARCHAR(255) NOT NULL,
                             reference_id VARCHAR(255) NOT NULL,
                             user_id BIGINT NOT NULL,
                             created_by BIGINT NOT NULL,
                             updated_by BIGINT NOT NULL,
                             created_at TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
                             updated_at TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
                             CONSTRAINT  uq_credentials_user_id UNIQUE (user_id),
                             CONSTRAINT  fk_credentials_user_id FOREIGN KEY (user_id) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
                             CONSTRAINT  fk_credentials_created_by FOREIGN KEY (created_by) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
                             CONSTRAINT  fk_credentials_updated_by FOREIGN KEY (updated_by) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
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
                           created_at TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
                           updated_at TIMESTAMP   DEFAULT CURRENT_TIMESTAMP,
                           CONSTRAINT  fk_documents_document_id UNIQUE (document_id),
                           CONSTRAINT  fk_documents_created_by FOREIGN KEY (created_by) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
                           CONSTRAINT  fk_documents_updated_by FOREIGN KEY (updated_by) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE
);


create table  PERMISSIONS
(
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255) NULL,
    authority   VARCHAR(255) NULL,
    reference_id VARCHAR(255) NULL,
    created_by  BIGINT       NOT NULL,
    updated_by  BIGINT       NOT NULL,
    created_at  TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_permissions_created_by FOREIGN KEY (created_by) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_permissions_updated_by FOREIGN KEY (updated_by) REFERENCES USER_ENTITY (id) MATCH SIMPLE ON UPDATE CASCADE ON DELETE CASCADE,
    PRIMARY KEY (id)
);


CREATE INDEX IF NOT EXISTS index_users_email ON USER_ENTITY (email);
CREATE INDEX IF NOT EXISTS index_users_user_id ON USER_ENTITY (user_id);
CREATE INDEX IF NOT EXISTS index_confirmations_user_id ON CONFIRMATIONS (user_id);
CREATE INDEX IF NOT EXISTS index_credentials_user_id ON CREDENTIALS (user_id);
CREATE INDEX IF NOT EXISTS index_user_roles_user_id ON USER_ROLES (user_id);
CREATE INDEX IF NOT EXISTS index_user_roles_role_id ON USER_ROLES (role_id);
CREATE INDEX IF NOT EXISTS index_documents_user_id ON DOCUMENTS (user_id);
