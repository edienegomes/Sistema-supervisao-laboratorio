package barreto.lab_manager.service;

import barreto.lab_manager.model.Monitora;
import barreto.lab_manager.model.IdMonitora;
import barreto.lab_manager.repository.MonitoraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonitoraService {

    private final MonitoraRepository repository;

    public List<Monitora> listarTodos() {
        return repository.findAll();
    }

    public Optional<Monitora> buscarPorId(Integer idLaboratorio, Integer matricula) {
        return repository.findById(new IdMonitora(idLaboratorio, matricula));
    }

    public Monitora salvar(Monitora monitora) {
        return repository.save(monitora);
    }

    public boolean deletar(Integer idLaboratorio, Integer matricula) {
        IdMonitora id = new IdMonitora(idLaboratorio, matricula);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}