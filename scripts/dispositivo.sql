CREATE TABLE DISPOSITIVO(
	id VARCHAR(30) PRIMARY KEY,
	nome VARCHAR(30) NOT NULL,
	status ENUM('funcionando','em manutencao','inativo') NOT NULL,
	id_lab INT,
	
	FOREIGN KEY (id_lab) REFERENCES LABORATORIO (id_laboratorio)
);