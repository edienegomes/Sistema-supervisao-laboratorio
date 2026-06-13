INSERT INTO monitor (matricula,primeiro_nome,sobrenome, turno)
VALUES
('200123435','Carlos','Miguel','Diurno'),
('200126767','Vinicius','Carnaíba','Noturno');

INSERT INTO laboratorio (id_laboratorio,capacidade,bloco)
VALUES (3,35,'bloco2');

--Tabela associativa
INSERT INTO monitora (id_laboratorio, matricula)
VALUES 
(2,'200123435'),
(2,'200126767');

--valores 
INSERT INTO dispositivo (id,nome,status,id_lab)
VALUES


--Tabela associativa
INSERT INTO verifica (matricula,id,data_verificacao)
VALUES 


INSERT INTO hardware(id_hardware,nome,tipo,id_dispositivo)
VALUES
('1001','mouse','externo','440710.000440.2025'),
('1002','monitor','externo','440710.000440.2025'),
('1003','memória RAM','interno','440710.000440.2025'),
('1001','mouse','externo','440710.000442.2025');

INSERT INTO computador (id_dispo, sistema_operacional)
VALUES
('440710.000440.2025','Windows 11'),
('440710.000442.2025','Windows 11'),
('440710.000454.2025','Windows 11'),
('440710.000457.2025','Windows 11'),
('440710.000465.2025','Windows 11'),
('440710.000466.2025','Windows 11'),
('440710.000475.2025','Windows 11'),
('440710.000481.2025','Windows 11'),
('440710.000482.2025','Windows 11'),
('440710.000483.2025','Windows 11');

INSERT INTO reproducao (Id_dispo)
('440000.00010.2025');

INSERT INTO projetor(Id_dispo)
('440000.00010.2025');
