drop table utente;
create table utente (id int auto_increment, username varchar(100),password varchar(100),nome varchar(100), cognome varchar(100), primary key(id), unique(username));
insert into utente (id,username,password,nome,cognome) values(1,'pippo','paperino','pippo','paperino');
insert into utente (id,username,password,nome,cognome) values(2,'ciccio','bello','ciccio','bello');


drop table canale;
create table canale (id_product int, id_canale int,data_inizio date, data_fine date,profit_margin int, price double, primary key(id_product,id_canale));
insert into canale (id_product,id_canale,data_inizio,data_fine,profit_margin,price) values(1112,1,20130606,null,10,35.4);
insert into canale (id_product,id_canale,data_inizio,data_fine,profit_margin,price) values(1222,2,20150402,null,23,42);

drop table fornitore;
create table fornitore (id int, nome varchar(100), primary key(id));
insert into fornitore (id, nome) values(1,'Leroy Merlyn');
insert into fornitore (id, nome) values(2,'Inditex');
insert into fornitore (id, nome) values(3,'Brico');

drop table prodotto;
create table prodotto (id int auto_increment, ean varchar(150) unique, category varchar(100), model varchar(100), manufacturer varchar(100),description varchar(2048), long_description varchar(2048),sell_price double, primary key (id));
insert into  prodotto (id, ean, category, model, manufacturer,description, long_description,sell_price) values (16,'EANPROVA 1','Categoria 1','Modello 1','Manufacturer 1','Descrizione 1', 'Descrizione lunga 1', 100);
insert into  prodotto (id, ean, category, model, manufacturer,description, long_description,sell_price) values (17,'EANPROVA 2','Categoria 1','Modello 1','Manufacturer 1','Descrizione 1', 'Descrizione lunga 1', 50);
insert into  prodotto (id, ean, category, model, manufacturer,description, long_description,sell_price) values (18,'EANPROVA 3','Categoria 1','Modello 1','Manufacturer 1','Descrizione 1', 'Descrizione lunga 1', 80);
insert into  prodotto (id, ean, category, model, manufacturer,description, long_description,sell_price) values (19,'EANPROVA 4','Categoria 1','Modello 1','Manufacturer 1','Descrizione 1', 'Descrizione lunga 1', 30);
insert into  prodotto (id, ean, category, model, manufacturer,description, long_description,sell_price) values (22,'EANPROVA 5','Categoria 1','Modello 1','Manufacturer 1','Descrizione 1', 'Descrizione lunga 1', 150);
insert into  prodotto (id, ean, category, model, manufacturer,description, long_description,sell_price) values (23,'EANPROVA 6','Categoria 1','Prova','Samsung','Descrizione 1', 'Descrizione lunga 1', 200);


drop table prodotto_fornitore;
create table prodotto_fornitore (id_prodotto int(11), id_fornitore int(11), codice_prodotto_su_fornitore varchar(255) not null, quantita double, data_inizio datetime, data_fine datetime, prezzo_acquisto int, primary key (id_prodotto, id_fornitore, data_inizio), foreign key(id_prodotto) references prodotto(id) on delete cascade on update cascade, foreign key(id_fornitore) references fornitore(id) on delete cascade on update cascade);
insert into  prodotto_fornitore (id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (16, 1,1234,1,'2018-01-01 00:00:00',null, 100);
insert into  prodotto_fornitore (id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (16, 2,123,1,'2018-01-01 00:00:00',null, 100);
insert into  prodotto_fornitore (id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (16, 3,1,1,'2018-01-01 00:00:00',null, 100);
insert into  prodotto_fornitore (id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (17, 1,4,1,'2018-01-01 00:00:00',null, 50);
insert into  prodotto_fornitore (id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (17, 2,1233,1,'2018-01-01 00:00:00',null, 50);
insert into  prodotto_fornitore (id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (17, 3,2,1,'2018-01-01 00:00:00',null, 50);
insert into  prodotto_fornitore (id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (18, 1,6,1,'2018-01-01 00:00:00',null, 80);
insert into  prodotto_fornitore(id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (18, 2,123456,1,'2018-01-01 00:00:00',null, 80);
insert into  prodotto_fornitore(id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (18, 3,3,1,'2018-01-01 00:00:00',null, 80);
insert into  prodotto_fornitore(id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (19, 1,8,1,'2018-01-01 00:00:00',null, 30);
insert into  prodotto_fornitore(id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (19, 2,11,1,'2018-01-01 00:00:00',null, 30);
insert into  prodotto_fornitore(id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (19, 3,4,1,'2018-01-01 00:00:00',null, 30);
insert into  prodotto_fornitore(id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (22, 1,22,1,'2018-01-01 00:00:00',null, 150);
insert into  prodotto_fornitore(id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (22, 2,124,1,'2018-01-01 00:00:00',null, 150);
insert into  prodotto_fornitore(id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (22, 3,5,1,'2018-01-01 00:00:00',null, 150);
insert into  prodotto_fornitore(id_prodotto, id_fornitore, codice_prodotto_su_fornitore, quantita, data_inizio, data_fine, prezzo_acquisto) values (23, 3,6,1,'2018-01-01 00:00:00',null, 200);
