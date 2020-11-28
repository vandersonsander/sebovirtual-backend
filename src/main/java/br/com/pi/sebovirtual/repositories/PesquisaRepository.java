package br.com.pi.sebovirtual.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.pi.sebovirtual.dto.FilterOccurrencesDTO;
import br.com.pi.sebovirtual.entities.HistoricoAnuncio;

@Repository
@Transactional
public interface PesquisaRepository extends JpaRepository<HistoricoAnuncio, Integer> {
	/**
	 * Pesquisa Geral <br>
	 * pesquisa por: título, descrição, autor, artista e marca de eletcrônicos.
	 * Além de que o anúncio precisa de estar ativo e não ter sido editado
	 * e ainda possuir estoque
	 * 
	 * @param query
	 * @param categoria
	 * @param pageable
	 * @return
	 */
	String queryJoin = " FROM HistoricoAnuncio a "
			+ "JOIN a.produto pd " 
			+ "LEFT OUTER JOIN a.produto.autores au "
			+ "LEFT OUTER JOIN a.condicao c "
			+ "WHERE (pd.titulo LIKE %?1% "
			+ "OR a.titulo LIKE %?1% "
			+ "OR a.descricao LIKE %?1% "
			+ "OR CONCAT(au.nome, ' ', au.sobrenome) LIKE %?1% "
			+ "OR pd.artista LIKE %?1% "
			+ "OR pd.marca IN (SELECT m FROM Marca m WHERE m.nome LIKE %?1%)) "
			+ "AND a.status IN (SELECT st FROM Status st WHERE st.id = 1) "
			+ "AND a.estoque > 0 "
			+ "AND pd.categoria LIKE %?2% "
			+ "AND c.descricao LIKE %?3% "
			+ "AND (a.preco >= ?4 AND a.preco <= ?5)";
	@Query(value = "SELECT a " + queryJoin)
	Page<HistoricoAnuncio> searchByQuery(
			String query, 
			String categoria, 
			String condicao,
			Double precoMin,
			Double precoMax,
			Pageable pageable);
	
	/**
	 * Filtros pesquisa geral
	 * @return
	 */
	@Query(value = ""
			+ "SELECT "
			+ "new br.com.pi.sebovirtual.dto.FilterOccurrencesDTO(c.descricao, COUNT(c.descricao)) "
			+ queryJoin
			+ "GROUP BY c.descricao ")
	List<FilterOccurrencesDTO> generateFiltersDescricao(
			String query,
			String categoria, 
			String condicao,
			Double precoMin,
			Double precoMax);
	
	@Query(value = ""
			+ "SELECT "
			+ "new br.com.pi.sebovirtual.dto.FilterOccurrencesDTO(pd.categoria, COUNT(pd.categoria)) "
			+ queryJoin
			+ "GROUP BY pd.categoria ")
	List<FilterOccurrencesDTO> generateFiltersCategoria(
			String query,
			String categoria, 
			String condicao,
			Double precoMin,
			Double precoMax);
	
	/*@Query(value = ""
			+ "SELECT "
			+ "new br.com.pi.sebovirtual.dto.FilterOccurrencesDTO(c.descricao, COUNT(c.descricao)) "
			+ queryJoin
			+ "GROUP BY c.descricao ")
	List<FilterOccurrencesDTO> generateFiltersEstado(
			String query,
			String categoria, 
			String condicao,
			Double precoMin,
			Double precoMax);*/
}
