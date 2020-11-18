package br.com.pi.sebovirtual.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.resource.BaseRepository;

public interface HistoricoAnuncioRepository extends BaseRepository<HistoricoAnuncio> {

	@Query(value = "SELECT MAX(id_anuncio) + 1 AS next_id " + 
	               "FROM historico_anuncio " +
		 	       "WHERE fk_id_usuario = :idUsuario", nativeQuery=true)
	Integer getNextIdAnuncio(int idUsuario);
	
	@Query(
			value="SELECT a FROM HistoricoAnuncio a " +
			"where a.estoque = :query")//*/
	List<HistoricoAnuncio> findQuery(int query);
	
}
