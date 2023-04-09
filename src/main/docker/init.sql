CREATE TABLE public.speciality (
	id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	name varchar(50) NOT NULL
);

insert into public.speciality  (name)
values ('Cardiologie'),
		('Immunologie'),
		('Neuropathologie diagnostique');

CREATE TABLE public.hospital (
	id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	name varchar(50) NOT NULL,
  	latitude real NOT NULL,
  	longitude real NOT NULL,
  	availableBeds int NOT NULL
);

CREATE TABLE public.reservation (
	id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	hospitalName varchar(50) NOT NULL
);

insert into public.hospital (name, latitude, longitude, availableBeds)
values ('Fred Brooks', '51.4739', '-0.0684', '2'),
		('Julia Crusher', '51.47303', '-0.01523', '0'),
        ('Beverly Bashir', '51.5031', '-0.1528', '5');

CREATE TABLE public.hospitalSpecialities (
  hospitalId int NOT NULL,
  specialityId int NOT NULL,
  PRIMARY KEY (hospitalId, specialityId),
  CONSTRAINT hospitalid FOREIGN KEY (hospitalId) REFERENCES hospital (id),
  CONSTRAINT specialityid FOREIGN KEY (specialityId) REFERENCES speciality (id)
);

insert into public.hospitalSpecialities (hospitalId, specialityId)
values (1, 1),
	    (1, 2),
		(2, 1),
		(3, 2),
		(3, 3);
