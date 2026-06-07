CREATE TABLE DISPOSITIVO(
	id VARCHAR(30) PRIMARY KEY,
	nome VARCHAR(30) NOT NULL,
	status VARCHAR(30) NOT NULL,
	id_lab INT,
	
	FOREIGN KEY (id_lab) REFERENCES LABORATORIO (id_laboratorio)
);



INSERT INTO DISPOSITIVO (id,nome,status,id_lab)
VALUES
('440.702.000387.2024','computador','funcionando',1),
('440.702.000360.2024','computador','funcionando',1),
('440.702.000368.2024','computador','funcionando',1),
('440.702.000370.2024','computador','funcionando',1),
('440.702.000392.2024','computador','funcionando',1),
('440.702.000358.2024','computador','funcionando',1),
('440.702.000375.2024','computador','funcionando',1),
('440.702.000385.2024','computador','funcionando',1),
('440.702.000365.2024','computador','funcionando',1);
