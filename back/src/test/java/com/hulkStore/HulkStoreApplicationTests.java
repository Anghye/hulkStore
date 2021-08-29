package com.hulkStore;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.hulkStore.dto.PersonaDTO;
import com.hulkStore.entities.Persona;
import com.hulkStore.repositories.PersonaRepository;
import com.hulkStore.serviceimp.PersonaServiceImp;
import com.hulkStore.types.TipoDocumento;

@SpringBootTest
class HulkStoreApplicationTests {
	
	@InjectMocks
	PersonaServiceImp personaServiceImp;
	
	@Mock
	PersonaRepository personaRepository;

	@Test
	public void registroPerona() {
		Persona persona = new Persona(1, TipoDocumento.CC, "123", "ap.roxan2@gmail.com", "Anghye", "dgrre", false);
		Optional<Persona> personaOP=Optional.of(persona);
		when(personaRepository.getLoginPersona("ap.roxan2@gmail.com", null)).thenReturn(personaOP);
		
		Boolean validation=personaServiceImp.registroPersona(PersonaDTO.builder().correo("ap.roxan@gmail.com").build());
		
		assertTrue(validation);
		
	}

}
