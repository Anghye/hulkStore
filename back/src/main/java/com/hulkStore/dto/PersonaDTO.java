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
public class PersonaDTO {
	
	private String tipoDocumento;
	private String numeroDocumento;
	private String nombre;
	private String correo;
	private String constrasena;
	private boolean administrador;

}
