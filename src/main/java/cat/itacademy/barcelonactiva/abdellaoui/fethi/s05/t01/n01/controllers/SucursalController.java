package cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.model.services.SucursalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/sucursal")
public class SucursalController {

	private SucursalService sucursalService;

	@GetMapping("")
	public String home() {
		return "redirect:/sucursal/getAll";
	}

	@GetMapping("/getAll")
	public String index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "10") int s,
			@RequestParam(name = "pc", defaultValue = "") String keyword) {

		sucursalService.getAll(model, p, s, keyword);
		return "sucursals";

	}

	@GetMapping("/add")
	public String addSucursal(Model model) {
		sucursalService.addSucursal(model);
		return "formSucursal";
	}

	@PostMapping("/guardar")
	public String guardar(Model model, @Valid Sucursal sucursal, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "formSucursal";
		}
		sucursalService.guardar(sucursal);
		return "confirmacio";
	}

	@GetMapping("/delete")
	public String deleteSucursal(Integer id, int page, int size, @RequestParam(name = "pc", defaultValue = "") String keyword) {

		sucursalService.deleteSucursal(id);
		return "redirect:/sucursal/getAll?page=" + page + "&size=" + size + "&pc=" + keyword;

	}

	@GetMapping("/edit")
	public String editSucursal(Model model, Integer id) {
		sucursalService.editSucursal(model, id);
		
		return "formEditSucursal";
	}

}
