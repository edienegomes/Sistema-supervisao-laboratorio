
package barreto.lab_manager.service;

import barreto.lab_manager.model.Verifica;
import barreto.lab_manager.model.IdVerifica;
import barreto.lab_manager.repository.VerificaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerificaService {

    private final VerificaRepository repository;

    public List<Verifica> listarTodos() {
        return repository.findAll();
    }

    public Optional<Verifica> buscarPorId(Integer matricula, String idDispositivo) {
        return repository.findById(new IdVerifica(matricula, idDispositivo));
    }

    public Verifica salvar(Verifica verifica) {
        return repository.save(verifica);
    }

    public Optional<Verifica> atualizar(Integer matricula, String idDispositivo, Verifica dados) {
        IdVerifica id = new IdVerifica(matricula, idDispositivo);
        return repository.findById(id).map(verifica -> {
            verifica.setDataVerificacao(dados.getDataVerificacao());
            return repository.save(verifica);
        });
    }

    public boolean deletar(Integer matricula, String idDispositivo) {
        IdVerifica id = new IdVerifica(matricula, idDispositivo);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}