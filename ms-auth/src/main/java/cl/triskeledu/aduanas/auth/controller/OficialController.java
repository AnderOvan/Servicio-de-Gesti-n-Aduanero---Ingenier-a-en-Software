package cl.triskeledu.aduanas.auth.controller;

import cl.triskeledu.aduanas.auth.dto.OficialRequest;
import cl.triskeledu.aduanas.auth.dto.OficialResponse;
import cl.triskeledu.aduanas.auth.service.OficialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/oficiales")
@RequiredArgsConstructor
public class OficialController {

    private final OficialService oficialService;

    @GetMapping
    public ResponseEntity<List<OficialResponse>> listarTodos() {
        return ResponseEntity.ok(oficialService.listarTodos());
    }

    @GetMapping("/activos")
    public ResponseEntity<List<OficialResponse>> listarActivos() {
        return ResponseEntity.ok(oficialService.listarActivos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OficialResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(oficialService.buscarPorId(id));
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<OficialResponse> buscarPorRut(@PathVariable String rut) {
        return ResponseEntity.ok(oficialService.buscarPorRut(rut));
    }

    @PostMapping
    public ResponseEntity<OficialResponse> crear(@Valid @RequestBody OficialRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(oficialService.crear(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OficialResponse> actualizar(@PathVariable Integer id,
                                                       @Valid @RequestBody OficialRequest request) {
        return ResponseEntity.ok(oficialService.actualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        oficialService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
