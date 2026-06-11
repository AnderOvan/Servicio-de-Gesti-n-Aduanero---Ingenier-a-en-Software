package cl.triskeledu.aduanas.proceso.repository;

import cl.triskeledu.aduanas.proceso.model.Viajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ViajeroRepository extends JpaRepository<Viajero, Integer> {
    Optional<Viajero> findByRut(String rut);
    boolean existsByRut(String rut);
    boolean existsByPasaporte(String pasaporte);
    List<Viajero> findAllByOrderByIdAsc();
}
