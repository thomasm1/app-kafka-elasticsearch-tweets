ALTER TABLE coin
  DROP FOREIGN KEY FK_NFT_ON_NFT;

ALTER TABLE raw_token
  DROP FOREIGN KEY FK_RAW_TOKEN_ON_NFTADDRESS;

ALTER TABLE nft_address_stamp_nfts
  DROP FOREIGN KEY fk_nftaddstanft_on_nft;

ALTER TABLE nft_address_stamp_nfts
  DROP FOREIGN KEY fk_nftaddstanft_on_nft_address;

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

ALTER TABLE coin
  ADD address_id BIGINT NULL;

ALTER TABLE coin
  ADD native_token DOUBLE NULL;

ALTER TABLE attribute
  ADD metadata_coin_id BIGINT NULL;

ALTER TABLE weblinks
  ADD shared_by_userid BIGINT NULL;

ALTER TABLE addresses
  ADD user_userid BIGINT NULL;

ALTER TABLE nft
  ADD CONSTRAINT uc_nft_metadata UNIQUE (metadata_id);

ALTER TABLE addresses
  ADD CONSTRAINT FK_ADDRESSES_ON_USER_USERID FOREIGN KEY (user_userid) REFERENCES users (userid);

ALTER TABLE attribute
  ADD CONSTRAINT FK_ATTRIBUTE_ON_METADATA_COIN FOREIGN KEY (metadata_coin_id) REFERENCES metadata (id);

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

DROP TABLE categories;

DROP TABLE nft_address_stamp;

DROP TABLE nft_address_stamp_nfts;

ALTER TABLE coin
  DROP COLUMN amount;

ALTER TABLE coin
  DROP COLUMN metadata;

ALTER TABLE coin
  DROP COLUMN name;

ALTER TABLE coin
  DROP COLUMN nft_address;

ALTER TABLE coin
  DROP COLUMN nft_id;

ALTER TABLE metadata
  DROP COLUMN coin;

ALTER TABLE attribute
  DROP COLUMN tokenid;
