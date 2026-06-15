package barreto.lab_manager.controller;

import barreto.lab_manager.model.Televisao;
import barreto.lab_manager.service.TelevisaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/televisoes")
@RequiredArgsConstructor
public class TelevisaoController {

    private final TelevisaoService service;

    @GetMapping
    public ResponseEntity<List<Televisao>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Televisao> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Televisao> criar(@RequestBody Televisao televisao) {
        Televisao novaTelevisao = service.salvar(televisao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTelevisao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Televisao> atualizar(@PathVariable String id, @RequestBody Televisao televisao) {
        return service.atualizar(id, televisao)
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