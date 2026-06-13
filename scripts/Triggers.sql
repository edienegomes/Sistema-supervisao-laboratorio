CREATE OR REPLACE FUNCTION validar_status()
RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.status NOT IN
       ('Disponível', 'Indisponível', 'Em Manutenção')
    THEN
        RAISE EXCEPTION 'Status inválido: %', NEW.status;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_validar_status
BEFORE INSERT OR UPDATE ON DISPOSITIVO
FOR EACH ROW
EXECUTE FUNCTION validar_status();


