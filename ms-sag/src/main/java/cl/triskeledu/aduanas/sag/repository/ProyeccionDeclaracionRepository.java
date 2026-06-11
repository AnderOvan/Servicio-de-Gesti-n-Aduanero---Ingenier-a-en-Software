package cl.triskeledu.aduanas.sag.repository;

import cl.triskeledu.aduanas.sag.model.ProyeccionDeclaracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionDeclaracionRepository extends JpaRepository<ProyeccionDeclaracion, String> {
}
