package cl.triskeledu.aduanas.reporte.repository;

import cl.triskeledu.aduanas.reporte.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
    List<Reporte> findByTipo(String tipo);
    List<Reporte> findByRutOficial(String rutOficial);
    List<Reporte> findAllByOrderByIdAsc();
}
