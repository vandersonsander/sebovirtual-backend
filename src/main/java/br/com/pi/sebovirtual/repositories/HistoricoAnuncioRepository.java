package br.com.pi.sebovirtual.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.entities.Status;
import br.com.pi.sebovirtual.resource.BaseRepository;

public interface HistoricoAnuncioRepository extends BaseRepository<HistoricoAnuncio> {

	@Query(value = "SELECT MAX(id_anuncio) + 1 AS next_id " + 
	               "FROM historico_anuncio " +
		 	       "WHERE fk_id_usuario = :idUsuario", nativeQuery=true)
	public Integer getNextIdAnuncio(int idUsuario);
	
	@Query(
			value="SELECT a FROM HistoricoAnuncio a " +
			"where a.estoque = :query")//*/
	public List<HistoricoAnuncio> findQuery(int query);
	
	/**
	 * Retorna apenas os anúncios ativos de um usuário com estoque maior que zero.
	 * @param idUsuario Id do usuário.
	 * @return Anúncios ativos desse usuário.
	 */
	@Query(value="SELECT * FROM Historico_Anuncio " +
			     "WHERE fk_id_usuario = :id AND estoque > 0 " + 
			     "AND fk_id_status IN " +
			     "(SELECT id from Status WHERE nome = '" + 
			     Status.ATIVO + "')", nativeQuery = true)
	public List<HistoricoAnuncio> findAllActiveAdsByUserId(int id);
	
	
}
