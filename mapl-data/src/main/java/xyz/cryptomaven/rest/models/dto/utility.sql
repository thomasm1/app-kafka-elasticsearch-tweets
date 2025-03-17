-- we don't know how to generate root <with-no-name> (class Root) :(

grant select on performance_schema.* to 'mysql.session'@localhost;

grant trigger on sys.* to 'mysql.sys'@localhost;

grant audit_abort_exempt, firewall_exempt, select, system_user on *.* to 'mysql.infoschema'@localhost;

grant audit_abort_exempt, authentication_policy_admin, backup_admin, clone_admin, connection_admin, firewall_exempt, persist_ro_variables_admin, session_variables_admin, system_user, system_variables_admin on *.* to 'mysql.session'@localhost;

grant audit_abort_exempt, firewall_exempt, system_user on *.* to 'mysql.sys'@localhost;

grant alter, alter routine, application_password_admin, create, create role, create routine, create temporary tables, create user, create view, delete, drop, drop role, event, execute, flush_optimizer_costs, flush_status, flush_tables, flush_user_resources, index, insert, lock tables, process, references, reload, replication client, replication slave, role_admin, select, sensitive_variables_observer, session_variables_admin, set_user_id, show databases, show view, show_routine, trigger, update, xa_recover_admin, grant option on *.* to rds_superuser_role;

grant alter, alter routine, application_password_admin, audit_abort_exempt, audit_admin, authentication_policy_admin, backup_admin, binlog_admin, binlog_encryption_admin, clone_admin, connection_admin, create, create role, create routine, create tablespace, create temporary tables, create user, create view, delete, drop, drop role, encryption_key_admin, event, execute, file, firewall_exempt, flush_optimizer_costs, flush_status, flush_tables, flush_user_resources, group_replication_admin, group_replication_stream, index, innodb_redo_log_archive, innodb_redo_log_enable, insert, lock tables, passwordless_user_admin, persist_ro_variables_admin, process, references, reload, replication client, replication slave, replication_applier, replication_slave_admin, resource_group_admin, resource_group_user, role_admin, select, sensitive_variables_observer, service_connection_admin, session_variables_admin, set_user_id, show databases, show view, show_routine, shutdown, super, system_user, system_variables_admin, table_encryption_admin, telemetry_log_admin, trigger, update, xa_recover_admin, grant option on *.* to rdsadmin@localhost;

create table addresses
(
  id                 bigint auto_increment
    primary key,
  version            int          null,
  date_created       datetime     null,
  time_created       datetime     null,
  last_updated       datetime     null,
  time_updated       datetime     null,
  description        varchar(255) null,
  owner              varchar(255) null,
  address            varchar(255) null,
  icon_url           varchar(255) null,
  block_explorer_url varchar(255) null,
  nft_address        varchar(255) null,
  email              varchar(255) null
);

create table attribute
(
  attrid          bigint       not null
    primary key,
  version         int          null,
  date_created    datetime     null,
  time_created    datetime     null,
  last_updated    datetime     null,
  time_updated    datetime     null,
  attribute_value varchar(255) null,
  trait_type      varchar(255) null
);

create table categories
(
  id          bigint auto_increment
    primary key,
  name        varchar(255) null,
  description varchar(255) null
);

create table chain
(
  id                 bigint auto_increment
    primary key,
  version            int          null,
  date_created       datetime     null,
  time_created       datetime     null,
  last_updated       datetime     null,
  time_updated       datetime     null,
  name               varchar(255) null,
  symbol             varchar(255) null,
  description        varchar(255) null,
  long_description   varchar(255) null,
  icon_url           varchar(255) null,
  category           varchar(255) null,
  chain_list_icon    varchar(255) null,
  rpc_url            varchar(255) null,
  chain_id           int          null,
  block_explorer_url varchar(255) null,
  chain_address_id   bigint       null,
  constraint FK_CHAIN_ON_CHAIN_ADDRESS
    foreign key (chain_address_id) references addresses (id)
);

create table coin
(
  id           bigint auto_increment
    primary key,
  version      int          null,
  date_created datetime     null,
  time_created datetime     null,
  last_updated datetime     null,
  time_updated datetime     null,
  coin         varchar(255) null,
  native_token double       null,
  nft_token    double       null
);

create table metadata
(
  id           bigint       not null
    primary key,
  version      int          null,
  date_created datetime     null,
  time_created datetime     null,
  last_updated datetime     null,
  time_updated datetime     null,
  name         varchar(255) null,
  description  varchar(255) null,
  image        varchar(255) null,
  nft          varchar(255) null
);

create table news
(
  id          bigint auto_increment
    primary key,
  title       varchar(255) null,
  url         varchar(255) null,
  category_id bigint       null,
  constraint FK_NEWS_ON_CATEGORY
    foreign key (category_id) references categories (id)
);

create table nft
(
  id           bigint auto_increment
    primary key,
  version      int          null,
  date_created datetime     null,
  time_created datetime     null,
  last_updated datetime     null,
  time_updated datetime     null,
  name         varchar(255) null,
  amount       double       not null,
  metadata     varchar(255) null,
  nft_address  varchar(255) null,
  nft_id       bigint       null,
  constraint FK_NFT_ON_NFT
    foreign key (nft_id) references coin (id)
);

create table coin_nfts
(
  nft_address_id bigint not null,
  nfts_id        bigint not null,
  constraint uc_coin_nfts_nfts
    unique (nfts_id),
  constraint fk_nftaddstanft_on_nft
    foreign key (nfts_id) references nft (id),
  constraint fk_nftaddstanft_on_nft_address
    foreign key (nft_address_id) references coin (id)
);

create table raw_token
(
  id           bigint auto_increment
    primary key,
  version      int          null,
  date_created datetime     null,
  time_created datetime     null,
  last_updated datetime     null,
  time_updated datetime     null,
  raw_token    varchar(255) null,
  coin_id      bigint       null,
  constraint FK_RAW_TOKEN_ON_NFTADDRESS
    foreign key (coin_id) references coin (id)
);

create table roles
(
  id   bigint auto_increment
    primary key,
  name varchar(255) not null,
  constraint uc_roles_name
    unique (name)
);

create table users
(
  userid           bigint auto_increment
    primary key,
  username         varchar(255) null,
  password         varchar(255) null,
  lastname         varchar(255) null,
  firstname        varchar(255) null,
  usertype         int          null,
  email            varchar(255) not null,
  organizationcode varchar(255) null,
  cusurl           varchar(255) null,
  dashboardcode    varchar(255) null,
  isactive         int          null,
  contacttype      int          null
);

create table users_roles
(
  role_id bigint not null,
  user_id bigint not null,
  primary key (role_id, user_id),
  constraint fk_userol_on_role
    foreign key (role_id) references roles (id),
  constraint fk_userol_on_user
    foreign key (user_id) references users (userid)
);

create table weblinks
(
  id             bigint auto_increment
    primary key,
  version        int          null,
  date_created   datetime     null,
  time_created   datetime     null,
  last_updated   datetime     null,
  time_updated   datetime     null,
  url            varchar(255) null,
  host           varchar(255) null,
  htmlpage       varchar(255) null,
  downloadstatus smallint     null
);

