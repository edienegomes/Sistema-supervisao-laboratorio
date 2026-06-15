package barreto.lab_manager.controller;

import barreto.lab_manager.model.Computador;
import barreto.lab_manager.service.ComputadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/computadores")
@RequiredArgsConstructor
public class ComputadorController {

    private final ComputadorService service;

    @GetMapping
    public ResponseEntity<List<Computador>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computador> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Computador> criar(@RequestBody Computador computador) {
        Computador novoComputador = service.salvar(computador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoComputador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computador> atualizar(@PathVariable String id, @RequestBody Computador computador) {
        return service.atualizar(id, computador)
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