package cl.triskeledu.aduanas.datos.repository;

import cl.triskeledu.aduanas.datos.model.CacheEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CacheEntryRepository extends JpaRepository<CacheEntry, Integer> {
    Optional<CacheEntry> findByClave(String clave);
    List<CacheEntry> findAllByOrderByIdAsc();
}
