--Criação de tabelas
CREATE TABLE MONITOR(
	matricula INT PRIMARY KEY,
	primeiro_nome VARCHAR(30) NOT NULL,
	sobrenome VARCHAR(30) NOT NULL,
	turno VARCHAR(30) NOT NULL
);

CREATE TABLE LABORATORIO(
	id_laboratorio INT PRIMARY KEY,
	capacidade INT NOT NULL,
	bloco VARCHAR(30) NOT NULL
);

CREATE TABLE MONITORA(
	id_laboratorio INT,
	matricula INT,
	
	PRIMARY KEY (id_laboratorio, matricula),
	
	FOREIGN KEY (id_laboratorio) REFERENCES LABORATORIO (id_laboratorio),
	FOREIGN KEY (matricula) REFERENCES MONITOR (matricula)
);

--Criando tabela tipo para ENUM
CREATE TYPE status_dispositivo AS ENUM(
	'funcionando',
	'em manutencao',
	'inativo'
);

CREATE TABLE DISPOSITIVO(
	id VARCHAR(30) PRIMARY KEY,
	nome VARCHAR(30) NOT NULL,
	status status_dispositivo NOT NULL,
	id_lab INT,
	
	FOREIGN KEY (id_lab) REFERENCES LABORATORIO (id_laboratorio)
);

CREATE TABLE VERIFICA(
	matricula INT,
	id VARCHAR,
	data_verificacao DATE NOT NULL,
	
	PRIMARY KEY (matricula, id),
	
	FOREIGN KEY (matricula) REFERENCES MONITOR (matricula),
	FOREIGN KEY (id) REFERENCES DISPOSITIVO (id)
);

CREATE TABLE HARDWARE(
	id_hardware INT PRIMARY KEY,
	nome VARCHAR(30) NOT NULL,
	tipo VARCHAR(30) NOT NULL,
	id_dispositivo VARCHAR,
	
	FOREIGN KEY (id_dispositivo) REFERENCES DISPOSITIVO (id)
);

CREATE TABLE COMPUTADOR(
	id_dispo VARCHAR(30) PRIMARY KEY,
	sistema_operacional VARCHAR(30),
	
	FOREIGN KEY (id_dispo) REFERENCES DISPOSITIVO (id)
);

CREATE TABLE REPRODUCAO(
	id_dispo VARCHAR primary key,
	
	FOREIGN KEY (id_dispo) REFERENCES DISPOSITIVO (id)
);

CREATE TABLE TELEVISAO(
	id_reproducao VARCHAR PRIMARY KEY,
	
	FOREIGN KEY (id_reproducao) REFERENCES REPRODUCAO (id_dispo)
);

CREATE TABLE PROJETOR(
	id_reproducao VARCHAR PRIMARY KEY,
	
	FOREIGN KEY (id_reproducao) REFERENCES REPRODUCAO (id_dispo)
);
