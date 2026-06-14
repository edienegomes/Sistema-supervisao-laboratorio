--Trigger - regras automáticas no banco
CREATE OR REPLACE FUNCTION validar_status()
RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.status NOT IN
       ('funcionando', 'inativo', 'em manutencao')
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

--Bloqueia a verificação repetida no mesmo dispositivo
CREATE OR REPLACE FUNCTION fn_bloqueia_verificacao_duplicada()
RETURNS TRIGGER AS $$
BEGIN
    IF EXISTS (
        SELECT 1
        FROM verifica v
        WHERE v.matricula = NEW.matricula
          AND v.id_dispositivo = NEW.id_dispositivo
          AND DATE(v.data_verificacao) = CURRENT_DATE
    ) THEN
        RAISE EXCEPTION 'Esse dispositivo já foi verificado hoje!';
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_bloqueia_verificacao_duplicada
BEFORE INSERT ON verifica
FOR EACH ROW
EXECUTE FUNCTION fn_bloqueia_verificacao_duplicada();

--Regra de negócio, impede a exclusão do dispo em manutenção
CREATE OR REPLACE FUNCTION fn_bloqueia_delete_dispositivo()
RETURNS TRIGGER AS $$
BEGIN
    IF OLD.status = 'em manutencao' THEN
        RAISE EXCEPTION 'Dispositivo em manutenção! Não pode ser removido';
    END IF;

    RETURN OLD;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_bloqueia_delete_dispositivo
BEFORE DELETE ON dispositivo
FOR EACH ROW
EXECUTE FUNCTION fn_bloqueia_delete_dispositivo();

--Controle de turno
CREATE OR REPLACE FUNCTION validar_turno()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.turno NOT IN ('Diurno', 'Noturno') THEN
        RAISE EXCEPTION 'Turno inválido: %', NEW.turno;
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_validar_turno
BEFORE INSERT OR UPDATE ON monitor
FOR EACH ROW
EXECUTE FUNCTION validar_turno();

--Limitação de monitores
CREATE OR REPLACE FUNCTION limitar_monitores()
RETURNS TRIGGER AS $$
BEGIN
    IF (SELECT COUNT(*) FROM monitor) >= 2 THEN
        RAISE EXCEPTION 'Limite de 2 monitores atingido!';
    END IF;

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trg_limitar_monitores
BEFORE INSERT ON monitor
FOR EACH ROW
EXECUTE FUNCTION limitar_monitores();










