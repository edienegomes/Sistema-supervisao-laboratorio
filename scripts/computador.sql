-- CRIAR TABELA
CREATE TABLE COMPUTADOR(
	id_dispo VARCHAR(30) PRIMARY KEY,
	sistema_operacional VARCHAR(30),
	
	FOREIGN KEY (id_dispo) REFERENCES DISPOSITIVO (id)
);

-- POPULAR TABELA
INSERT INTO COMPUTADOR (id_dispo,sistema_operacional)
VALUES
('000007.2021','Windows 11'),
('000008.2021','Windows 11'),
('000009.2021','Windows 11'),
('000011.2021','Windows 11'),
('000014.2021','Windows 11'),
('000022.2021','Windows 11'),
('000024.2021','Windows 11'),
('000025.2021','Windows 11'),
('000028.2021','Windows 11'),
('000029.2021','Windows 11');
