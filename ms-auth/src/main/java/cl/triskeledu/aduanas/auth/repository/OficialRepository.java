package cl.triskeledu.aduanas.auth.repository;

import cl.triskeledu.aduanas.auth.model.Oficial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OficialRepository extends JpaRepository<Oficial, Integer> {
    Optional<Oficial> findByRut(String rut);
    List<Oficial> findByActivoTrue();
    boolean existsByRut(String rut);
    List<Oficial> findAllByOrderByIdAsc();
}
