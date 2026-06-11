package cl.triskeledu.aduanas.datos.repository;

import cl.triskeledu.aduanas.datos.model.Configuracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConfiguracionRepository extends JpaRepository<Configuracion, Integer> {
    Optional<Configuracion> findByClave(String clave);
    boolean existsByClave(String clave);
    List<Configuracion> findByMsDuenio(String msDuenio);
    List<Configuracion> findByActivoTrue();
    List<Configuracion> findAllByOrderByIdAsc();
}
