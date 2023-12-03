package GI.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GI.proyecto.model.tRol;
import GI.proyecto.repository.RolRepository;

@Service
public class tRolService {
	@Autowired
    RolRepository repository;
	
	public List<tRol> getAll(){
		return repository.findAll();
	}
}
