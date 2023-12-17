package GI.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import GI.proyecto.model.tPermiso;

public interface PermisoRepository extends JpaRepository<tPermiso, String> {

	@Query(value="select * from T_PERMISO as tp where tp.ROL_NAME_ROL_NAME = :rol", nativeQuery = true)
	tPermiso findPermiso(String rol);
	
	
}
