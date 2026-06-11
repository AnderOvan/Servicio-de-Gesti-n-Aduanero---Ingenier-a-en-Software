package cl.triskeledu.aduanas.sag.repository;

import cl.triskeledu.aduanas.sag.model.Declaracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclaracionRepository extends JpaRepository<Declaracion, Integer> {
    List<Declaracion> findByRutViajero(String rutViajero);
    List<Declaracion> findAllByOrderByIdAsc();
}
