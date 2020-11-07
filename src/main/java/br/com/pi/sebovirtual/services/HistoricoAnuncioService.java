package br.com.pi.sebovirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.repositories.HistoricoAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseService;
import br.com.pi.sebovirtual.util.Utils;

@Service
public class HistoricoAnuncioService
	extends BaseService<HistoricoAnuncio, HistoricoAnuncioRepository> {
	@Autowired
	private HistoricoAnuncioRepository anuncioRepository;

	@Override
	public HistoricoAnuncio store(HistoricoAnuncio anuncio) {
		Integer idAnuncio = anuncioRepository.getNextIdAnuncio();
		// Se o ID é igual a null
		// significa que está cadastrando um novo anúncio
		if (anuncio.getId() == null) 
			anuncio.setIdAnuncio(
					idAnuncio == null ? 1 : idAnuncio
			);
		anuncio.setDataModificacao(java.time.LocalDate.now());
		return super.store(anuncio);
	}

	@Override
	public HistoricoAnuncio update(Integer id, HistoricoAnuncio anuncio) {
		HistoricoAnuncio current = super.getOne(id);
		// O idAnuncio nunca muda
		anuncio.setIdAnuncio(current.getIdAnuncio());
		
		// Se houver pedidos relacionados cria um novo
		// anúncio mantento o mesmo "idAnuncio"
		if (current.getItens() != null &&
				!current.getItens().isEmpty()) {
			Utils.updateProperties(anuncio, current, true);
			Utils.updateProperties(current, anuncio, true);
			return super.store(anuncio);
		}
		
		return super.update(id, anuncio);
	}
	
}
