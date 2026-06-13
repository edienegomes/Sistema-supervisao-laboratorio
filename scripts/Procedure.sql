CREATE OR REPLACE FUNCTION listar_dispositivos(p_lab INT)
RETURNS TABLE (
    id VARCHAR(30),
    nome VARCHAR(100),
    status VARCHAR(30),
    id_lab INT
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT d.id, d.nome, d.status, d.id_lab
    FROM DISPOSITIVO d
    WHERE d.id_lab = p_lab;
END;
$$;


CREATE OR REPLACE FUNCTION contar_dispositivos(p_lab INT)
RETURNS INTEGER
LANGUAGE plpgsql
AS $$
DECLARE
    v_total INTEGER;
BEGIN
    SELECT COUNT(*) INTO v_total
    FROM DISPOSITIVO
    WHERE id_lab = p_lab;
    RETURN v_total;
END;
$$;

