package cl.triskeledu.aduanas.menores.repository;

import cl.triskeledu.aduanas.menores.model.Menor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MenorRepository extends JpaRepository<Menor, Integer> {
    Optional<Menor> findByRut(String rut);
    boolean existsByRut(String rut);
    List<Menor> findByRutTutor(String rutTutor);
    List<Menor> findAllByOrderByIdAsc();
}
