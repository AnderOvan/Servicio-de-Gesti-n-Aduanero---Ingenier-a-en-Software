package cl.triskeledu.aduanas.reporte.repository;

import cl.triskeledu.aduanas.reporte.model.DetalleReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleReporteRepository extends JpaRepository<DetalleReporte, Integer> {
    List<DetalleReporte> findByIdReporte(Integer idReporte);
}
