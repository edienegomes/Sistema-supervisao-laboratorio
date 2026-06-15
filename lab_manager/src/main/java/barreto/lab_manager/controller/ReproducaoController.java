package barreto.lab_manager.controller;

import barreto.lab_manager.model.Reproducao;
import barreto.lab_manager.service.ReproducaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reproducoes")
@RequiredArgsConstructor
public class ReproducaoController {

    private final ReproducaoService service;

    @GetMapping
    public ResponseEntity<List<Reproducao>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reproducao> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reproducao> criar(@RequestBody Reproducao reproducao) {
        Reproducao novaReproducao = service.salvar(reproducao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaReproducao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reproducao> atualizar(@PathVariable String id, @RequestBody Reproducao reproducao) {
        return service.atualizar(id, reproducao)
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