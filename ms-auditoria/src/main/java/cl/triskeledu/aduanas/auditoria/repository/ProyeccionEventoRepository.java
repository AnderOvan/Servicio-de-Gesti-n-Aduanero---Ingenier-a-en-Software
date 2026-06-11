package cl.triskeledu.aduanas.auditoria.repository;

import cl.triskeledu.aduanas.auditoria.model.ProyeccionEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionEventoRepository extends JpaRepository<ProyeccionEvento, String> {
}
