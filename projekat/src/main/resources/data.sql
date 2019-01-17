insert into hotel (id, naziv, adresa, opis, prosecna_Ocena) values (1, 'Fontana', 'Kralja Petra I 21, Novi Sad, Srbija','Hotel ima veliko dvoriste',0);
insert into hotel (id, naziv, adresa, opis, prosecna_Ocena) values (2, 'Vojvodima', 'Sutjeska 5, Herceg Novi, Crna Gora','Idealan za letovanje',0);
insert into hotel (id, naziv, adresa, opis, prosecna_Ocena) values (3, 'Four Seasons', 'Boticelijeva 52c, Firenca, Italija','Veoma blizu autobuske stanice',0);
insert into hotel (id, naziv, adresa, opis, prosecna_Ocena) values (4, 'Beli Dvor', 'Marsala Tita 55, Sarajevo, Bosna i Hercegovina','Hotel je skoro renoviran',0);
insert into avio_kompanija (id, naziv, adresa, promotivni_opis, prosecna_Ocena) values (1, 'WizzAir', 'Nikole Tesle 2, Beograd, Srbija','Najpopularniji u Srbiji',0);
insert into rentacar (id, naziv_servisa, adresa_servisa, opis_servisa, prosecna_Ocena_servisa) values (1, 'Get Your Ride', 'Terazije 14, Beograd, Srbija','Veliki broj novih modela Fijata',0);

insert into cenovnik_usluga_hotela (id, cena, usluga, hotel_id) values (12131, 500, 'Klima',1);
insert into cenovnik_usluga_hotela (id, cena, usluga, hotel_id) values (55553, 150, 'Wi-Fi',1);
insert into cenovnik_usluga_hotela (id, cena, usluga, hotel_id) values (23123, 3000, 'Djakuzi',3);

insert into soba(id,broj_sobe,hotel_id,sprat,broj_kreveta) values (1123,1,1,2,4);
insert into soba(id,broj_sobe,hotel_id,sprat,broj_kreveta) values (1124,1,2,1,2);
insert into soba(id,broj_sobe,hotel_id,sprat,broj_kreveta) values (1125,2,1,3,3);

insert into status_sobe(id,soba_id,datum,zauzeto,cena,popust) values(332,1123,'2019-11-01',1,0,0);