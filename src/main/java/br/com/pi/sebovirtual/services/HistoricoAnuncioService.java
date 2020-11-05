package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.repositories.HistoricoAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class HistoricoAnuncioService
	extends BaseService<HistoricoAnuncio, HistoricoAnuncioRepository> {

	public HistoricoAnuncio store(HistoricoAnuncio entity) {
		entity.setDataModificacao(java.time.LocalDate.now());
		return super.store(entity);
	}
	
}