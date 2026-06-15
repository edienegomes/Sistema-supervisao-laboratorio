package barreto.lab_manager.service;

import barreto.lab_manager.model.Dispositivo;
import barreto.lab_manager.repository.DispositivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DispositivoService {

    private final DispositivoRepository repository;

    public List<Dispositivo> listarTodos() {
        return repository.findAll();
    }

    public Optional<Dispositivo> buscarPorId(String id) {
        return repository.findById(id);
    }

    public Dispositivo salvar(Dispositivo dispositivo) {
        return repository.save(dispositivo);
    }

    public Optional<Dispositivo> atualizar(String id, Dispositivo dados) {
        return repository.findById(id).map(dispositivo -> {
            dispositivo.setNome(dados.getNome());
            dispositivo.setStatus(dados.getStatus());
            dispositivo.setLaboratorio(dados.getLaboratorio());
            return repository.save(dispositivo);
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