package barreto.lab_manager.repository;

import barreto.lab_manager.model.Monitora;
import barreto.lab_manager.model.IdMonitora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoraRepository extends JpaRepository<Monitora, IdMonitora> {
}