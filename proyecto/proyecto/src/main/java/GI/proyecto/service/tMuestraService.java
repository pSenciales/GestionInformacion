package GI.proyecto.service;

import GI.proyecto.model.tMuestra;
import GI.proyecto.repository.MuestraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tMuestraService{
        @Autowired
        MuestraRepository muestraRepository;

        public List<tMuestra> getAll(){
            return muestraRepository.findAll();
        }
        
        public void guardarMuestra(tMuestra muestra) {
            muestraRepository.saveAndFlush(muestra);
        }

        public tMuestra getMuestra(Integer muestraId){
        	return muestraRepository.findById(muestraId).orElse(null);
        }
        
        public void delete(Integer id) {
            muestraRepository.deleteById(id);
        }
}


