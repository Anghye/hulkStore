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
public class FiltroProductoDTO {
	
	private String producto;
	private String categoria;
	private String busqueda;

}
