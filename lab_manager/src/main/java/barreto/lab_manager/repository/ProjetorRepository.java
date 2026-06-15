package barreto.lab_manager.repository;

import barreto.lab_manager.model.Projetor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetorRepository extends JpaRepository<Projetor, String> {
}