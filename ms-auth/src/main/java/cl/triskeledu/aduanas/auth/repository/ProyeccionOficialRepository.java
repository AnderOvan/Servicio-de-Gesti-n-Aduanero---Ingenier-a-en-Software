package cl.triskeledu.aduanas.auth.repository;

import cl.triskeledu.aduanas.auth.model.ProyeccionOficial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionOficialRepository extends JpaRepository<ProyeccionOficial, String> {
}
