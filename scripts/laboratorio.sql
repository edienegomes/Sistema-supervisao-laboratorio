-- CRIAR TABELA
CREATE TABLE LABORATORIO(
	id_laboratorio INT PRIMARY KEY,
	capacidade INT NOT NULL,
	bloco VARCHAR(30) NOT NULL
);

-- POPULAR TABELA
INSERT INTO LABORATORIO (id_laboratorio,capacidade,bloco)
VALUES (2, 30, 'bloco2');
