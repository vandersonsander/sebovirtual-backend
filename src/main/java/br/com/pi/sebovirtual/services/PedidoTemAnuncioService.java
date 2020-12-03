package br.com.pi.sebovirtual.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.pi.sebovirtual.dto.ListaItensPedidoDTO;
import br.com.pi.sebovirtual.entities.Pedido;
import br.com.pi.sebovirtual.entities.PedidoTemAnuncio;
import br.com.pi.sebovirtual.repositories.PedidoTemAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class PedidoTemAnuncioService extends BaseService
	<PedidoTemAnuncio, PedidoTemAnuncioRepository> {
	@Autowired
	private PedidoTemAnuncioRepository itemsRepository;
	@Autowired
	private HistoricoAnuncioService anuncioService;
	@Autowired
	private PedidoService pedidoService;
	
	public Pedido storeItems(ListaItensPedidoDTO lista) {
		// Verifica se o id do comprador é igual ao do vendedor
		Integer compradorId = lista.getPedido().getUsuario().getId();
		Integer vendedorId = anuncioService
				.getOne(lista.getItens().get(0).getAnuncio().getId()).getUsuario().getId();
		
		if (compradorId == vendedorId)
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,
					"Você não pode comprar seus próprios produtos");
		
		Pedido pedido = pedidoService.store(lista.getPedido());
		
		List<PedidoTemAnuncio> newItens = new ArrayList<>();
		lista.getItens().forEach((item) -> {
			PedidoTemAnuncio pta = new PedidoTemAnuncio();
			pta.setHistoricoAnuncio(anuncioService.getOne(item.getAnuncio().getId()));
			pta.setPedido(pedido);
			pta.setQuantidade(item.getQuantidade());
			newItens.add(pta);
		});
		itemsRepository.saveAll(newItens);
		return pedido;
	}
	
}
