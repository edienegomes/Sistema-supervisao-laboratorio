INSERT INTO monitor (matricula,primeiro_nome,sobrenome,turno)
VALUES
('200123456','Maicon','Pessoa Filho','Diurno'),
('200124487','Marília','Barbosa dos Santos','Noturno');

INSERT INTO laboratorio (id_laboratorio,capacidade,bloco)
VALUES (3,35,'bloco2');

--Tabela associativa
INSERT INTO monitora (id_laboratorio, matricula)
VALUES 
(3,'200123456'),
(3,'200124487');

--valores 
INSERT INTO dispositivo (id,nome,status,id_lab)
VALUES
('440710.000440.2025','computador','em manutencao',3),
('440710.000442.2025','computador','funcionando',3),
('440710.000454.2025','computador','funcionando',3),
('440710.000457.2025','computador','funcionando',3),
('440710.000465.2025','computador','funcionando',3),
('440710.000466.2025','computador','funcionando',3),
('440710.000475.2025','computador','funcionando',3),
('440710.000481.2025','computador','funcionando',3),
('440710.000482.2025','computador','funcionando',3),
('440710.000483.2025','computador','inativo',3),
('440000.00010.2025','projetor','funcionando',3);

--Tabela associativa
INSERT INTO verifica (matricula,id,data_verificacao)
VALUES 
('200123456','440710.000440.2025','2026-05-22'),
('200123456','440710.000442.2025','2026-05-21'),
('200124487','440710.000483.2025','2026-05-10'),
('200124487','440710.000482.2025','2026-05-12');

INSERT INTO hardware(id_hardware,nome,tipo,id_dispositivo)
VALUES
('1001','mouse','externo','440710.000440.2025'),
('1002','monitor','externo','440710.000440.2025'),
('1003','memória RAM','interno','440710.000440.2025'),

('1004','mouse','externo','440710.000442.2025'),
('1005','monitor','externo','440710.000442.2025'),
('1006','memória RAM','interno','440710.000442.2025');

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

INSERT INTO reproducao (id_dispo)
VALUES ('440000.00010.2025');

INSERT INTO projetor(id_reproducao)
VALUES('440000.00010.2025');
