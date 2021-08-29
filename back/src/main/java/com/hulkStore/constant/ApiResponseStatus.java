package com.hulkStore.constant;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ApiResponseStatus {
	
	SUCCESS("00", "Success", HttpStatus.OK),
	
	FAIL("01", "Fail", HttpStatus.INTERNAL_SERVER_ERROR),
	
	PERSONA_NO_ENCONTRADA("HS01", "Los datos ingresados no coinciden", HttpStatus.PRECONDITION_FAILED),
	

	CORREO_EXISTENTE("HS02", "Correo ya registrado en la plataforma", HttpStatus.PRECONDITION_FAILED),
	
	PRODUCO_NO_EXISTE("HS02", "Producto no está registrado en la plataforma", HttpStatus.PRECONDITION_FAILED),
	
	PRODUCO_SIN_STOCK("HS03", "Producto sin stock", HttpStatus.PRECONDITION_FAILED),

	LISTA_PRODCUTOS_VACIA("HS04", "Lista de prductos vacía", HttpStatus.PRECONDITION_FAILED);
	
	
	private String code;

	/**
	 * The description associated.
	 */
	private String description;

	/**
	 * The {@link HttpStatus} associated.
	 */
	private HttpStatus httpStatus;

}
