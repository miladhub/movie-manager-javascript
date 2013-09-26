insert into authors(id,name) values (1, 'ridley scott');
insert into categories(id,name) values (1, 'science fiction');
insert into movies(id,cod_author,cod_category,title,year,language) values (1,1,1,'a scanner darkly',1982,'english');
commit;
