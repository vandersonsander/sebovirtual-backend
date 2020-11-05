package br.com.pi.sebovirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.repositories.HistoricoAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseService;

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

	/*@Override
	public HistoricoAnuncio update(Integer id, HistoricoAnuncio anuncio) {
		if (anuncio.getP)
		return super.update(id, anuncio);
	}//*/
	
}
