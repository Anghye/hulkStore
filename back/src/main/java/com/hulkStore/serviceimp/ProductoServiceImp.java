package com.hulkStore.serviceimp;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hulkStore.constant.ApiResponseStatus;
import com.hulkStore.dto.CompraDTO;
import com.hulkStore.dto.FiltroProductoDTO;
import com.hulkStore.dto.ProductoDTO;
import com.hulkStore.entities.Producto;
import com.hulkStore.entities.Venta;
import com.hulkStore.exception.HulkStroreExcepcition;
import com.hulkStore.repositories.ProductoRepository;
import com.hulkStore.repositories.VentaRepository;
import com.hulkStore.service.IProductoService;
import com.hulkStore.utils.Seguridad;
import com.hulkStore.utils.UtilObjects;

@Service
public class ProductoServiceImp implements IProductoService 
{

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private VentaRepository ventaRepository;
	
	@Override
	public boolean registroProducto(ProductoDTO producto) {
		try {
		Producto productoEntity= new Producto();
		UtilObjects.copiarPropiedades(producto, productoEntity);
		productoRepository.save(productoEntity);
		return true;
		}catch (Exception e) {
			throw new HulkStroreExcepcition(ApiResponseStatus.FAIL.getCode(),
					ApiResponseStatus.FAIL.getHttpStatus(),
					ApiResponseStatus.FAIL.getDescription());
		}
	}

	@Override
	public Page<ProductoDTO> listarProducto(FiltroProductoDTO filtro, Pageable page) {
		List<ProductoDTO> listProductDTO = new ArrayList<>();
		Page<Producto> listProdcut = productoRepository.listProductoPorFiltro(filtro.getProducto(),
				filtro.getCategoria(), filtro.getBusqueda(), page);
		if (listProdcut.hasContent()) {
			listProdcut.getContent().forEach(producto -> {
				ProductoDTO productoDTO = new ProductoDTO();
				UtilObjects.copiarPropiedades(producto, productoDTO);
				productoDTO.setPrecio(Seguridad.encryptSHA256(String.valueOf(producto.getPrecio())));
				listProductDTO.add(productoDTO);
			});
		}
		return new PageImpl<>(listProductDTO, page, listProdcut.getTotalElements());
	}

	@Override
	public boolean actulizarStock(ProductoDTO producto) {
		Optional<Producto> productoOp = productoRepository.findById(producto.getIdProducto());
		if (productoOp.isPresent()) {
			UtilObjects.copiarPropiedades(producto, productoOp.get());
			if (Objects.nonNull(producto.getDisponibles())) {
				productoOp.get().setDisponibles(producto.getDisponibles());
			}
			productoOp.get().setDisponibles(productoOp.get().getDisponibles()-producto.getCantidad());
			productoRepository.save(productoOp.get());
			return true;
		}
		throw new HulkStroreExcepcition(ApiResponseStatus.PRODUCO_NO_EXISTE.getCode(),
				ApiResponseStatus.PRODUCO_NO_EXISTE.getHttpStatus(),
				ApiResponseStatus.PRODUCO_NO_EXISTE.getDescription());
	}

	@Override
	public boolean registrarCompra(CompraDTO compra) {
		List<Venta> ventas= new ArrayList<>();
		if(!compra.getProductos().isEmpty()) {
			compra.getProductos().forEach(producto ->{
				Venta venta=Venta.builder().idPersona(compra.getIdPersona()).idProducto(producto.getIdProducto())
						.cantidad(producto.getCantidad()).estado(compra.getEstado()).build();
				ventas.add(venta);
				if(Objects.equals(venta.getEstado(), "COMPLETA")){
					actulizarStock(producto);
				}
			});
			ventaRepository.saveAll(ventas);
			
			return true;
		}
		throw new HulkStroreExcepcition(ApiResponseStatus.LISTA_PRODCUTOS_VACIA.getCode(),
				ApiResponseStatus.LISTA_PRODCUTOS_VACIA.getHttpStatus(),
				ApiResponseStatus.LISTA_PRODCUTOS_VACIA.getDescription());
	}

	@Override
	public boolean validarStock(Integer idProducto) {
		Optional<Producto> productoOp= productoRepository.findById(idProducto);
		if(productoOp.isPresent() && productoOp.get().getDisponibles()>0) {
			return true;
		}
		throw new HulkStroreExcepcition(ApiResponseStatus.PRODUCO_SIN_STOCK.getCode(),
				ApiResponseStatus.PRODUCO_SIN_STOCK.getHttpStatus(),
				ApiResponseStatus.PRODUCO_SIN_STOCK.getDescription());
	}
	
  
}
