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
public class MetodoPagoDTO {
	
	private String tipo;
	private Integer numeroTarjeta;
	private String banco;

}
