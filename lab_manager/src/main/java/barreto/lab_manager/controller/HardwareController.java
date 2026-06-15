package barreto.lab_manager.controller;

import barreto.lab_manager.model.Hardware;
import barreto.lab_manager.service.HardwareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hardwares")
@RequiredArgsConstructor
public class HardwareController {

    private final HardwareService service;

    @GetMapping
    public ResponseEntity<List<Hardware>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hardware> buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Hardware> criar(@RequestBody Hardware hardware) {
        Hardware novoHardware = service.salvar(hardware);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoHardware);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hardware> atualizar(@PathVariable Integer id, @RequestBody Hardware hardware) {
        return service.atualizar(id, hardware)
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