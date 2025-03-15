CREATE TABLE dailytech.categories
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)          NULL,
    `description` VARCHAR(255)          NULL,
    CONSTRAINT pk_categories PRIMARY KEY (id) ENGINE=InnoDB
);

CREATE TABLE dailytech.comments
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(255)          NULL,
    email   VARCHAR(255)          NULL,
    body    TEXT                  NULL,
    post_id BIGINT                NOT NULL,
    CONSTRAINT pk_comments PRIMARY KEY (id)

);

CREATE TABLE dailytech.news
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    title       VARCHAR(255)          NULL,
    url         VARCHAR(255)          NULL,
    category_id BIGINT                NULL,
    CONSTRAINT pk_news PRIMARY KEY (id)

);

CREATE TABLE dailytech.post_entity
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    did           VARCHAR(255)          NOT NULL,
    post_date     VARCHAR(255)          NULL,
    author        VARCHAR(255)          NULL,
    month_order   VARCHAR(255)          NULL,
    cat3          VARCHAR(255)          NULL,
    title         VARCHAR(255)          NOT NULL,
    post          VARCHAR(3000)         NOT NULL,
    blogcite      VARCHAR(1000)         NOT NULL,
    email         VARCHAR(255)          NULL,
    state         VARCHAR(255)          NULL,
    word_count    INT                   NULL,
    duration_goal INT                   NULL,
    category_id   BIGINT                NULL,
    CONSTRAINT pk_post_entity PRIMARY KEY (id)

);

CREATE TABLE dailytech.roles
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (id)

);

CREATE TABLE dailytech.users
(
    userid           INT AUTO_INCREMENT NOT NULL,
    username         VARCHAR(255)       NULL,
    password         VARCHAR(255)       NULL,
    lastname         VARCHAR(255)       NULL,
    firstname        VARCHAR(255)       NULL,
    usertype         INT                NULL,
    email            VARCHAR(255)       NOT NULL,
    organizationcode VARCHAR(255)       NULL,
    cusurl           VARCHAR(255)       NULL,
    dashboardcode    VARCHAR(255)       NULL,
    isactive         INT                NULL,
    contacttype      INT                NULL,
    CONSTRAINT pk_users PRIMARY KEY (userid)

);

CREATE TABLE dailytech.users_roles
(
    role_id BIGINT NOT NULL,
    user_id INT    NOT NULL,
    CONSTRAINT pk_users_roles PRIMARY KEY (role_id, user_id)

);

ALTER TABLE dailytech.post_entity
    ADD CONSTRAINT uc_8d90691f1af937cce1e76c802 UNIQUE (id ENGINE=InnoDB
        );

ALTER TABLE dailytech.comments
    ADD CONSTRAINT FK_COMMENTS_ON_POST FOREIGN KEY (post_id) REFERENCES dailytech.post_entity (id ENGINE=InnoDB
        );

ALTER TABLE dailytech.news
    ADD CONSTRAINT FK_NEWS_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES dailytech.categories (id ENGINE=InnoDB
        );

ALTER TABLE dailytech.post_entity
    ADD CONSTRAINT FK_POST_ENTITY_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES dailytech.categories (id ENGINE=InnoDB
        );

ALTER TABLE dailytech.roles
    ADD CONSTRAINT uc_roles_name UNIQUE (name ENGINE=InnoDB
        );

ALTER TABLE dailytech.users_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (role_id) REFERENCES dailytech.roles (id ENGINE=InnoDB
        );

ALTER TABLE dailytech.users_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (user_id) REFERENCES dailytech.users (userid ENGINE=InnoDB
        );