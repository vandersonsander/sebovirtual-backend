package br.com.pi.sebovirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Condicao;
import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.entities.Status;
import br.com.pi.sebovirtual.repositories.HistoricoAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class HistoricoAnuncioService
	extends BaseService<HistoricoAnuncio, HistoricoAnuncioRepository> {
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private CondicaoService condicaoService;

	public HistoricoAnuncio store(HistoricoAnuncio entity) {
		
		Optional<Status> status = statusService
				.findOneByNome(entity.getStatus().getNome());
		entity.setStatus( !status.isPresent() ? 
			statusService.store(entity.getStatus()) :
			status.get());
		
		Optional<Condicao> condicao = condicaoService
				.findOneByDescricao(entity.getCondicao().getDescricao());
		entity.setCondicao( !condicao.isPresent() ?
			condicaoService.store(entity.getCondicao()) :
			condicao.get());
		
		entity.setDataModificacao(java.time.LocalDate.now());
		return super.store(entity);
	}
	
}
