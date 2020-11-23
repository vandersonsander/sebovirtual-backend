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
public interface PesquisaMeusAnunciosRepository extends JpaRepository<HistoricoAnuncio, Integer> {
	/**
	 * Pesquisa todos os anúncios ativos de um usuário com estoque.
	 * 
	 * @param query Query de pesquisa.
	 * @param userId Id do usuário.
	 * @param pageable 
	 * @return
	 */
	String queryJoin = "FROM HistoricoAnuncio a "
			+ "WHERE a.usuario.id = ?1 "
			+ "AND a.estoque > 0 "
			+ "AND a.status IN (SELECT st FROM Status st WHERE st.id = 1) ";
	@Query(value = "SELECT a " + queryJoin)
	Page<HistoricoAnuncio> searchByQuery(
			int userId, 
			Pageable pageable);
	
}
