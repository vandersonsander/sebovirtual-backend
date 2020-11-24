package br.com.pi.sebovirtual.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;

@Repository
@Transactional
public interface PesquisaMeusFavoritosRepository extends 
	JpaRepository<HistoricoAnuncio, Integer> {
	/**
	 * Pesquisa todos os anúncios favoritos de um usuário.
	 * 
	 * @param query Query de pesquisa.
	 * @param userId Id do usuário.
	 * @param pageable Informação de paginação.
	 * @return
	 */
	String query = "SELECT * FROM Historico_Anuncio " +
				   "WHERE id IN " +
                   "(SELECT fk_id_anuncio FROM Usuario_favorita_Anuncio " +
                   "WHERE fk_id_usuario = ?1)";	
	@Query(value = query, nativeQuery = true)
	Page<HistoricoAnuncio> searchByQuery(int userId, Pageable pageable);
	
}
