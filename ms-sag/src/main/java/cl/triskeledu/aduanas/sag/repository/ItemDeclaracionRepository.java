package cl.triskeledu.aduanas.sag.repository;

import cl.triskeledu.aduanas.sag.model.ItemDeclaracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDeclaracionRepository extends JpaRepository<ItemDeclaracion, Integer> {
    List<ItemDeclaracion> findByIdDeclaracion(Integer idDeclaracion);
}
