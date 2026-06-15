
package barreto.lab_manager.service;

import barreto.lab_manager.model.Projetor;
import barreto.lab_manager.repository.ProjetorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetorService {

    private final ProjetorRepository repository;

    public List<Projetor> listarTodos() {
        return repository.findAll();
    }

    public Optional<Projetor> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Projetor salvar(Projetor projetor) {
        return repository.save(projetor);
    }

    public Optional<Projetor> atualizar(String id, Projetor dados) {
        return repository.findById(id).map(projetor -> {
            projetor.setNome(dados.getNome());
            projetor.setStatus(dados.getStatus());
            projetor.setLaboratorio(dados.getLaboratorio());
            return repository.save(projetor);
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