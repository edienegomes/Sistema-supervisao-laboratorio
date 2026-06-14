INSERT INTO monitor (matricula,primeiro_nome,sobrenome,turno)
VALUES
('200123456','Maicon','Pessoa Filho','Diurno'),
('200124487','Marília','Barbosa dos Santos','Noturno');

INSERT INTO laboratorio (id_laboratorio,capacidade,bloco)
VALUES 
--Adicionar o outro lab
(1,40,'bloco3'),
(2,30,'bloco2'),
(3,35,'bloco2');

--Tabela associativa
INSERT INTO monitora (id_laboratorio, matricula)
VALUES
(1,'200123456'),
(2,'200123456'),
(3,'200123456'),
(1,'200124487'),
(2,'200124487'),
(3,'200124487');

--valores 
INSERT INTO dispositivo (id,nome,status,id_lab)
VALUES
--Lab Windows
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
('440000.00010.2025','projetor','funcionando',3),
--Lab Windows L.
('000007.2021', 'computador', 'funcionando',2),
('000008.2021', 'computador', 'funcionando',2),
('000009.2021', 'computador', 'funcionando',2),
('000011.2021', 'computador', 'funcionando',2),
('000014.2021', 'computador', 'funcionando',2),
('000022.2021', 'computador', 'funcionando',2),
('000024.2021', 'computador', 'funcionando',2),
('000025.2021', 'computador', 'funcionando',2),
('000028.2021', 'computador', 'funcionando',2),
('000029.2021', 'computador', 'funcionando',2),
('440000.00012.2025','projetor','funcionando',2),
--Lab Windows N.
('440.702.000387.2024','computador','funcionando',1),
('440.702.000360.2024','computador','funcionando',1),
('440.702.000368.2024','computador','funcionando',1),
('440.702.000370.2024','computador','funcionando',1),
('440.702.000392.2024','computador','funcionando',1),
('440.702.000358.2024','computador','funcionando',1),
('440.702.000375.2024','computador','funcionando',1),
('440.702.000385.2024','computador','funcionando',1),
('440.702.000365.2024','computador','funcionando',1),
('440000.00112.2025','televisao','funcionando',1);

--Tabela associativa
INSERT INTO verifica (matricula,id,data_verificacao)
VALUES
--Lab Windows
('200123456','440710.000440.2025','2026-05-22'),
('200123456','440710.000442.2025','2026-05-21'),
('200124487','440710.000483.2025','2026-05-10'),
('200124487','440710.000482.2025','2026-05-12'),
--Lab Windows L.
('200123456','000007.2021','2026-05-22'),
('200124487','000008.2021','2026-05-21'),
('200123456','000025.2021','2026-05-10'),
('200124487','000029.2021','2026-05-12'),
--Lab Windows N.
('200123456','440.702.000387.2024','2026-05-22'),
('200124487','440.702.000368.2024','2026-05-21'),
('200123456','440.702.000358.2024','2026-05-10'),
('200124487','440.702.000385.2024','2026-05-12');

INSERT INTO hardware(id_hardware,nome,tipo,id_dispositivo)
VALUES
('1001','mouse','externo','440710.000440.2025'),
('1002','monitor','externo','440710.000440.2025'),
('1003','memória RAM','interno','440710.000440.2025');

INSERT INTO computador (id_dispo, sistema_operacional)
VALUES
--Lab Windows
('440710.000440.2025','Windows 11'),
('440710.000442.2025','Windows 11'),
('440710.000454.2025','Windows 11'),
('440710.000457.2025','Windows 11'),
('440710.000465.2025','Windows 11'),
('440710.000466.2025','Windows 11'),
('440710.000475.2025','Windows 11'),
('440710.000481.2025','Windows 11'),
('440710.000482.2025','Windows 11'),
('440710.000483.2025','Windows 11'),
--Lab Windows L.
('000007.2021','Windows 11'),
('000008.2021','Windows 11'),
('000009.2021','Windows 11'),
('000011.2021','Windows 11'),
('000014.2021','Windows 11'),
('000022.2021','Windows 11'),
('000024.2021','Windows 11'),
('000025.2021','Windows 11'),
('000028.2021','Windows 11'),
('000029.2021','Windows 11'),
--Lab Windows N.
('440.702.000387.2024','Windows 11'),
('440.702.000360.2024','Windows 11'),
('440.702.000368.2024','Windows 11'),
('440.702.000370.2024','Windows 11'),
('440.702.000392.2024','Windows 11'),
('440.702.000358.2024','Windows 11'),
('440.702.000375.2024','Windows 11'),
('440.702.000385.2024','Windows 11'),
('440.702.000365.2024','Windows 11');

INSERT INTO reproducao (id_dispo)
VALUES
--Lab Windows
('440000.00010.2025'),
--Lab Windows L.
('440000.00012.2025'),
--Lab Windows N.
('440000.00112.2025');

INSERT INTO projetor(id_reproducao)
VALUES
--Lab Windows
('440000.00010.2025'),
--Lab Windows L.
('440000.00012.2025');

INSERT INTO televisao(id_reproducao)
VALUES
--Lab Windows N.
('440000.00112.2025');