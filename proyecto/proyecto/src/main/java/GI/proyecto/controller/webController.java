package GI.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import GI.proyecto.model.tMuestra;
import GI.proyecto.service.tMuestraService;

@Controller
public class webController {
	@Autowired
	tMuestraService muestraService;

	@GetMapping("/nueva-muestra")
	public String listarMuestras(Model model){
		List<tMuestra> muestrasList = muestraService.getAll();
		model.addAttribute("muestrasList", muestrasList);
		return "viewMuestras";
	}
	
	@PostMapping("/guardar-muestra")
    public String guardarMuestra(@ModelAttribute tMuestra nuevaMuestra) {
        muestraService.guardarMuestra(nuevaMuestra);
        
        return "redirect:/";
    }
}
