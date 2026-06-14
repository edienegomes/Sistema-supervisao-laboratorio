CREATE OR REPLACE FUNCTION listar_dispositivos(p_lab INT)
RETURNS TABLE (
    id VARCHAR(30),
    nome VARCHAR(100),
    status status_dispositivo,
    id_lab INT
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT d.id, d.nome, d.status, d.id_lab
    FROM dispositivo d
    WHERE d.id_lab = p_lab;
END;
$$;

CREATE OR REPLACE FUNCTION contar_dispositivos(p_lab INT)
RETURNS INTEGER
LANGUAGE plpgsql
AS $$
DECLARE
    total INTEGER;
BEGIN
    SELECT COUNT(*) INTO total
    FROM dispositivo
    WHERE id_lab = p_lab;
    RETURN total;

END;
$$;

CREATE OR REPLACE FUNCTION listar_por_status(p_status status_dispositivos)
RETURNS TABLE (
    id VARCHAR(30),
    nome VARCHAR(30),
    status status_dispositivo,
    id_lab INT
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT d.id, d.nome, d.status, d.id_lab
    FROM dispositivo d
    WHERE d.status = p_status;
END;
$$;

CREATE OR REPLACE FUNCTION historico_monitor(p_matricula INT)
RETURNS TABLE (
    matricula INT,
    id_dispositivo VARCHAR(30),
    data_verificacao DATE
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT v.matricula, v.id, v.data_verificacao
    FROM verifica v
    WHERE v.matricula = p_matricula
    ORDER BY v.data_verificacao DESC;
END;
$$;

CREATE OR REPLACE FUNCTION contar_verificacoes_dispositivo(p_id VARCHAR)
RETURNS INTEGER
LANGUAGE plpgsql
AS $$
DECLARE
    total INTEGER;
BEGIN
    SELECT COUNT(*) INTO total
    FROM verifica
    WHERE id = p_id;

    RETURN total;
END;
$$;

CREATE OR REPLACE FUNCTION dispositivo_existe(p_id VARCHAR)
RETURNS BOOLEAN
LANGUAGE plpgsql
AS $$
DECLARE
    existe BOOLEAN;
BEGIN
    SELECT EXISTS (
        SELECT 1 FROM dispositivo WHERE id = p_id
    ) INTO existe;

    RETURN existe;
END;
$$;

CREATE OR REPLACE FUNCTION resumo_sistema()
RETURNS TABLE (
    total_monitores INT,
    total_dispositivos INT,
    total_verificacoes INT
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT
        (SELECT COUNT(*):: INT FROM monitor),
        (SELECT COUNT(*):: INT FROM dispositivo),
        (SELECT COUNT(*):: INT FROM verifica);
END;
$$;












