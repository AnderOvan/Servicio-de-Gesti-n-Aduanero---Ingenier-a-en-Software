package cl.triskeledu.aduanas.proceso.repository;

import cl.triskeledu.aduanas.proceso.model.ProyeccionViajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionViajeroRepository extends JpaRepository<ProyeccionViajero, String> {
}
