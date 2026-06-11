package cl.triskeledu.aduanas.proceso.repository;

import cl.triskeledu.aduanas.proceso.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    List<Movimiento> findByRutViajero(String rutViajero);
    List<Movimiento> findAllByOrderByIdAsc();
}
