package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.PedidoTemAnuncio;
import br.com.pi.sebovirtual.repositories.PedidoTemAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class PedidoTemAnuncioService extends BaseService
	<PedidoTemAnuncio, PedidoTemAnuncioRepository> {

}
