package barreto.lab_manager.repository;

import barreto.lab_manager.model.Hardware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardwareRepository extends JpaRepository<Hardware, Integer> {
}
