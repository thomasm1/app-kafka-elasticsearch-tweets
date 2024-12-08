
    drop table if exists chain;

    drop table if exists user;

    create table chain (
       id varchar(36) not null,
        chain_name varchar(50) not null,
        chain_style smallint not null,
        created_date datetime(6),
        price decimal(38,2) not null,
        quantity_on_hand integer,
        upc varchar(255) not null,
        update_date datetime(6),
        version integer,
        primary key (id)
    ) engine=InnoDB;

    create table user (
       id varchar(36) not null,
        created_date datetime(6),
        name varchar(255),
        update_date datetime(6),
        version integer,
        primary key (id)
    ) engine=InnoDB;
