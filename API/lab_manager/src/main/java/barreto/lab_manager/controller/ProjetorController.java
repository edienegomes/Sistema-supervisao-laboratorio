package barreto.lab_manager.controller;

import barreto.lab_manager.model.Projetor;
import barreto.lab_manager.service.ProjetorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetores")
@RequiredArgsConstructor
public class ProjetorController {

    private final ProjetorService service;

    @GetMapping
    public ResponseEntity<List<Projetor>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projetor> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Projetor> criar(@RequestBody Projetor projetor) {
        Projetor novoProjetor = service.salvar(projetor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProjetor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projetor> atualizar(@PathVariable String id, @RequestBody Projetor projetor) {
        return service.atualizar(id, projetor)
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