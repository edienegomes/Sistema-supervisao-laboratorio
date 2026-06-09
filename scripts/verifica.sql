CREATE TABLE VERIFICA(
	matricula INT,
	id VARCHAR(30),
	funcionamento VARCHAR(30) NOT NULL,
	
	PRIMARY KEY (matricula, id),
	
	FOREIGN KEY (matricula) REFERENCES MONITOR (matricula),
	FOREIGN KEY (id) REFERENCES DISPOSITIVO (id)
);
