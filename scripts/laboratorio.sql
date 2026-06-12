CREATE TABLE LABORATORIO(
	id_laboratorio INT PRIMARY KEY,
	capacidade INT NOT NULL,
	bloco VARCHAR(30) NOT NULL
);

insert into laboratorio (id_laboratorio,capacidade,bloco)
values
(1,40,'bloco3'),
(2,30,'bloco2'),
(3,35,'bloco2');