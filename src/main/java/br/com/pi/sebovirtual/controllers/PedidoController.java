package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Pedido;
import br.com.pi.sebovirtual.repositories.PedidoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.PedidoService;

@RestController
@RequestMapping("pedido")
public class PedidoController extends BaseController<Pedido, PedidoRepository, PedidoService> {

}
