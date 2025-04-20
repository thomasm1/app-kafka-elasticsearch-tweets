CREATE TABLE addresses
(
  id                 BIGINT AUTO_INCREMENT NOT NULL,
  version            INT                   NULL,
  date_created       datetime              NULL,
  time_created       datetime              NULL,
  last_updated       datetime              NULL,
  time_updated       datetime              NULL,
  `description`      VARCHAR(255)          NULL,
  owner              VARCHAR(255)          NULL,
  email              VARCHAR(255)          NULL,
  address            VARCHAR(255)          NULL,
  icon_url           VARCHAR(255)          NULL,
  block_explorer_url VARCHAR(255)          NULL,
  nft_address        VARCHAR(255)          NULL,
  user_userid        BIGINT                NULL,
  CONSTRAINT pk_addresses PRIMARY KEY (id)
);

CREATE TABLE attribute
(
  attrid           BIGINT       NOT NULL,
  version          INT          NULL,
  date_created     datetime     NULL,
  time_created     datetime     NULL,
  last_updated     datetime     NULL,
  time_updated     datetime     NULL,
  attribute_value  VARCHAR(255) NULL,
  trait_type       VARCHAR(255) NULL,
  metadata_coin_id BIGINT       NULL,
  CONSTRAINT pk_attribute PRIMARY KEY (attrid)
);

CREATE TABLE chain
(
  id                 BIGINT AUTO_INCREMENT NOT NULL,
  version            INT                   NULL,
  date_created       datetime              NULL,
  time_created       datetime              NULL,
  last_updated       datetime              NULL,
  time_updated       datetime              NULL,
  name               VARCHAR(255)          NULL,
  symbol             VARCHAR(255)          NULL,
  `description`      VARCHAR(255)          NULL,
  long_description   VARCHAR(255)          NULL,
  icon_url           VARCHAR(255)          NULL,
  category           VARCHAR(255)          NULL,
  chain_list_icon    VARCHAR(255)          NULL,
  rpc_url            VARCHAR(255)          NULL,
  chain_id           INT                   NULL,
  block_explorer_url VARCHAR(255)          NULL,
  chain_address_id   BIGINT                NULL,
  CONSTRAINT pk_chain PRIMARY KEY (id)
);

CREATE TABLE coin
(
  id           BIGINT AUTO_INCREMENT NOT NULL,
  version      INT                   NULL,
  date_created datetime              NULL,
  time_created datetime              NULL,
  last_updated datetime              NULL,
  time_updated datetime              NULL,
  native_token DOUBLE                NULL,
  address_id   BIGINT                NULL,
  CONSTRAINT pk_coin PRIMARY KEY (id)
);

CREATE TABLE metadata
(
  id            BIGINT       NOT NULL,
  version       INT          NULL,
  date_created  datetime     NULL,
  time_created  datetime     NULL,
  last_updated  datetime     NULL,
  time_updated  datetime     NULL,
  name          VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  image         VARCHAR(255) NULL,
  external_url  VARCHAR(255) NULL,
  CONSTRAINT pk_metadata PRIMARY KEY (id)
);

CREATE TABLE nft
(
  id           BIGINT AUTO_INCREMENT NOT NULL,
  version      INT                   NULL,
  date_created datetime              NULL,
  time_created datetime              NULL,
  last_updated datetime              NULL,
  time_updated datetime              NULL,
  name         VARCHAR(255)          NULL,
  amount       DOUBLE                NOT NULL,
  metadata_id  BIGINT                NULL,
  coin_id      BIGINT                NULL,
  CONSTRAINT pk_nft PRIMARY KEY (id)
);

CREATE TABLE raw_token
(
  id           BIGINT AUTO_INCREMENT NOT NULL,
  version      INT                   NULL,
  date_created datetime              NULL,
  time_created datetime              NULL,
  last_updated datetime              NULL,
  time_updated datetime              NULL,
  raw_token    VARCHAR(255)          NULL,
  coin_id      BIGINT                NULL,
  CONSTRAINT pk_raw_token PRIMARY KEY (id)
);

CREATE TABLE roles
(
  id   BIGINT AUTO_INCREMENT NOT NULL,
  name VARCHAR(255)          NOT NULL,
  CONSTRAINT pk_roles PRIMARY KEY (id)
);

CREATE TABLE users
(
  userid           BIGINT AUTO_INCREMENT NOT NULL,
  username         VARCHAR(255)          NULL,
  password         VARCHAR(255)          NULL,
  lastname         VARCHAR(255)          NULL,
  firstname        VARCHAR(255)          NULL,
  usertype         INT                   NULL,
  email            VARCHAR(255)          NOT NULL,
  organizationcode VARCHAR(255)          NULL,
  cusurl           VARCHAR(255)          NULL,
  dashboardcode    VARCHAR(255)          NULL,
  isactive         INT                   NULL,
  contacttype      INT                   NULL,
  CONSTRAINT pk_users PRIMARY KEY (userid)
);

CREATE TABLE users_roles
(
  role_id BIGINT NOT NULL,
  user_id BIGINT NOT NULL,
  CONSTRAINT pk_users_roles PRIMARY KEY (role_id, user_id)
);

CREATE TABLE weblinks
(
  id               BIGINT AUTO_INCREMENT NOT NULL,
  version          INT                   NULL,
  date_created     datetime              NULL,
  time_created     datetime              NULL,
  last_updated     datetime              NULL,
  time_updated     datetime              NULL,
  url              VARCHAR(255)          NULL,
  host             VARCHAR(255)          NULL,
  htmlpage         VARCHAR(255)          NULL,
  downloadstatus   SMALLINT              NULL,
  shared_by_userid BIGINT                NULL,
  CONSTRAINT pk_weblinks PRIMARY KEY (id)
);

ALTER TABLE nft
  ADD CONSTRAINT uc_nft_metadata UNIQUE (metadata_id);

ALTER TABLE roles
  ADD CONSTRAINT uc_roles_name UNIQUE (name);

ALTER TABLE addresses
  ADD CONSTRAINT FK_ADDRESSES_ON_USER_USERID FOREIGN KEY (user_userid) REFERENCES users (userid);

ALTER TABLE attribute
  ADD CONSTRAINT FK_ATTRIBUTE_ON_METADATA_COIN FOREIGN KEY (metadata_coin_id) REFERENCES metadata (id);

ALTER TABLE chain
  ADD CONSTRAINT FK_CHAIN_ON_CHAIN_ADDRESS FOREIGN KEY (chain_address_id) REFERENCES addresses (id);

ALTER TABLE coin
  ADD CONSTRAINT FK_COIN_ON_ADDRESS FOREIGN KEY (address_id) REFERENCES addresses (id);

ALTER TABLE nft
  ADD CONSTRAINT FK_NFT_ON_COIN FOREIGN KEY (coin_id) REFERENCES coin (id);

ALTER TABLE nft
  ADD CONSTRAINT FK_NFT_ON_METADATA FOREIGN KEY (metadata_id) REFERENCES metadata (id);

ALTER TABLE raw_token
  ADD CONSTRAINT FK_RAW_TOKEN_ON_COIN FOREIGN KEY (coin_id) REFERENCES coin (id);

ALTER TABLE weblinks
  ADD CONSTRAINT FK_WEBLINKS_ON_SHARED_BY_USERID FOREIGN KEY (shared_by_userid) REFERENCES users (userid);

ALTER TABLE users_roles
  ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

ALTER TABLE users_roles
  ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES users (userid);
