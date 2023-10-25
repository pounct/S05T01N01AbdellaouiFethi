package cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.model.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.model.repository.SucursalRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SucursalService {
	
	private SucursalRepository sucursalRepository;

	
	public void getAll(Model model,  int p, int s, String keyword) {

		Page<Sucursal> pageSucursals = sucursalRepository.search("%" + keyword + "%", PageRequest.of(p, s));

		Page<SucursalDTO> pageSucursalsDTO = sucursalRepository
				.search("%" + keyword + "%", PageRequest.of(p, s))
				.map(SucursalDTO::toDTO);		
		model.addAttribute("llistaSucursals", pageSucursalsDTO.getContent());
		int[] pages = new int[pageSucursalsDTO.getTotalPages()];
		model.addAttribute("pages", pages);
		model.addAttribute("size", s);
		model.addAttribute("paginaActual", p);
		model.addAttribute("pc", keyword);
	}
	
	
	
	public String addSucursal(Model model) {
		model.addAttribute("sucursal", new Sucursal());
		return "formSucursal";
	}



	public String delete(Integer id, int page, int size, @RequestParam(name = "pc", defaultValue = "") String keyword) {

		sucursalRepository.deleteById(id);
		return "redirect:/sucursal/getAll?page=" + page + "&size=" + size + "&pc=" + keyword;

	}

	

	public String editSucursal(Model model, Integer id) {
		Optional<Sucursal> s = sucursalRepository.findById(id);
		model.addAttribute("sucursal", s.get());
		return "formEditSucursal";
	}


	public void guardar(Model model, Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}

}
