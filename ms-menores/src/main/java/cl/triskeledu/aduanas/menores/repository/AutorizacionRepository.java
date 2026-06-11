package cl.triskeledu.aduanas.menores.repository;

import cl.triskeledu.aduanas.menores.model.Autorizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorizacionRepository extends JpaRepository<Autorizacion, Integer> {
    List<Autorizacion> findByRutMenor(String rutMenor);
    List<Autorizacion> findAllByOrderByIdAsc();
}
