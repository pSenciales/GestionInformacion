package GI.proyecto.repository;

import GI.proyecto.model.tMuestra;
import GI.proyecto.model.tSolucion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MuestraRepository extends JpaRepository<tMuestra, Integer> {
	
	@Transactional
	@Modifying
	@Query("UPDATE tMuestra m SET m.Cultivo = ?3, m.NIF_Paciente = ?2, m.Solucion = ?4 WHERE m.ID = ?1")
	void updateMuestra(Integer id, String nif, String cultivo, tSolucion solucion);

}
