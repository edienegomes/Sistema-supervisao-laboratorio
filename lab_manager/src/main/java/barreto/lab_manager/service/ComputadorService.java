package barreto.lab_manager.service;

import barreto.lab_manager.model.Computador;
import barreto.lab_manager.repository.ComputadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComputadorService {

    private final ComputadorRepository repository;

    public List<Computador> listarTodos() {
        return repository.findAll();
    }

    public Optional<Computador> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Computador salvar(Computador computador) {
        return repository.save(computador);
    }

    public Optional<Computador> atualizar(String id, Computador dados) {
        return repository.findById(id).map(computador -> {
            computador.setNome(dados.getNome());
            computador.setStatus(dados.getStatus());
            computador.setLaboratorio(dados.getLaboratorio());
            computador.setSistemaOperacional(dados.getSistemaOperacional());
            return repository.save(computador);
        });
    }

    public boolean deletar(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}