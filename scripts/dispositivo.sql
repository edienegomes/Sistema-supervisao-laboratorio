-- CRIAR TABELA
CREATE TABLE DISPOSITIVO(
	id VARCHAR(30) PRIMARY KEY,
	nome VARCHAR(30) NOT NULL,
	status VARCHAR(30) NOT NULL,
	id_lab INT,
	
	FOREIGN KEY (id_lab) REFERENCES LABORATORIO (id_laboratorio)
);

-- POPULAR TABELA
INSERT INTO DISPOSITIVO (id, nome, status, id_lab)
VALUES 
('000007.2021', 'computador', 'funcionando', 2),
('000008.2021', 'computador', 'funcionando', 2),
('000009.2021', 'computador', 'funcionando', 2),
('000011.2021', 'computador', 'funcionando', 2),
('000014.2021', 'computador', 'funcionando', 2),
('000022.2021', 'computador', 'funcionando', 2),
('000024.2021', 'computador', 'funcionando', 2),
('000025.2021', 'computador', 'funcionando', 2),
('000028.2021', 'computador', 'funcionando', 2),
('000029.2021', 'computador', 'funcionando', 2);
