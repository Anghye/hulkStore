package com.hulkStore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hulkStore.types.TipoDocumento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PERSON")
public class Persona 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_Persona")
	private int idPersona;
    
    @Column(name="tipo_documento")
    private TipoDocumento tipoDocumento;
    
    @Column(name="numero_documento")
    private String numeroDocumento;
    
    private String correo;
  
    private String nombre;
    
    private String contrasena;
    
    private Boolean administrador;
 
}
