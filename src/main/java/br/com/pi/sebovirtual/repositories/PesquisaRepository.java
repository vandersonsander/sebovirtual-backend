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
	 * Resultados da página inicial 
	 */
	@Query("SELECT p.historicoAnuncio "
			+ "FROM PedidoTemAnuncio p "
			+ "GROUP BY p.historicoAnuncio "
			+ "ORDER BY COUNT(p.historicoAnuncio) DESC")
	Page<HistoricoAnuncio> getMaisVendidos(Pageable pageable);
	
	@Query("SELECT a "
			+ "FROM HistoricoAnuncio a ")
	Page<HistoricoAnuncio> getMaisPopulares(Pageable pageable);
	
	@Query("SELECT a "
			+ "FROM HistoricoAnuncio a "
			+ "WHERE a.status IN (SELECT st FROM Status st WHERE st.id = 1)")
	Page<HistoricoAnuncio> getMaisRecentes(Pageable pageable);
	
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
			+ "WHERE (pd.titulo LIKE %:query% "
			+ "OR a.titulo LIKE %:query% "
			+ "OR a.descricao LIKE %:query% "
			+ "OR CONCAT(au.nome, ' ', au.sobrenome) LIKE %:query% "
			+ "OR pd.artista LIKE %:query% "
			+ "OR pd.marca IN (SELECT m FROM Marca m WHERE m.nome LIKE %:query%)) "
			+ "AND a.status IN (SELECT st FROM Status st WHERE st.id = 1) "
			+ "AND a.estoque > 0 "
			+ "AND pd.categoria IN :categoria "
			+ "AND c.descricao IN :condicao "
			+ "AND (a.preco >= :precoMin AND a.preco <= :precoMax)";
	@Query(value = "SELECT DISTINCT a " + queryJoin)
	Page<HistoricoAnuncio> searchByQuery(
			String query, 
			List<String> categoria, 
			String[] condicao,
			Double precoMin,
			Double precoMax,
			Pageable pageable);
	
	/**
	 * Filtros pesquisa geral
	 * @return
	 */
	@Query(value = ""
			+ "SELECT new br.com.pi.sebovirtual.dto.FilterOccurrencesDTO(c.descricao, COUNT(c.descricao)) "
			+ queryJoin
			+ "GROUP BY c.descricao ")
	List<FilterOccurrencesDTO> generateFiltersDescricao(
			String query,
			List<String> categoria, 
			String[] condicao,
			Double precoMin,
			Double precoMax);
	
	@Query(value = ""
			+ "SELECT "
			+ "new br.com.pi.sebovirtual.dto.FilterOccurrencesDTO(pd.categoria, COUNT(pd.categoria)) "
			+ queryJoin
			+ "GROUP BY pd.categoria ")
	List<FilterOccurrencesDTO> generateFiltersCategoria(
			String query,
			List<String> categoria, 
			String[] condicao,
			Double precoMin,
			Double precoMax);
	
	/* Verificar porque retorna resultado errado */
	/*@Query(value = ""
			+ "SELECT "
			+ "new br.com.pi.sebovirtual.dto.FilterOccurrencesDTO(en.estado, COUNT(en.estado)) "
			+ queryJoin
			+ " GROUP BY en.estado ")
	List<FilterOccurrencesDTO> generateFiltersEstado(
			String query,
			String categoria, 
			String condicao,
			Double precoMin,
			Double precoMax);*/
	
	/* Filtros Livros */
}
