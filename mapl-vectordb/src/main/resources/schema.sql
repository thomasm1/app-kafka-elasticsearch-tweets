drop table if exists post_entity;
create table post_entity (
    id serial primary key,
    name text not null,
    description text not null,
);