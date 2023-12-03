package GI.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import GI.proyecto.model.tUsuario;

public interface UsuarioRepository extends JpaRepository<tUsuario, String> {
	
	@Query(value = "select * from t_Usuario where NIF = :nif", nativeQuery = true)
	List<tUsuario> findByNif(String nif);
}
