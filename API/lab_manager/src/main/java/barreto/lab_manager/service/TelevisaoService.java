package barreto.lab_manager.service;

import barreto.lab_manager.model.Televisao;
import barreto.lab_manager.repository.TelevisaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TelevisaoService {

    private final TelevisaoRepository repository;

    public List<Televisao> listarTodos() {
        return repository.findAll();
    }

    public Optional<Televisao> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Televisao salvar(Televisao televisao) {
        return repository.save(televisao);
    }

    public Optional<Televisao> atualizar(String id, Televisao dados) {
        return repository.findById(id).map(televisao -> {
            televisao.setNome(dados.getNome());
            televisao.setStatus(dados.getStatus());
            televisao.setLaboratorio(dados.getLaboratorio());
            return repository.save(televisao);
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
