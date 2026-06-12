CREATE TABLE VERIFICA(
	matricula INT,
	id INT,
	funcionamento VARCHAR(30) NOT NULL,
	
	PRIMARY KEY (matricula, id),
	
	FOREIGN KEY (matricula) REFERENCES MONITOR (matricula),
	FOREIGN KEY (id) REFERENCES DISPOSITIVO (id)
);