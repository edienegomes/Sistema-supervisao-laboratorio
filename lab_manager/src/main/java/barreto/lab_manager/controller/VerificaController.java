package barreto.lab_manager.controller;

import barreto.lab_manager.model.Verifica;
import barreto.lab_manager.service.VerificaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/verificacoes")
@RequiredArgsConstructor
public class VerificaController {

    private final VerificaService service;

    @GetMapping
    public ResponseEntity<List<Verifica>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{matricula}/{idDispositivo}")
    public ResponseEntity<Verifica> buscarPorId(@PathVariable Integer matricula, @PathVariable String idDispositivo) {
        return service.buscarPorId(matricula, idDispositivo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Verifica> criar(@RequestBody Verifica verifica) {
        Verifica novaVerificacao = service.salvar(verifica);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaVerificacao);
    }

    @PutMapping("/{matricula}/{idDispositivo}")
    public ResponseEntity<Verifica> atualizar(@PathVariable Integer matricula, @PathVariable String idDispositivo, @RequestBody Verifica verifica) {
        return service.atualizar(matricula, idDispositivo, verifica)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{matricula}/{idDispositivo}")
    public ResponseEntity<Void> deletar(@PathVariable Integer matricula, @PathVariable String idDispositivo) {
        if (service.deletar(matricula, idDispositivo)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}