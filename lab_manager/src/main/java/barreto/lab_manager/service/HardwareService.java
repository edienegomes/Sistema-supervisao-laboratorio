package barreto.lab_manager.service;

import barreto.lab_manager.model.Hardware;
import barreto.lab_manager.repository.HardwareRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HardwareService {

    private final HardwareRepository repository;

    public List<Hardware> listarTodos() {
        return repository.findAll();
    }

    public Optional<Hardware> buscarPorId(Integer id) {
        return repository.findById(id);
    }

    public Hardware salvar(Hardware hardware) {
        return repository.save(hardware);
    }

    public Optional<Hardware> atualizar(Integer id, Hardware dados) {
        return repository.findById(id).map(hardware -> {
            hardware.setNome(dados.getNome());
            hardware.setTipo(dados.getTipo());
            hardware.setDispositivo(dados.getDispositivo());
            return repository.save(hardware);
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