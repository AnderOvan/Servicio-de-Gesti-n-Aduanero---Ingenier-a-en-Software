package cl.triskeledu.aduanas.pdi.repository;

import cl.triskeledu.aduanas.pdi.model.ProyeccionAntecedente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyeccionAntecedenteRepository extends JpaRepository<ProyeccionAntecedente, String> {
}
