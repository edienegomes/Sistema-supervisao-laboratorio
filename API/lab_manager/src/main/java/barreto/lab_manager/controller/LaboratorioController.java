package barreto.lab_manager.controller;

import barreto.lab_manager.model.Laboratorio;
import barreto.lab_manager.service.LaboratorioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laboratorios")
@RequiredArgsConstructor
public class LaboratorioController {

    private final LaboratorioService service;

    @GetMapping
    public ResponseEntity<List<Laboratorio>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laboratorio> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Laboratorio> criar(@RequestBody Laboratorio laboratorio) {
        Laboratorio novoLaboratorio = service.salvar(laboratorio);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLaboratorio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laboratorio> atualizar(@PathVariable Integer id, @RequestBody Laboratorio laboratorio) {
        return service.atualizar(id, laboratorio)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}