INSERT INTO specjalizacja (value) values('Pediatra');
INSERT INTO specjalizacja (value) values('Internista');
INSERT INTO specjalizacja (value) values('Stomatolog');
INSERT INTO specjalizacja (value) values('Ginekolog');

INSERT INTO doctors(name,last_name,specialization_id)values('Marcin','Maj',(select id from specjalizacja where value ='Pediatra'));
INSERT INTO doctors(name,last_name,specialization_id)values('Agnieszka','Bara',(select id from specjalizacja where value ='Pediatra'));
INSERT INTO doctors(name,last_name,specialization_id)values('Magdalena','Sikora',(select id from specjalizacja where value ='Internista'));
INSERT INTO doctors(name,last_name,specialization_id)values('Piotr','Szczygiel',(select id from specjalizacja where value ='Ginekolog'));
INSERT INTO doctors(name,last_name,specialization_id)values('Anna','Petera',(select id from specjalizacja where value ='Stomatolog'));
INSERT INTO doctors(name,last_name,specialization_id)values('Tomasz','Marczak',(select id from specjalizacja where value ='Internista'));

INSERT INTO patients(login, password, email, phone, pesel, first_name, last_name)
VALUES ('hk1', 'BHQGtN7l', 'hanna@wp.pl', '997', '01234567890', 'Hanna', 'Kowalska');
INSERT INTO patients(login, password, email, phone, pesel, first_name, last_name)
VALUES ('tuptus', 'uRuUkb0k', 'niejadek@co.uk', '998-001234', '01234567891', 'Tuptuś', 'Niejadek');
INSERT INTO patients(login, password, email, phone, pesel, first_name, last_name)
VALUES ('cwirek', '3k9JpQ2g', 'cwirek@ldz.pl', '0-700-dwam', '01983019890', 'Jan', 'Ptaszyna');

INSERT INTO public.visits(id_doctor, id_patient, visit_date, hours_visit)
VALUES ((select id from doctors where last_name ='Petera'), (select id from patients where login='hk1'), '2020-02-03','08:15');
INSERT INTO public.visits(id_doctor, id_patient, visit_date, hours_visit)
VALUES ((select id from doctors where last_name ='Maj'), (select id from patients where login='tuptus'), '2020-02-21','09:20');
INSERT INTO public.visits(id_doctor, id_patient, visit_date, hours_visit)
VALUES ((select id from doctors where last_name ='Sikora'), (select id from patients where login='cwirek'), '2020-02-10','12:00');
INSERT INTO public.visits(id_doctor, id_patient, visit_date, hours_visit)
VALUES ((select id from doctors where last_name ='Petera'), (select id from patients where login='cwirek'), '2020-02-03','09:10');
