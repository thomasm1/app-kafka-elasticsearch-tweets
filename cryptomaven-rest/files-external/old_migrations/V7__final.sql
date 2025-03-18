ALTER TABLE nft
  DROP FOREIGN KEY FK_NFT_ON_NFT;

ALTER TABLE raw_token
  DROP FOREIGN KEY FK_RAW_TOKEN_ON_NFTADDRESS;

ALTER TABLE coin_nfts
  DROP FOREIGN KEY fk_nftaddstanft_on_nft;

ALTER TABLE coin_nfts
  DROP FOREIGN KEY fk_nftaddstanft_on_nft_address;

CREATE TABLE coin
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

ALTER TABLE metadata
  ADD external_url VARCHAR(255) NULL;

ALTER TABLE nft
  ADD CONSTRAINT uc_nft_metadata UNIQUE (metadata);

ALTER TABLE attribute
  ADD CONSTRAINT FK_ATTRIBUTE_ON_ATTRID FOREIGN KEY (attrid) REFERENCES metadata (id);

ALTER TABLE raw_token
  ADD CONSTRAINT FK_RAW_TOKEN_ON_NFTADDRESS FOREIGN KEY (coin_id) REFERENCES coin (id);

DROP TABLE coin;

DROP TABLE coin_nfts;


ALTER TABLE metadata
  DROP COLUMN nft;

ALTER TABLE nft
  DROP COLUMN nft_id;

ALTER TABLE nft
  DROP COLUMN metadata;

ALTER TABLE nft
  DROP COLUMN nft_address;

ALTER TABLE nft
  ADD metadata BIGINT NULL;

ALTER TABLE nft
  ADD CONSTRAINT uc_nft_metadata UNIQUE (metadata);

ALTER TABLE nft
  ADD CONSTRAINT FK_NFT_ON_METADATA FOREIGN KEY (metadata) REFERENCES metadata (id);

ALTER TABLE nft
  ADD nft_address BIGINT NULL;

ALTER TABLE nft
  ADD CONSTRAINT FK_NFT_ON_NFT_ADDRESS FOREIGN KEY (nft_address) REFERENCES coin (id);
