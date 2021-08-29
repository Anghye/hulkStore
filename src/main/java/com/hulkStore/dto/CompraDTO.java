package com.hulkStore.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class CompraDTO {
	
	private List<ProductoDTO> productos;
	private Integer idPersona;
	private MetodoPagoDTO metodoPago;
	private String estado;
	

}
