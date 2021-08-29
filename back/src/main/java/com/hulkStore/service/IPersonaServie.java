package com.hulkStore.service;

import com.hulkStore.dto.PersonaDTO;

public interface IPersonaServie {

	public boolean registroPersona(PersonaDTO persona);
	

	public PersonaDTO logginPersona(PersonaDTO persona);

}
