INSERT INTO doctors(first_name,last_name,specialization)values('Marcin','Maj','Pediatra');
INSERT INTO doctors(first_name,last_name,specialization)values ('Agnieszka','Bara','Pediatra');
INSERT INTO doctors(first_name,last_name,specialization)values ('Magdalena','Sikora', 'Internista');
INSERT INTO doctors(first_name,last_name,specialization) values ('Piotr','Szczygiel','Ginekolog');
INSERT INTO doctors(first_name,last_name,specialization)values('Anna','Petera','Stomatolog');
INSERT INTO doctors(first_name,last_name,specialization)values ('Tomasz','Marczak','Internista');



INSERT INTO visits(id_doctor,id_patient,hours_visit)values((select id from doctors where value ='Pediatra , Maj'),(select id from patients where value='PESEL'),current_timestamp );
INSERT INTO visits(id_doctor,id_patient,hours_visit)values((select id from doctors where value ='Pediatra , Bara'),(select id from patients where value='PESEL'),current_timestamp);
INSERT INTO visits(id_doctor,id_patient,hours_visit)values((select id from doctors where value ='Internista , Sikora'),(select id from patients where value='PESEL'),current_timestamp);
INSERT INTO visits(id_doctor,id_patient,hours_visit)values((select id from doctors where value ='Internista , Marczak'),(select id from patients where value='PESEL'),current_timestamp);
INSERT INTO visits(id_doctor,id_patient,hours_visit)values((select id from doctors where value ='Ginekolog'),(select id from patients where value='PESEL'),current_timestamp);
INSERT INTO visits(id_doctor,id_patient,hours_visit)values((select id from doctors where value ='Stomatolog'),(select id from patients where value='PESEL'),current_timestamp);
