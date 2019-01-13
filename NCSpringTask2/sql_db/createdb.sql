create database ncspringtask1
with owner postgres;

create table books
(
  id        serial      not null
    constraint books_pkey
    primary key,
  name      varchar(80) not null,
  warehouse varchar(80) not null,
  count     integer,
  price     integer
);

alter table books
  owner to postgres;

create unique index books_id_uindex
  on books (id);

create table purchaser
(
  id             serial      not null
    constraint purchaser_pkey
    primary key,
  last_name      varchar(80) not null,
  residence_area varchar(80) not null,
  discount       integer
);

alter table purchaser
  owner to postgres;

create unique index purchaser_id_uindex
  on purchaser (id);

create table shop
(
  id   serial      not null
    constraint shop_pkey
    primary key,
  name varchar(80) not null,
  area varchar(80) not null,
  fee  integer
);

alter table shop
  owner to postgres;

create unique index shop_id_uindex
  on shop (id);

create table purchase
(
  id        serial    not null
    constraint purchase_pkey
    primary key,
  date      timestamp not null,
  seller    integer
    constraint purchase_shop_id_fk
    references shop,
  purchaser integer
    constraint purchase_purchaser_id_fk
    references purchaser,
  book      integer
    constraint purchase_books_id_fk
    references books,
  cnt       integer,
  summa     integer
);

alter table purchase
  owner to postgres;

create unique index purchase_id_uindex
  on purchase (id);
