
insert into hotel (id, naziv, adresa, opis, prosecna_ocena) values (1, 'Fontana', 'Kralja Petra I 21, Novi Sad, Srbija','Hotel ima veliko dvoriste',0);
insert into hotel (id, naziv, adresa, opis, prosecna_ocena) values (2, 'Vojvodina', 'Sutjeska 12, Herceg Novi, Crna Gora','Hotel je veoma popularan leti',0);
insert into hotel (id, naziv, adresa, opis, prosecna_Ocena) values (3, 'Four Seasons', 'Boticelijeva 52c, Firenca, Italija','Veoma blizu autobuske stanice',0);
insert into hotel (id, naziv, adresa, opis, prosecna_Ocena) values (4, 'Beli Dvor', 'Marsala Tita 55, Sarajevo, Bosna i Hercegovina','Hotel je skoro renoviran',0);
insert into avio_kompanija (id, naziv, adresa, promotivni_opis, prosecna_Ocena) values (1, 'WizzAir', 'Nikole Tesle 2, Beograd, Srbija','Najpopularniji u Srbiji',0);
insert into rentacar (id, naziv_servisa, adresa_servisa, opis_servisa, prosecna_Ocena_servisa) values (1, 'Get Your Ride', 'Terazije 14, Beograd, Srbija','Veliki broj novih modela Fijata',0);
insert into cenovnik_usluga_hotela (id, cena, usluga, hotel_id) values (12131, 500, 'Klima',1);
insert into cenovnik_usluga_hotela (id, cena, usluga, hotel_id) values (55553, 150, 'Wi-Fi',1);
insert into cenovnik_usluga_hotela (id, cena, usluga, hotel_id) values (23123, 3000, 'Djakuzi',3);
insert into soba(id,broj_sobe,hotel_id,sprat,broj_kreveta) values (1123,1,1,2,4);
insert into status_sobe(id,soba_id,datum,zauzeto,cena,popust) values(332,1123,'2019-11-01',1,0,0);
insert into soba(id,broj_sobe,hotel_id,sprat,broj_kreveta) values (1124,1,2,1,2);
insert into soba(id,broj_sobe,hotel_id,sprat,broj_kreveta) values (1125,2,1,3,3);
INSERT INTO korisnik (id, username, password, ime, prezime, email, enabled, last_password_reset_date,verifikovan) VALUES (1, 'user', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Marko', 'Markovic', 'user@example.com', true, '2017-10-01 21:58:58',true);
INSERT INTO korisnik (id, username, password, ime, prezime, email, enabled, last_password_reset_date,verifikovan) VALUES (2, 'admin', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', 'Nikola', 'Nikolic', 'admin@example.com', true, '2017-10-01 18:57:58',true);

INSERT INTO AUTHORITY (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO AUTHORITY (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (1, 1);
INSERT INTO USER_AUTHORITY (user_id, authority_id) VALUES (2, 2);

