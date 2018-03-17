CREATE SEQUENCE pacjenci_seq START 1 INCREMENT 1;

CREATE TABLE pacjenci (
  id       INT PRIMARY KEY DEFAULT naxtval('patients_seqc'),
  login    VARCHAR(20),
  password VARCHAR(100),
  imie    VARCHAR(100),
  nazwisko VARCHAR(100)
);

CREATE SEQUENCE specjalizacja_seq START 1 INCREMENT 1;

CREATE TABLE specjalizacja (
  id    INT PRIMARY KEY DEFAULT nextval('specjalizacja_seq'),
  value VARCHAR(30)
);

CREATE SEQUENCE doctors_seq START 1 INCREMENT 1;

CREATE TABLE doctors (
  id        INT PRIMARY KEY DEFAULT nextval('doctors_seq'),
  name      VARCHAR(200),
  specialization_id  INT REFERENCES specjalizacja (id)
);

CREATE SEQUENCE harmonogram_seq START 1 INCREMENT 1;

CREATE TABLE harmonogram_lekarzy (
  id       INT PRIMARY KEY DEFAULT nextval('harmonogram_seq'),
  id_lekarze INT REFERENCES lekarze (id),
  dzien_tygodnia VARCHAR(100),
  godzina TIME
#   date_visit TIMESTAMP
);

CREATE SEQUENCE rezerwacja_seq START 1 INCREMENT 1;

CREATE TABLE rezerwacja_vizyty (
  id        INT PRIMARY KEY DEFAULT nextval('rezerwacja_seq'),
  id_user   INT REFERENCES pacjenci (id),
  id_harmonogram   INT REFERENCES harmonogram_lekarzy(id),
  cancelled BOOLEAN DEFAULT FALSE
);



