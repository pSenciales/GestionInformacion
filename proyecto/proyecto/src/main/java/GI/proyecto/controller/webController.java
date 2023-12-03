package GI.proyecto.controller;

import GI.proyecto.model.tMuestra;
import GI.proyecto.repository.MuestraRepository;
import GI.proyecto.service.tMuestraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class webController {
	@Autowired
	tMuestraService muestraService;

	@GetMapping("/")
	public String listarMuestras(Model model){
		List<tMuestra> muestrasList = muestraService.getAll();
		model.addAttribute("muestrasList", muestrasList);
		return "viewMuestras";
	}
}
