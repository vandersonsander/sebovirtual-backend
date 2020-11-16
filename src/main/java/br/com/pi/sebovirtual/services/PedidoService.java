package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Pedido;
import br.com.pi.sebovirtual.repositories.PedidoRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class PedidoService extends BaseService<Pedido, PedidoRepository> {
	
	/*@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	HistoricoAnuncioRepository anuncioRepository;
	
	@Override
	public Pedido store(Pedido entity) {
		super.store(entity);

		// Pedido já foi criado, agora posso obter o id do pedido.
		Integer idPedido = entity.getId();
		System.out.println("Id do pedido: " + idPedido);
		
		Pedido p = pedidoRepository.getOne(idPedido);
		//HistoricoAnuncio a = anuncioRepository.getOne(this.);
		for (PedidoTemAnuncio item : entity.getItens()) {
			item.setPedido(p);
			item.setHistoricoAnuncio(anuncioRepository.getOne(item.getHistoricoAnuncio().getId()));
			//pedidoTemAnuncioRepository.save(item);
		}

		return entity;
		
	}*/

}
