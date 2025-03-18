
ALTER TABLE nft
  DROP FOREIGN KEY FK_NFT_ON_NFT;

ALTER TABLE coin_nfts
  DROP FOREIGN KEY fk_nftaddstanft_on_nft;

ALTER TABLE coin_nfts
  DROP FOREIGN KEY fk_nftaddstanft_on_nft_address;

ALTER TABLE coin
  ADD address_id BIGINT NULL;

ALTER TABLE nft
  ADD coin_id BIGINT NULL;

ALTER TABLE nft
  ADD metadata_id BIGINT NULL;

ALTER TABLE metadata
  ADD external_url VARCHAR(255) NULL;

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

ALTER TABLE weblinks
  ADD CONSTRAINT FK_WEBLINKS_ON_SHARED_BY_USERID FOREIGN KEY (shared_by_userid) REFERENCES users (userid);

DROP TABLE categories;

DROP TABLE coin_nfts;


ALTER TABLE coin
  DROP COLUMN coin;

ALTER TABLE coin
  DROP COLUMN nft_token;

ALTER TABLE nft
  DROP COLUMN metadata;

ALTER TABLE nft
  DROP COLUMN nft_address;

ALTER TABLE nft
  DROP COLUMN nft_id;

ALTER TABLE metadata
  DROP COLUMN nft;
