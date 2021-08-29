package com.hulkStore.dto;

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
public class ProductoDTO {
	
	private Integer idProducto;
	private String nombre;
	private String precio;
	private String urlImage;
	private Integer disponibles;
	private Integer cantidad;
	private String categoria;
	private String tipo;

}
