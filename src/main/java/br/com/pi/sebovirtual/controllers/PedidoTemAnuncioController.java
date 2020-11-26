package br.com.pi.sebovirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.dto.ListaItensPedidoDTO;
import br.com.pi.sebovirtual.entities.Pedido;
import br.com.pi.sebovirtual.entities.PedidoTemAnuncio;
import br.com.pi.sebovirtual.repositories.PedidoTemAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.PedidoTemAnuncioService;

@CrossOrigin
@RestController
@RequestMapping("itensdopedido")
public class PedidoTemAnuncioController extends BaseController
	<PedidoTemAnuncio, PedidoTemAnuncioRepository, PedidoTemAnuncioService> {
	@Autowired
	private PedidoTemAnuncioService itemsService;
	
	@PostMapping("/gerarpedido")
	@Transactional
	public ResponseEntity<Pedido> storeItems(
			@RequestBody ListaItensPedidoDTO lista) {
		return ResponseEntity.ok().body(itemsService.storeItems(lista));
	}

}