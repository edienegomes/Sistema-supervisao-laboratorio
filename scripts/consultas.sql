--qtd de dispositivos por lab
SELECT
    l.id_laboratorio,
    l.bloco,
    COUNT(d.id) AS total_dispositivos
FROM laboratorio l
LEFT JOIN dispositivo d
    ON l.id_laboratorio = d.id_lab
GROUP BY l.id_laboratorio, l.bloco
ORDER BY total_dispositivos DESC;

--qtd de verificações realizadas por monitor
SELECT
    m.matricula,
    m.primeiro_nome,
    m.sobrenome,
    COUNT(v.id) AS total_verificacoes
FROM monitor m
LEFT JOIN verifica v
    ON m.matricula = v.matricula
GROUP BY
    m.matricula,
    m.primeiro_nome,
    m.sobrenome
ORDER BY total_verificacoes DESC;

--qtd dispo que não foram verificados
SELECT
    d.id,
    d.nome,
    d.status
FROM dispositivo d
LEFT JOIN verifica v
    ON d.id = v.id
WHERE v.id IS NULL;

--última verificação de cada dispo
SELECT
    d.id,
    d.nome,
    MAX(v.data_verificacao) AS ultima_verificacao
FROM dispositivo d
LEFT JOIN verifica v
    ON d.id = v.id
GROUP BY d.id, d.nome
ORDER BY ultima_verificacao DESC NULLS LAST;;

--dispositivos inativos por lab
SELECT
    l.id_laboratorio,
    l.bloco,
    COUNT(*) AS total_inativos
FROM laboratorio l
JOIN dispositivo d
    ON l.id_laboratorio = d.id_lab
WHERE d.status = 'inativo'
GROUP BY l.id_laboratorio, l.bloco
GROUP BY total_inativos DESC;

--histórico completo de verificações
SELECT
    m.primeiro_nome,
    m.sobrenome,
    d.nome AS dispositivo,
    v.data_verificacao
FROM verifica v
JOIN monitor m
    ON v.matricula = m.matricula
JOIN dispositivo d
    ON v.id = d.id
ORDER BY v.data_verificacao DESC;

--computadores por lab
SELECT
    l.id_laboratorio,
    l.bloco,
    d.nome,
    c.sistema_operacional
FROM laboratorio l
JOIN dispositivo d
    ON l.id_laboratorio = d.id_lab
JOIN computador c
    ON d.id = c.id_dispo
ORDER BY l.id_laboratorio;

--organização dos lab com mais dispositivos
SELECT
    l.id_laboratorio,
    l.bloco,
    COUNT(d.id) AS total
FROM laboratorio l
JOIN dispositivo d
    ON l.id_laboratorio = d.id_lab
GROUP BY l.id_laboratorio, l.bloco
ORDER BY total DESC;

--monitores e seus labs
SELECT
    m.matricula,
    m.primeiro_nome,
    m.sobrenome,
    l.id_laboratorio,
    l.bloco
FROM monitor m
JOIN monitora mo
    ON m.matricula = mo.matricula
JOIN laboratorio l
    ON mo.id_laboratorio = l.id_laboratorio;

--labs com mais computadores
SELECT
    l.id_laboratorio,
    l.bloco,
    COUNT(c.id_dispo) AS total_computadores
FROM laboratorio l
JOIN dispositivo d
    ON l.id_laboratorio = d.id_lab
JOIN computador c
    ON d.id = c.id_dispo
GROUP BY l.id_laboratorio, l.bloco
ORDER BY total_computadores DESC;
;
