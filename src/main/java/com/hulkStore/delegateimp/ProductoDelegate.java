package com.hulkStore.delegateimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hulkStore.delegate.IProductoDelegate;
import com.hulkStore.dto.CompraDTO;
import com.hulkStore.dto.FiltroProductoDTO;
import com.hulkStore.dto.ProductoDTO;
import com.hulkStore.service.IProductoService;

@Service
public class ProductoDelegate implements IProductoDelegate
{

	@Autowired
	private IProductoService productoService;

	@Override
	public boolean registroProducto(ProductoDTO producto) {
		return productoService.registroProducto(producto);
	}


	@Override
	public Page<ProductoDTO> listarProducto(FiltroProductoDTO filtro, Pageable page) {
		return productoService.listarProducto(filtro, page);
	}


	@Override
	public boolean actulizarStock(ProductoDTO producto) {
		return productoService.actulizarStock(producto);
	}


	@Override
	public boolean registrarComprar(CompraDTO compra) {
		return productoService.registrarCompra(compra);
	}


	@Override
	public boolean validarStock(Integer idProducto) {
		return productoService.validarStock(idProducto);
	}
    
}
