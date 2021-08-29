package com.hulkStore.delegate;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hulkStore.dto.CompraDTO;
import com.hulkStore.dto.FiltroProductoDTO;
import com.hulkStore.dto.ProductoDTO;

public interface IProductoDelegate {

	boolean registroProducto(ProductoDTO producto);

	Page<ProductoDTO> listarProducto(FiltroProductoDTO filtro, Pageable page);

	boolean actulizarStock(ProductoDTO persona);

	boolean registrarComprar(CompraDTO compra);
	
	boolean validarStock(Integer idProducto);

}
