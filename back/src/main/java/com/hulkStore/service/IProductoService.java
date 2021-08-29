package com.hulkStore.service;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hulkStore.dto.CompraDTO;
import com.hulkStore.dto.FiltroProductoDTO;
import com.hulkStore.dto.ProductoDTO;

public interface IProductoService {

	boolean registroProducto(ProductoDTO producto);

	Page<ProductoDTO> listarProducto(FiltroProductoDTO filtro, Pageable page);

	boolean actulizarStock(ProductoDTO producto);

	boolean registrarCompra(CompraDTO compra);

	boolean validarStock(Integer idProducto);

}
