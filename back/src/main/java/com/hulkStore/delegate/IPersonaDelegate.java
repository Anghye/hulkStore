package com.hulkStore.delegate;

import com.hulkStore.dto.PersonaDTO;

/**
 * Hello world!
 *
 */
public interface IPersonaDelegate 
{
    
	public boolean registroPersona(PersonaDTO persona);

	public PersonaDTO logginPersona(PersonaDTO persona);
}
