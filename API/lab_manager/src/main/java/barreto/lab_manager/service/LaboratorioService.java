package barreto.lab_manager.service;

import barreto.lab_manager.model.Laboratorio;
import barreto.lab_manager.repository.LaboratorioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LaboratorioService {

    private final LaboratorioRepository repository;

    public List<Laboratorio> listarTodos() {
        return repository.findAll();
    }

    public Optional<Laboratorio> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Laboratorio salvar(Laboratorio laboratorio) {
        return repository.save(laboratorio);
    }

    public Optional<Laboratorio> atualizar(Integer id, Laboratorio dados) {
        return repository.findById(id).map(lab -> {
            lab.setCapacidade(dados.getCapacidade());
            lab.setBloco(dados.getBloco());
            return repository.save(lab);
        });
    }

    public boolean deletar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}