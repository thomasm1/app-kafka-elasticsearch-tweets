ALTER TABLE cryptomav3n.nft
  DROP FOREIGN KEY FK_NFT_ON_NFT;

ALTER TABLE cryptomav3n.raw_token
  DROP FOREIGN KEY FK_RAW_TOKEN_ON_NFTADDRESS;

ALTER TABLE cryptomav3n.coin_nfts
  DROP FOREIGN KEY fk_nftaddstanft_on_nft;

ALTER TABLE cryptomav3n.coin_nfts
  DROP FOREIGN KEY fk_nftaddstanft_on_nft_address;

CREATE TABLE cryptomav3n.coin
(
  id           BIGINT AUTO_INCREMENT NOT NULL,
  version      INT                   NULL,
  date_created datetime              NULL,
  time_created datetime              NULL,
  last_updated datetime              NULL,
  time_updated datetime              NULL,
  native_token DOUBLE                NULL,
  nft_token    VARCHAR(255)          NULL,
  CONSTRAINT pk_coin PRIMARY KEY (id)
);

ALTER TABLE cryptomav3n.metadata
  ADD external_url VARCHAR(255) NULL;

ALTER TABLE cryptomav3n.nft
  ADD CONSTRAINT uc_nft_metadata UNIQUE (metadata);

ALTER TABLE cryptomav3n.attribute
  ADD CONSTRAINT FK_ATTRIBUTE_ON_ATTRID FOREIGN KEY (attrid) REFERENCES cryptomav3n.metadata (id);

ALTER TABLE cryptomav3n.raw_token
  ADD CONSTRAINT FK_RAW_TOKEN_ON_NFTADDRESS FOREIGN KEY (coin_id) REFERENCES cryptomav3n.coin (id);

DROP TABLE cryptomav3n.coin;

DROP TABLE cryptomav3n.coin_nfts;

ALTER TABLE cryptomav3n.metadata
  DROP COLUMN nft;

ALTER TABLE cryptomav3n.nft
  DROP COLUMN nft_id;

ALTER TABLE cryptomav3n.nft
  DROP COLUMN metadata;

ALTER TABLE cryptomav3n.nft
  DROP COLUMN nft_address;

ALTER TABLE cryptomav3n.nft
  ADD metadata BIGINT NULL;

ALTER TABLE cryptomav3n.nft
  ADD CONSTRAINT uc_nft_metadata UNIQUE (metadata);

ALTER TABLE cryptomav3n.nft
  ADD CONSTRAINT FK_NFT_ON_METADATA FOREIGN KEY (metadata) REFERENCES cryptomav3n.metadata (id);

ALTER TABLE cryptomav3n.nft
  ADD nft_address BIGINT NULL;

ALTER TABLE cryptomav3n.nft
  ADD CONSTRAINT FK_NFT_ON_NFT_ADDRESS FOREIGN KEY (nft_address) REFERENCES cryptomav3n.coin (id);
