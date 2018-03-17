INSERT INTO pacjenci (login, password, imie) values('aga123', '12s3a','Aga');
INSERT INTO pacjenci (login, password, imie) values('ania123', '123ass','Ania');
INSERT INTO pacjenci (login, password, imie) values('justyna123', '123ffa','Justyna');
INSERT INTO pacjenci (login, password, imie) values('iwona546', '123fsa','Iwona');

INSERT INTO specjalizacja (value) values('Pediatra');
INSERT INTO specjalizacja (value) values('Internista');
INSERT INTO specjalizacja (value) values('Dentysta');


# INSERT INTO doctors (name, id_specjalizacja) VALUES ('Marcin Maj', (SELECT id FROM specjalizacja WHERE value='Pediatra'));
# INSERT INTO doctors (name, id_specjalizacja) VALUES ('Agnieszka Bara', (SELECT id FROM specjalizacja WHERE value='Pediatra'));
# INSERT INTO doctors (name, id_specjalizacja) VALUES ('Magdalena Sikora', (SELECT id FROM specjalizacja WHERE value='Internista'));
# INSERT INTO doctors (name, id_specjalizacja) VALUES ('Piotr Szczygiel', (SELECT id FROM specjalizacja WHERE value='Dentysta'));
# INSERT INTO doctors (name, id_specjalizacja) VALUES ('Anna Petera', (SELECT id FROM specjalizacja WHERE value='Dentysta'));
# INSERT INTO doctors (name, id_specjalizacja) VALUES ('Tomasz Marczak', (SELECT id FROM specjalizacja WHERE value='Dentysta'));

INSERT INTO doctors (name, specialization_id) VALUES ('Marcin Maj',1);
INSERT INTO doctors (name, specialization_id) VALUES ('Agnieszka Bara', 2);
INSERT INTO doctors (name, specialization_id) VALUES ('Magdalena Sikora', 3);
INSERT INTO doctors (name, specialization_id) VALUES ('Piotr Szczygiel', 1);
INSERT INTO doctors (name, specialization_id) VALUES ('Anna Petera', 2);
INSERT INTO doctors (name, specialization_id) VALUES ('Tomasz Marczak', 3);


INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '08:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '08:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '09:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '09:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '10:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '10:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '11:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '11:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '12:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '12:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'poniedzialek', '13:00'));

INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '08:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '08:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '09:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '09:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '10:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '10:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '11:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '11:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '12:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '12:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'wtorek', '13:00'));

INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '08:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '08:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '09:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '09:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '10:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '10:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '11:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '11:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '12:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '12:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '13:00'));

INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '08:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '08:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '09:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '09:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '10:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '10:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '11:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '11:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '12:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '12:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'sroda', '13:00'));

INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '08:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '08:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '09:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '09:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '10:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '10:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '11:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '11:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '12:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '12:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'czwartek', '13:00'));

INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '08:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '08:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '09:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '09:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '10:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '10:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '11:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '11:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '12:00'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '12:30'));
INSERT INTO harmonogram_lekarzy(id_lekarze, dzien_tygodnia,godzina) VALUES ((SELECT id FROM lekarze WHERE name='Marcin Maj', 'piatek', '13:00'));







