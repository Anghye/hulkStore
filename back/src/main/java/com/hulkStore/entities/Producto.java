package com.hulkStore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.hulkStore.types.TipoCategoria;
import com.hulkStore.types.TipoProducto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PRODUCTO")
public class Producto 
{
    @Column(name="id_producto")
	private int idProducto;
  
    private String nombre;
    
    @Column(name="url_imagen")
    private String urlImagen;
    
    private int disponibles;
    
    private String precio;
    
    private TipoProducto tipo;
    
    private TipoCategoria categoria;
 
}
