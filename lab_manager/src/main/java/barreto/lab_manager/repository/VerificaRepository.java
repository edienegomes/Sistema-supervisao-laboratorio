package barreto.lab_manager.repository;

import barreto.lab_manager.model.Verifica;
import barreto.lab_manager.model.IdVerifica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificaRepository extends JpaRepository<Verifica, IdVerifica> {
}