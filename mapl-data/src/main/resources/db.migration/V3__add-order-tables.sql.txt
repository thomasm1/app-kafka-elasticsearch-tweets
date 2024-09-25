drop table if exists chain_order_line;
drop table if exists chain_order;

CREATE TABLE `chain_order`
(
    id                 varchar(36) NOT NULL,
    created_date       datetime(6)  DEFAULT NULL,
    user_ref       varchar(255) DEFAULT NULL,
    last_modified_date datetime(6)  DEFAULT NULL,
    version            bigint       DEFAULT NULL,
    user_id        varchar(36)  DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (user_id) REFERENCES user (id)
) ENGINE = InnoDB;

CREATE TABLE `chain_order_line`
(
    id                 varchar(36) NOT NULL,
    chain_id            varchar(36) DEFAULT NULL,
    created_date       datetime(6) DEFAULT NULL,
    last_modified_date datetime(6) DEFAULT NULL,
    order_quantity     int         DEFAULT NULL,
    quantity_allocated int         DEFAULT NULL,
    version            bigint      DEFAULT NULL,
    chain_order_id      varchar(36) DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FOREIGN KEY (chain_order_id) REFERENCES chain_order (id),
    CONSTRAINT FOREIGN KEY (chain_id) REFERENCES chain (id)
) ENGINE = InnoDB;
