package GI.proyecto.controller;

import java.util.List;
import java.util.Optional;

import GI.proyecto.model.tSolucion;
import GI.proyecto.model.tUsuario;
import GI.proyecto.service.tSolucionService;
import GI.proyecto.service.tUsuarioService;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import GI.proyecto.model.tMuestra;
import GI.proyecto.model.tPermiso;
import GI.proyecto.service.tMuestraService;
import GI.proyecto.service.tPermisoService;

@Controller
public class webController {
	@Autowired
	tMuestraService muestraService;

	@Autowired
	tSolucionService solucionService;

	@Autowired
	tUsuarioService usuarioService;

	@Autowired
	tPermisoService permisoService;

	@GetMapping("/muestra")
	public String listarMuestras(Model model, HttpSession sesion) {
		tMuestra muestra = new tMuestra();
		tUsuario usuario = usuarioService.findById((String) sesion.getAttribute("nif")).get(0); // sacamos de la sesion
																								// el nif pasada en el
																								// login
		tPermiso permiso = permisoService.findPermiso(usuario.getRolName());
		model.addAttribute("usuario", usuario);
		model.addAttribute("permiso", permiso);
		model.addAttribute("muestra", muestra);

		List<tMuestra> muestrasList = muestraService.getAll();
		model.addAttribute("muestrasList", muestrasList);

		List<tSolucion> soluciones = solucionService.getAll();
		model.addAttribute("soluciones", soluciones);
		return "viewMuestras";
	}

	@PostMapping("/guardar-muestra")
	public String guardarMuestra(tMuestra nuevaMuestra) {
		muestraService.guardarMuestra(nuevaMuestra);
		return "redirect:/muestra";
	}

	@RequestMapping("/mostrarMuestra")
	public String doShowMostrar(Model model, @RequestParam("muestraId") Integer muestraId, HttpSession sesion) {
		tUsuario usuario = usuarioService.findById((String) sesion.getAttribute("nif")).get(0);
		tPermiso permiso = permisoService.findPermiso(usuario.getRolName());
		model.addAttribute("permiso", permiso);
		model.addAttribute("usuario", usuario);

		tMuestra muestra = muestraService.getMuestra(muestraId);
		model.addAttribute("muestra", muestra);

		List<tMuestra> muestrasList = muestraService.getAll();
		model.addAttribute("muestrasList", muestrasList);

		tMuestra nuevaMuestra = new tMuestra();
		model.addAttribute("nuevaMuestra", nuevaMuestra);

		List<tSolucion> soluciones = solucionService.getAll();
		model.addAttribute("soluciones", soluciones);
		return "viewMuestras";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuario", new tUsuario());
		return "loginView";
	}

	@PostMapping("/post-login")
	public String postLogin(tUsuario usuario, HttpSession sesion) {

		List<tUsuario> user = usuarioService.findById(usuario.getNif());

		if (user.size() == 1 && user.get(0).getPassword().equals(usuario.getPassword())) { // podemos usar el bCrypt
			tPermiso permiso = permisoService.findPermiso(user.get(0).getRolName());
			if (permiso.getAcceso()) {
				sesion.setAttribute("nif", user.get(0).getNif()); // Al hacer login metemos por la sesión el
																	// nif para poder hacer uso del usuario en otras
																	// vistas
				return "redirect:/muestra";
			}else{
				return "error";
			}

		} else {
			return "error";
		}
	}

	@GetMapping("/exit")
	public String exit() {
		return "redirect:/";
	}

	@GetMapping("/goLogin")
	public String goLogin(HttpSession sesion) {
		sesion.invalidate();
		return "loginView";
	}

	@PostMapping("/limpiar")
	public String limpiar() {
		return "redirect:/muestra";
	}

	@RequestMapping("/borrar-muestra/{id}")
	public String cargarPaginaBorrar(@PathVariable Optional<Integer> optionalId) {
		if(optionalId.isPresent()) {
			Integer id = optionalId.get();
			muestraService.delete(id);
			return "redirect:/muestra";

		}
		return "/";

	}

	@PostMapping("/editar-muestra/{id}")
	public String actualizar(@PathVariable Integer id, tMuestra muestraActualizada) {

		muestraService.updateMuestra(id, muestraActualizada.getNIF_Paciente(), muestraActualizada.getCultivo(),
				muestraActualizada.getSolucion());

		return "redirect:/muestra";
	}
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleException(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("errorDetails", e.getMessage());
        return modelAndView;
    }

}