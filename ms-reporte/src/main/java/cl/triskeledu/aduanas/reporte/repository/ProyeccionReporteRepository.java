package cl.triskeledu.aduanas.reporte.repository;

import cl.triskeledu.aduanas.reporte.model.ProyeccionReporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionReporteRepository extends JpaRepository<ProyeccionReporte, String> {
}
