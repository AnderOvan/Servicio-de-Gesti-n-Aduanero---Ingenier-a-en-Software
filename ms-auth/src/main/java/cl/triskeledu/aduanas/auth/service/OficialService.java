package cl.triskeledu.aduanas.auth.service;

import cl.triskeledu.aduanas.auth.dto.OficialRequest;
import cl.triskeledu.aduanas.auth.dto.OficialResponse;
import cl.triskeledu.aduanas.auth.event.OficialEventProducer;
import cl.triskeledu.aduanas.auth.mapper.OficialMapper;
import cl.triskeledu.aduanas.auth.model.Oficial;
import cl.triskeledu.aduanas.auth.repository.OficialRepository;
import cl.triskeledu.common.event.OficialCreatedEvent;
import cl.triskeledu.common.event.OficialDeletedEvent;
import cl.triskeledu.common.event.OficialUpdatedEvent;
import cl.triskeledu.common.exception.DuplicateResourceException;
import cl.triskeledu.common.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OficialService {

    private final OficialRepository oficialRepository;
    private final OficialMapper oficialMapper;
    private final OficialEventProducer oficialEventProducer;

    public List<OficialResponse> listarTodos() {
        log.info("Listando todos los oficiales");
        return oficialMapper.toResponseList(oficialRepository.findAllByOrderByIdAsc());
    }

    public List<OficialResponse> listarActivos() {
        log.info("Listando oficiales activos");
        return oficialMapper.toResponseList(oficialRepository.findByActivoTrue());
    }

    public OficialResponse buscarPorId(Integer id) {
        log.info("Buscando oficial por id: {}", id);
        return oficialMapper.toResponse(getOficialById(id));
    }

    public OficialResponse buscarPorRut(String rut) {
        log.info("Buscando oficial por rut: {}", rut);
        return oficialMapper.toResponse(
            oficialRepository.findByRut(rut)
                .orElseThrow(() -> new EntityNotFoundException("Oficial", "rut", rut))
        );
    }

    @Transactional
    @SuppressWarnings("null")
    public OficialResponse crear(OficialRequest request) {
        log.info("Creando oficial con rut: {}", request.getRut());
        validarRutUnico(request.getRut());
        Oficial oficial = oficialMapper.toEntity(request);
        Oficial guardado = oficialRepository.save(oficial);
        oficialEventProducer.sendOficialCreated(
            OficialCreatedEvent.builder()
                .rut(guardado.getRut())
                .nombre(guardado.getNombre())
                .rol(guardado.getRol())
                .activo(guardado.getActivo())
                .build()
        );
        return oficialMapper.toResponse(guardado);
    }

    @Transactional
    public OficialResponse actualizar(Integer id, OficialRequest request) {
        log.info("Actualizando oficial id: {}", id);
        Oficial oficial = getOficialById(id);
        if (!oficial.getRut().equals(request.getRut())) {
            validarRutUnico(request.getRut());
        }
        oficialMapper.updateEntity(request, oficial);
        Oficial actualizado = oficialRepository.save(oficial);
        oficialEventProducer.sendOficialUpdated(
            OficialUpdatedEvent.builder()
                .rut(actualizado.getRut())
                .nombre(actualizado.getNombre())
                .rol(actualizado.getRol())
                .activo(actualizado.getActivo())
                .build()
        );
        return oficialMapper.toResponse(actualizado);
    }

    @Transactional
    @SuppressWarnings("null")
    public void eliminar(Integer id) {
        log.info("Eliminando oficial id: {}", id);
        Oficial oficial = getOficialById(id);
        oficialRepository.delete(oficial);
        oficialEventProducer.sendOficialDeleted(
            OficialDeletedEvent.builder()
                .rut(oficial.getRut())
                .build()
        );
    }
    @SuppressWarnings("null")
    private Oficial getOficialById(Integer id) {
        return oficialRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Oficial", "id", id));
    }

    private void validarRutUnico(String rut) {
        if (oficialRepository.existsByRut(rut)) {
            throw new DuplicateResourceException("Oficial", "rut", rut, rut);
        }
    }
}
