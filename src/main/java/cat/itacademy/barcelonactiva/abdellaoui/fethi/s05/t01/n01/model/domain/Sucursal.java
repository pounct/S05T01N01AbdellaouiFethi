package cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.model.domain;

import java.io.Serializable;

import cat.itacademy.barcelonactiva.abdellaoui.fethi.s05.t01.n01.model.dto.SucursalDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString @Builder
public class Sucursal implements Serializable {

	/**
	 * Entity
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	Integer pk_SucursalID;
	@NotNull
	@Size(min=4,max=15)
	String nomSucursal;
	@NotNull
	@Size(min=4,max=15)
	String paisSucursal;
	
	public static Sucursal toEntity(SucursalDTO dto) {
		Sucursal sucursal= Sucursal.builder()
				.pk_SucursalID(dto.getPk_SucursalID())
				.nomSucursal(dto.getNomSucursal())
				.paisSucursal(dto.getPaisSucursal())
				.build();
		return sucursal;
		
	}




}
