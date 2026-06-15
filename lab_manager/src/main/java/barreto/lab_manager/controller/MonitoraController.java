package barreto.lab_manager.controller;

import barreto.lab_manager.model.Monitora;
import barreto.lab_manager.service.MonitoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monitorias")
@RequiredArgsConstructor
public class MonitoraController {

    private final MonitoraService service;

    @GetMapping
    public ResponseEntity<List<Monitora>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{idLaboratorio}/{matricula}")
    public ResponseEntity<Monitora> buscarPorId(@PathVariable Integer idLaboratorio, @PathVariable Integer matricula) {
        return service.buscarPorId(idLaboratorio, matricula)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Monitora> criar(@RequestBody Monitora monitora) {
        Monitora novaMonitora = service.salvar(monitora);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaMonitora);
    }

    @DeleteMapping("/{idLaboratorio}/{matricula}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idLaboratorio, @PathVariable Integer matricula) {
        if (service.deletar(idLaboratorio, matricula)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}