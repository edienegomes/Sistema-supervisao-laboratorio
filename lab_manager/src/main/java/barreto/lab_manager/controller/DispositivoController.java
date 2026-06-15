package barreto.lab_manager.controller;

import barreto.lab_manager.model.Dispositivo;
import barreto.lab_manager.service.DispositivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dispositivos")
@RequiredArgsConstructor
public class DispositivoController {

    private final DispositivoService service;

    @GetMapping
    public ResponseEntity<List<Dispositivo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivo> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Dispositivo> criar(@RequestBody Dispositivo dispositivo) {
        Dispositivo novoDispositivo = service.salvar(dispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDispositivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivo> atualizar(@PathVariable String id, @RequestBody Dispositivo dispositivo) {
        return service.atualizar(id, dispositivo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}