package barreto.lab_manager.service;

import barreto.lab_manager.model.Monitor;
import barreto.lab_manager.repository.MonitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MonitorService {

    private final MonitorRepository repository;

    public List<Monitor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Monitor> buscarPorId(Integer matricula) {
        return repository.findById(matricula);
    }

    public Monitor salvar(Monitor monitor) {
        return repository.save(monitor);
    }

    public Optional<Monitor> atualizar(Integer matricula, Monitor dados) {
        return repository.findById(matricula).map(monitor -> {
            monitor.setNome(dados.getNome());
            monitor.setTurno(dados.getTurno());
            return repository.save(monitor);
        });
    }

    public boolean deletar(Integer matricula) {
        if (repository.existsById(matricula)) {
            repository.deleteById(matricula);
            return true;
        }
        return false;
    }
}