create table authors (
   id bigint,
   name varchar(50)
);
   
alter table authors
   add constraint authors_pk
   primary key (id);
   
alter table authors
   add constraint authors_uq
   unique (name);
   
create table categories (
   id bigint,
   name varchar(50)
);
   
alter table categories
   add constraint categories_pk
   primary key (id);
   
alter table categories
   add constraint categories_uq
   unique (name);
   
create table movies (
   id bigint,
   cod_author bigint,
   cod_category bigint,
   title varchar(100),
   year int,
   language varchar(20)
);

alter table movies
   add constraint movies_pk
   primary key (id);
   
alter table movies
   add constraint movies_uq
   unique (title);
   
alter table movies
   add constraint movies_author_fk
   foreign key (cod_author) references authors(id);
   
alter table movies
   add constraint movies_category_fk
   foreign key (cod_category) references categories(id);
   
commit;
