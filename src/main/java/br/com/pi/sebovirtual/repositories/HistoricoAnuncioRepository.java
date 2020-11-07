package br.com.pi.sebovirtual.repositories;

import org.springframework.data.jpa.repository.Query;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.resource.BaseRepository;

public interface HistoricoAnuncioRepository extends BaseRepository<HistoricoAnuncio> {
	@Query(
			value = "SELECT MAX(id_anuncio) + 1 AS next_id" +
					" FROM historico_anuncio",
			nativeQuery=true)
	Integer getNextIdAnuncio();
	
}
