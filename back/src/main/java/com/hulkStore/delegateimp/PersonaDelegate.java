package com.hulkStore.delegateimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulkStore.delegate.IPersonaDelegate;
import com.hulkStore.dto.PersonaDTO;
import com.hulkStore.service.IPersonaServie;

@Service
public class PersonaDelegate implements IPersonaDelegate
{

	@Autowired
	private IPersonaServie personaService;
	
	@Override
	public boolean registroPersona(PersonaDTO persona) {
		return personaService.registroPersona(persona);
	}
	

	@Override
	public PersonaDTO logginPersona(PersonaDTO persona) {
		return personaService.logginPersona(persona);
	}
    
}
