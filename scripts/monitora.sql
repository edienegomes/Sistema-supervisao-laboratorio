CREATE TABLE MONITORA(
	id_laboratorio INT,
	matricula INT,
	PRIMARY KEY (id_laboratorio, matricula),
	FOREIGN KEY (id_laboratorio) REFERENCES LABORATORIO (id_laboratorio),
	FOREIGN KEY (matricula) REFERENCES MONITOR (matricula)
);
