CREATE TABLE VERIFICA(
	matricula INT,
	id INT,
	
	PRIMARY KEY (matricula, id),
	
	FOREIGN KEY (matricula) REFERENCES MONITOR (matricula),
	FOREIGN KEY (id) REFERENCES DISPOSITIVO (id)
);