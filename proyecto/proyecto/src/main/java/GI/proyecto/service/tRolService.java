package GI.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GI.proyecto.model.tRol;
import GI.proyecto.repository.tRolRepository;

@Service
public class tRolService {
	@Autowired
	tRolRepository repository;
	
	public List<tRol> getAll(){
		return repository.findAll();
	}
}
