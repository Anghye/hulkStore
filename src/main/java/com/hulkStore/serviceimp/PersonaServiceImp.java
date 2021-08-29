package com.hulkStore.serviceimp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulkStore.constant.ApiResponseStatus;
import com.hulkStore.dto.PersonaDTO;
import com.hulkStore.entities.Persona;
import com.hulkStore.exception.HulkStroreExcepcition;
import com.hulkStore.repositories.PersonaRepository;
import com.hulkStore.service.IPersonaServie;
import com.hulkStore.utils.UtilObjects;

@Service
public class PersonaServiceImp implements IPersonaServie 
{
	@Autowired
	private PersonaRepository personaRepository;

	@Override
	public boolean registroPersona(PersonaDTO persona) {
		Optional<Persona> personaOp = personaRepository.getLoginPersona(persona.getCorreo(), null);
		if (!personaOp.isPresent()) {
			Persona personaEntity = new Persona();
			UtilObjects.copiarPropiedades(persona, personaEntity);
			personaRepository.save(personaEntity);
			return true;
		}
		throw new HulkStroreExcepcition(ApiResponseStatus.CORREO_EXISTENTE.getCode(),
				ApiResponseStatus.CORREO_EXISTENTE.getHttpStatus(),
				ApiResponseStatus.CORREO_EXISTENTE.getDescription());
	}

	@Override
	public PersonaDTO logginPersona(PersonaDTO persona) {
		Optional<Persona> personaEntity= personaRepository.getLoginPersona(persona.getCorreo(), persona.getConstrasena());
		if(personaEntity.isPresent()) {
			UtilObjects.copiarPropiedades(personaEntity, persona);
			return persona;
		}
		throw new HulkStroreExcepcition(ApiResponseStatus.PERSONA_NO_ENCONTRADA.getCode(),
				ApiResponseStatus.PERSONA_NO_ENCONTRADA.getHttpStatus(),
				ApiResponseStatus.PERSONA_NO_ENCONTRADA.getDescription());
	}

	
  
}
