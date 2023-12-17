package GI.proyecto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GI.proyecto.model.tPermiso;
import GI.proyecto.repository.PermisoRepository;

@Service
public class tPermisoService {
	
	@Autowired
	PermisoRepository pRepository;
	public tPermiso findPermiso(String rol) {
		return pRepository.findPermiso(rol);
	}
}
