package GI.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GI.proyecto.model.tUsuario;
import GI.proyecto.repository.UsuarioRepository;
@Service
public class tUsuarioService {
	@Autowired
	UsuarioRepository repository;
	
	public List<tUsuario> findById(String id){
		return repository.findByNif(id);
	}
}
