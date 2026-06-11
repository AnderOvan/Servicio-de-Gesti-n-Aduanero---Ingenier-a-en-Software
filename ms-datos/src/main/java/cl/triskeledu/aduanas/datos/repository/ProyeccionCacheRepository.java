package cl.triskeledu.aduanas.datos.repository;

import cl.triskeledu.aduanas.datos.model.ProyeccionCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionCacheRepository extends JpaRepository<ProyeccionCache, String> {
}
