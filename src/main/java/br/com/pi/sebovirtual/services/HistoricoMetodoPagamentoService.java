package br.com.pi.sebovirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.HistoricoMetodoPagamento;
import br.com.pi.sebovirtual.entities.Status;
import br.com.pi.sebovirtual.repositories.HistoricoMetodoPagamentoRepository;
import br.com.pi.sebovirtual.repositories.StatusRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class HistoricoMetodoPagamentoService extends 
	BaseService<HistoricoMetodoPagamento, HistoricoMetodoPagamentoRepository> {
	
	@Autowired
	private HistoricoMetodoPagamentoRepository metodoPagamentoRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Override
	public HistoricoMetodoPagamento store(HistoricoMetodoPagamento entity) {
		// Obtém o id do usuário dono do método de pagamento.
		Integer idUsuario = entity.getUsuario().getId();
		
		// Se o ID é igual a null, significa que está cadastrando um novo 
		// método de pagamento
		if (entity.getIdMetodoPagamento() == null) {
			// Obtém o próximo idMetodoPagamento e o define no objeto metodoPagamento.
			Integer idMetodoPagamento = 
				metodoPagamentoRepository.getNextIdMetodoPagamento(idUsuario);
			entity.setIdMetodoPagamento(
				idMetodoPagamento == null ? 1 : idMetodoPagamento);
		}
		
		// O novo registro possui status ativo.
		Optional<Status> statusAtivo = 
			statusRepository.findOneByNome(Status.ATIVO);
		if (statusAtivo.isPresent()) {
			entity.setStatus(statusAtivo.get());
		}
		entity.setDataModificacao(java.time.LocalDateTime.now());
		return super.store(entity);
	}
	
	@Override
	public HistoricoMetodoPagamento update(Integer id, HistoricoMetodoPagamento entity) {
		HistoricoMetodoPagamento current = super.getOne(id);

		// O idMetodoPagamento não muda, pois apenas uma nova versão deste mesmo
		// método de pagamento é cadastrada.
		entity.setIdMetodoPagamento(current.getIdMetodoPagamento());
		
		// Completa os outros campos se esses estiverem nulos
		if (entity.getEmail() == null) {
			entity.setEmail(current.getEmail());
		}
		if (entity.getTipoMetodoPagamento() == null) {
			entity.setTipoMetodoPagamento(current.getTipoMetodoPagamento());
		}
		if (entity.getUsuario() == null) {
			entity.setUsuario(current.getUsuario());
		}
		if (entity.getPrincipal() == null) {
			entity.setPrincipal(current.getPrincipal());
		} else if (entity.getPrincipal() == true) {
		    int userId = entity.getUsuario().getId(); 
		    Integer idMainActive = metodoPagamentoRepository.
		    	findMainActiveMethodPaymentByUser(userId);
		    if (idMainActive != null && idMainActive != id)  {
		    	HistoricoMetodoPagamento oldMainActive = super.getOne(idMainActive);
		    	oldMainActive.setPrincipal(false);
		    }
		}
		
		// O status do registro atual muda para editado.
		Optional<Status> statusEditado = 
			statusRepository.findOneByNome(Status.EDITADO);
		if (statusEditado.isPresent()) {
			current.setStatus(statusEditado.get()); // Muda o status para editado			
		}
		
		// Cria um novo registro para este método de pagamento.
		return this.store(entity);
	}
	
	@Override
	public void destroy(Integer id) {
		// Não apaga o registro de fato, pois ele pode estar sendo
		// referenciado por um pedido, mas seu status muda para excluído.
		HistoricoMetodoPagamento current = this.getOne(id);
		Optional<Status> status = 
			statusRepository.findOneByNome(Status.EXCLUIDO);
		if (status.isPresent()) {
			current.setStatus(status.get()); // Muda o status para excluido			
		}
	}


}
