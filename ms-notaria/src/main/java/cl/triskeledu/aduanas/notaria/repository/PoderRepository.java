package cl.triskeledu.aduanas.notaria.repository;

import cl.triskeledu.aduanas.notaria.model.Poder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PoderRepository extends JpaRepository<Poder, Integer> {
    List<Poder> findByRutTitular(String rutTitular);
    List<Poder> findByRutApoderado(String rutApoderado);
    List<Poder> findAllByOrderByIdAsc();
}
