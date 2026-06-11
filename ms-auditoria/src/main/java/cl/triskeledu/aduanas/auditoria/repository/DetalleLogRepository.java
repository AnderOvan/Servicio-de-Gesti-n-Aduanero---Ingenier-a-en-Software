package cl.triskeledu.aduanas.auditoria.repository;

import cl.triskeledu.aduanas.auditoria.model.DetalleLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleLogRepository extends JpaRepository<DetalleLog, Integer> {
    List<DetalleLog> findByIdLog(Integer idLog);
}
