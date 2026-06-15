package barreto.lab_manager.controller;

import barreto.lab_manager.model.Monitor;
import barreto.lab_manager.service.MonitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitores")
@RequiredArgsConstructor
public class MonitorController {

    private final MonitorService service;

    @GetMapping
    public ResponseEntity<List<Monitor>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Monitor> buscarPorId(@PathVariable Integer matricula) {
        return service.buscarPorId(matricula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Monitor> criar(@RequestBody Monitor monitor) {
        Monitor novoMonitor = service.salvar(monitor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoMonitor);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Monitor> atualizar(@PathVariable Integer matricula, @RequestBody Monitor monitor) {
        return service.atualizar(matricula, monitor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deletar(@PathVariable Integer matricula) {
        if (service.deletar(matricula)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}