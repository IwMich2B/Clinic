
set search_path = public;

CREATE SEQUENCE doctors_seq START 1 INCREMENT 1;
CREATE TABLE doctors(
  id int PRIMARY key default nextval('doctors_seq'),
  name varchar (200),
  last_name varchar (200),
  specialization_id varchar (200));

CREATE SEQUENCE patients_seqc START 1 INCREMENT 1;
CREATE TABLE patients(
  id int PRIMARY key default nextval('patients_seqc'),
  login varchar (20),
  password varchar (100),
  email varchar (100),
  phone varchar (10),
  pesel varchar (11)

);

CREATE SEQUENCE visits_sql START 1 INCREMENT 1;
CREATE TABLE visits(
  id int PRIMARY key default nextval ('visits_sql'),
  id_doctor int REFERENCES doctors(id),
  id_patient int REFERENCES patients(id),
  visit_date  TIMESTAMP,
  hours_visit CHAR (5),
  cancelled boolean DEFAULT false

);
CREATE SEQUENCE specjalizacja_seq START 1 INCREMENT 1;
CREATE TABLE specjalizacja (

  id INT PRIMARY KEY DEFAULT nextval('specjalizacja_seq'),
  value VARCHAR(30)

);

ALTER TABLE patients ADD first_name VARCHAR(200),
  ADD last_name VARCHAR(200);

