package com.hulkStore.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hulkStore.entities.Producto;


public interface ProductoRepository extends CrudRepository<Producto, Integer>
{
	@Query("select p from Producto p "
			+ "where (:tipo is null or p.tipo=:tipo) "
			+ "and (:categoria is null or p.categoria=:categoria) "
			+ "and (:busqueda is null or p.nombre like %:busqueda%)")
	Page<Producto> listProductoPorFiltro(@Param("tipo") String tipo, @Param("categoria") String categoria, @Param("busqueda") String busqueda, Pageable page);
	
}
