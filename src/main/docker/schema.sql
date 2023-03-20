CREATE DATABASE medhead_poc OWNER wil;

DROP TABLE IF EXISTS speciality;
CREATE TABLE public.speciality (
	id int NOT null,
	"name" varchar(50) NOT NULL,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS hospital;
CREATE TABLE public.hospital (
	id int NOT null,
	"name" varchar(50) NOT NULL,
  	latitude real NOT NULL,
  	longitude real NOT NULL,
  	available_beds int NOT NULL,
  	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS hospital_specialities;
CREATE TABLE hospital_specialities (
  hospital_id int NOT NULL,
  speciality_id int NOT NULL,
  PRIMARY KEY (hospital_id, speciality_id),
  CONSTRAINT hospitalid FOREIGN KEY (hospital_id) REFERENCES hospital (id) ON DELETE CASCADE ON UPDATE cascade,
  CONSTRAINT specialityid FOREIGN KEY (speciality_id) REFERENCES speciality (id) ON DELETE CASCADE ON UPDATE CASCADE
)
