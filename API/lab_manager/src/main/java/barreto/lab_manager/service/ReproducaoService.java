package barreto.lab_manager.service;

import barreto.lab_manager.model.Reproducao;
import barreto.lab_manager.repository.ReproducaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReproducaoService {

    private final ReproducaoRepository repository;

    public List<Reproducao> listarTodos() {
        return repository.findAll();
    }

    public Optional<Reproducao> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Reproducao salvar(Reproducao reproducao) {
        return repository.save(reproducao);
    }

    public Optional<Reproducao> atualizar(String id, Reproducao dados) {
        return repository.findById(id).map(reproducao -> {
            reproducao.setNome(dados.getNome());
            reproducao.setStatus(dados.getStatus());
            reproducao.setLaboratorio(dados.getLaboratorio());
            return repository.save(reproducao);
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