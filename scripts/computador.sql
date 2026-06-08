CREATE TABLE COMPUTADOR(
	id_dispo INT PRIMARY KEY,
	sistema_operacional VARCHAR(30),
	
	FOREIGN KEY (id_dispo) REFERENCES DISPOSITIVO (id)
);

INSERT INTO computador (id_dispo,sistema_operacional)
values
('440.702.000387.2024','Windows 11',),
('440.702.000360.2024','Windows 11'),
('440.702.000368.2024','Windows 11'),
('440.702.000370.2024','Windows 11'),
('440.702.000392.2024','Windows 11'),
('440.702.000358.2024','Windows 11'),
('440.702.000375.2024','Windows 11'),
('440.702.000385.2024','Windows 11'),
('440.702.000365.2024','Windows 11');

