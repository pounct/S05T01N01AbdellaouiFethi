package cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.model.dto;

import java.util.Arrays;

import java.util.List;

import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.model.domain.Sucursal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class SucursalDTO {
	
	
	private Integer pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	
	private String tipusSucursal;
	
	 private static final List<String> countries = Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus", "Czech Republic",
	            "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia",
	            "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia",
	            "Slovenia", "Spain", "Sweden");
	 
	 
	public static SucursalDTO toDTO(Sucursal entity) {
	SucursalDTO dto = SucursalDTO.builder()
			.pk_SucursalID(entity.getPk_SucursalID())
			.nomSucursal(entity.getNomSucursal())
			.paisSucursal(entity.getPaisSucursal())
			.build();
	
	dto.setTipusSucursal(countries.contains(dto.getPaisSucursal())?"EU":"ForaUE");
	
	return dto;
	}
}
