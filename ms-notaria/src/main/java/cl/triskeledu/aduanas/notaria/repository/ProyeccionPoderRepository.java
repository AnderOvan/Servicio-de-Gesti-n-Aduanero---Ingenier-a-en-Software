package cl.triskeledu.aduanas.notaria.repository;

import cl.triskeledu.aduanas.notaria.model.ProyeccionPoder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionPoderRepository extends JpaRepository<ProyeccionPoder, String> {
}
