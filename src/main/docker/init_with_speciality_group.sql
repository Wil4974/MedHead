CREATE TABLE public.speciality (
	id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	groupname varchar(50) NOT NULL,
	name varchar(50) NOT NULL
);

insert into public.speciality  (groupname, name)
values ('Groupe de médecine générale', 'Cardiologie'),
		('Groupe de pathologie', 'Immunologie'),
		('Groupe de pathologie', 'Neuropathologie diagnostique');

CREATE TABLE public.hospital (
	id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	name varchar(50) NOT NULL,
  	latitude real NOT NULL,
  	longitude real NOT NULL,
  	available_beds int NOT NULL
);

insert into public.hospital (name, latitude, longitude, available_beds)
values ('Fred Brooks', '51.4739', '-0.0684', '2'),
		('Julia Crusher', '51.47303', '-0.01523', '0'),
        ('Beverly Bashir', '51.5031', '-0.1528', '5');

CREATE TABLE public.hospital_specialities (
  hospital_id int NOT NULL,
  speciality_id int NOT NULL,
  PRIMARY KEY (hospital_id, speciality_id),
  CONSTRAINT hospitalid FOREIGN KEY (hospital_id) REFERENCES hospital (id),
  CONSTRAINT specialityid FOREIGN KEY (speciality_id) REFERENCES speciality (id)
);

insert into public.hospital_specialities (hospital_id, speciality_id)
values (1, 1),
	    (1, 2),
		(2, 1),
		(3, 2),
		(3, 3);
