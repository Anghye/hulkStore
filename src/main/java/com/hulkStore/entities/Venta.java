package com.hulkStore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name="VENTA")
public class Venta 
{
    @Column(name="id_venta")
	private int idVenta;
  
    @Column(name="id_persona")
    private int idPersona;
    
    @Column(name="id_producto")
    private int idProducto;
    
    private int cantidad;
    
    private String estado;
 
}
