package barreto.lab_manager.repository;

import barreto.lab_manager.model.Televisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelevisaoRepository extends JpaRepository<Televisao, String> {
}