package com.hulkStore.controler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hulkStore.constant.ApiResponseStatus;
import com.hulkStore.delegate.IProductoDelegate;
import com.hulkStore.dto.ApiResponseHulkStore;
import com.hulkStore.dto.CompraDTO;
import com.hulkStore.dto.FiltroProductoDTO;
import com.hulkStore.dto.Notification;
import com.hulkStore.dto.ProductoDTO;
import com.hulkStore.endpoints.EndPointProducto;

/**
 * Hello world!
 *
 */
@RestController
@RequestMapping(EndPointProducto.V1_0_1)
public class ProductoControler
{
	@Autowired
	private IProductoDelegate productoDelegate;

	@PostMapping(EndPointProducto.REGISTRO)
	public ResponseEntity<ApiResponseHulkStore<Boolean>> registroProducto(@RequestBody ProductoDTO producto) {
		return ResponseEntity.status(ApiResponseStatus.SUCCESS.getHttpStatus())
				.body(new ApiResponseHulkStore<Boolean>(productoDelegate.registroProducto(producto),
						Notification.builder().code(ApiResponseStatus.SUCCESS.getCode())
								.description(ApiResponseStatus.SUCCESS.getDescription()).build()));
	}
	
	@PostMapping(EndPointProducto.LISTAR)
	public ResponseEntity<ApiResponseHulkStore<Page<ProductoDTO>>> listarProducto(@RequestBody FiltroProductoDTO filtro, Pageable page) {
		return ResponseEntity.status(ApiResponseStatus.SUCCESS.getHttpStatus())
				.body(new ApiResponseHulkStore<Page<ProductoDTO>>(productoDelegate.listarProducto(filtro, page),
						Notification.builder().code(ApiResponseStatus.SUCCESS.getCode())
								.description(ApiResponseStatus.SUCCESS.getDescription()).build()));
	}
	
	@PostMapping(EndPointProducto.ACTUALIZAR)
	public ResponseEntity<ApiResponseHulkStore<Boolean>> actulizarStock(@RequestBody ProductoDTO persona) {
		return ResponseEntity.status(ApiResponseStatus.SUCCESS.getHttpStatus())
				.body(new ApiResponseHulkStore<Boolean>( productoDelegate.actulizarStock(persona),
						Notification.builder().code(ApiResponseStatus.SUCCESS.getCode())
								.description(ApiResponseStatus.SUCCESS.getDescription()).build()));
	}
	
	@PostMapping(EndPointProducto.COMPRAR)
	public ResponseEntity<ApiResponseHulkStore<Boolean>> registrarComprar(@RequestBody CompraDTO compra) {
		return ResponseEntity.status(ApiResponseStatus.SUCCESS.getHttpStatus())
				.body(new ApiResponseHulkStore<Boolean>( productoDelegate.registrarComprar(compra),
						Notification.builder().code(ApiResponseStatus.SUCCESS.getCode())
								.description(ApiResponseStatus.SUCCESS.getDescription()).build()));
	}
	
	@GetMapping(EndPointProducto.VALIDAR_STOCK)
	public ResponseEntity<ApiResponseHulkStore<Boolean>> validarStock(@RequestParam("idProducto") Integer idProducto) {
		return ResponseEntity.status(ApiResponseStatus.SUCCESS.getHttpStatus())
				.body(new ApiResponseHulkStore<Boolean>( productoDelegate.validarStock(idProducto),
						Notification.builder().code(ApiResponseStatus.SUCCESS.getCode())
								.description(ApiResponseStatus.SUCCESS.getDescription()).build()));
	}

}
