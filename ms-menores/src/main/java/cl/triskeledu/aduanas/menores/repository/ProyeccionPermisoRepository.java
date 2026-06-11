package cl.triskeledu.aduanas.menores.repository;

import cl.triskeledu.aduanas.menores.model.ProyeccionPermiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionPermisoRepository extends JpaRepository<ProyeccionPermiso, String> {
}
