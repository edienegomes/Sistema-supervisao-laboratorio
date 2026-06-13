CREATE VIEW disp_defeituosos AS
SELECT
    id,
    nome,
    status,
    id_lab
FROM DISPOSITIVO
WHERE status = 'Indisponível';


CREATE VIEW view_for_lab AS
SELECT
    l.id_laboratorio,
    l.bloco,
    d.id,
    d.nome,
    c.sistema_operacional
FROM LABORATORIO l
JOIN DISPOSITIVO d
    ON l.id_laboratorio = d.id_lab
JOIN COMPUTADOR c
    ON d.id = c.id_dispo;

CREATE VIEW view_monitores AS
SELECT
    m.matricula,
    m.primeiro_nome,
    m.sobrenome,
    l.id_laboratorio,
    l.bloco
FROM MONITOR m
JOIN MONITORA mo
    ON m.matricula = mo.matricula
JOIN LABORATORIO l
    ON mo.id_laboratorio = l.id_laboratorio;