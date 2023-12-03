package GI.proyecto.controller;

import java.util.List;

import GI.proyecto.model.tSolucion;
import GI.proyecto.service.tSolucionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import GI.proyecto.model.tMuestra;
import GI.proyecto.service.tMuestraService;

@Controller
public class webController {
	@Autowired
	tMuestraService muestraService;

	@Autowired
	tSolucionService solucionService;


	@GetMapping("/muestra")
	public String listarMuestras(Model model){
		tMuestra muestra = new tMuestra();
		model.addAttribute("muestra",muestra);

		List<tMuestra> muestrasList = muestraService.getAll();
		model.addAttribute("muestrasList", muestrasList);

		List<tSolucion> soluciones = solucionService.getAll();
		model.addAttribute("soluciones",soluciones);
		return "viewMuestras";
	}
	
	@PostMapping("/guardar-muestra")
    public String guardarMuestra(tMuestra nuevaMuestra) {
        muestraService.guardarMuestra(nuevaMuestra);
        return "redirect:/muestra";
    }

	@RequestMapping("/mostrarMuestra")
	public String doShowMostrar(Model model, @RequestParam("muestraId") Integer muestraId){
		tMuestra muestra = muestraService.getMuestra(muestraId);
		model.addAttribute("muestra",muestra);

		List<tMuestra> muestrasList = muestraService.getAll();
		model.addAttribute("muestrasList", muestrasList);

		tMuestra nuevaMuestra = new tMuestra();
		model.addAttribute("nuevaMuestra",nuevaMuestra);

		List<tSolucion> soluciones = solucionService.getAll();
		model.addAttribute("soluciones",soluciones);
		return "viewMuestras";
	}
}
