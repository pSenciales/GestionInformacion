package GI.proyecto.service;

import GI.proyecto.model.tSolucion;
import GI.proyecto.repository.SolucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class tSolucionService {
    @Autowired
    SolucionRepository solucionRepository;

    public List<tSolucion> getAll(){
        return solucionRepository.findAll();
    }
}
