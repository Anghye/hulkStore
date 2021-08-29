package com.hulkStore.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hulkStore.entities.Persona;


public interface PersonaRepository extends CrudRepository<Persona, Integer>
{
	@Query("select p from Persona p "
			+ "where p.correo=:correo and (:constraseña is null or p.constraseña=:constraseña)")
	Optional<Persona> getLoginPersona(@Param("correo") String correo, @Param("contraseña") String contraseña);
	
}
