package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Pedido;
import br.com.pi.sebovirtual.repositories.PedidoRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class PedidoService extends BaseService<Pedido, PedidoRepository> {

}
