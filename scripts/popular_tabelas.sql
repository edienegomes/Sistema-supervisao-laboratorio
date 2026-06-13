INSERT INTO monitor (matricula,primeiro_nome,sobrenome, turno)
VALUES
('200123435','Carlos','Melo','Diurno'),
('200126767','Vinicius','Carnaíba','Noturno');

INSERT INTO LABORATORIO (id_laboratorio,capacidade,bloco)
VALUES (2, 30, 'bloco2');

--Tabela associativa
INSERT INTO monitora (id_laboratorio, matricula)
VALUES 
(2,'200123435'),
(2,'200126767');

--valores 
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


--Tabela associativa
INSERT INTO verifica (matricula,id,data_verificacao)
VALUES 


INSERT INTO hardware(id_hardware,nome,tipo,id_dispositivo)
VALUES
('1001','mouse','externo','440710.000440.2025'),
('1002','monitor','externo','440710.000440.2025'),
('1003','memória RAM','interno','440710.000440.2025'),
('1001','mouse','externo','440710.000442.2025');

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

INSERT INTO reproducao (Id_dispo)
('440000.00010.2025');

INSERT INTO projetor(Id_dispo)
('440000.00010.2025');
