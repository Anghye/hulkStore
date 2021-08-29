package com.hulkStore.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hulkStore.constant.ApiResponseStatus;
import com.hulkStore.delegate.IPersonaDelegate;
import com.hulkStore.dto.ApiResponseHulkStore;
import com.hulkStore.dto.PersonaDTO;
import com.hulkStore.endpoints.EndPointPersona;
import com.hulkStore.dto.Notification;

/**
 * Hello world!
 *
 */
@RestController
@RequestMapping(EndPointPersona.V1_0_1)
public class PersonaControler
{
	@Autowired
	private IPersonaDelegate personaDelegate;

	@PostMapping(EndPointPersona.REGISTRO)
	public ResponseEntity<ApiResponseHulkStore<Boolean>> registroPersona(@RequestBody PersonaDTO persona) {
		return ResponseEntity.status(ApiResponseStatus.SUCCESS.getHttpStatus())
				.body(new ApiResponseHulkStore<Boolean>(personaDelegate.registroPersona(persona),
						Notification.builder().code(ApiResponseStatus.SUCCESS.getCode())
								.description(ApiResponseStatus.SUCCESS.getDescription()).build()));
	}
	
	@PostMapping(EndPointPersona.LOGIN)
	public PersonaDTO logginPersona(@RequestBody PersonaDTO persona) {
		return personaDelegate.logginPersona(persona);
	}

}
