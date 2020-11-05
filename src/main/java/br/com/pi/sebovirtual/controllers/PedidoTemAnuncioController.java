package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.PedidoTemAnuncio;
import br.com.pi.sebovirtual.repositories.PedidoTemAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.PedidoTemAnuncioService;

@RestController
@RequestMapping("itensdopedido")
public class PedidoTemAnuncioController extends BaseController
	<PedidoTemAnuncio, PedidoTemAnuncioRepository, PedidoTemAnuncioService> {

}