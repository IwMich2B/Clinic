CREATE SEQUENCE doctors_seq START 1 INCREMENT 1;
CREATE TABLE doctors(
id int PRIMARY key default naxtval('doctors_seq'),
name varchar (200),
last_name varchar (200),
specialization varchar (200));

CREATE SEQUENCE patients_seqc START 1 INCREMENT 1;
CREATE TABLE patients(
id int PRIMARY key default naxtval('patients_seqc'),
login varchar (20),
password varchar (100),
email varchar (100),
phone varchar (10),
PESEL varchar (11)

);

CREATE SEQUENCE visits_sql START 1 INCREMENT 1;
CREATE TABLE visits(
id int PRIMARY key defoult nextval ('visits'),
id_doctor int REFERENCES doctors(id),
id_patient int REFERENCES patients(id),
hours_visit TIMESTAMP,
cancelled boolean DEFAULT false,

);



CREATE SEQUENCE usersClinic_seq START 1 INCREMENT 1;
CREATE TABLE users(
id int PRIMARY key defoult nextval ('usersClinic'),
first_name varchar (200),
last_name varchar (200),
login varchar (20),
password varchar(100),

)