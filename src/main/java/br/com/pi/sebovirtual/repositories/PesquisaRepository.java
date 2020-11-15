package br.com.pi.sebovirtual.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;

public interface PesquisaRepository extends JpaRepository<HistoricoAnuncio, Integer> {
	/**
	 * Pesquisa Geral <br>
	 * pesquisa por: título, descrição, autor, artista e marca de eletrônicos.
	 * Além de que o anúncio precisa de estar ativo e não ter sido editado
	 * e ainda possuir estoque
	 * 
	 * @param query
	 * @param categoria
	 * @param pageable
	 * @return
	 */
	@Query(value = 	"SELECT * FROM Historico_Anuncio a " +
			"JOIN Produto pd " +
			"ON a.fk_id_produto =  pd.id " +
			"LEFT OUTER JOIN Publicacao_tem_autor pbau " +
			"ON pbau.fk_id_produto = a.id " +
			"LEFT OUTER JOIN Autor au " +
			"ON pbau.fk_id_autor = au.id " +
			"LEFT OUTER JOIN Midia md " +
			"ON pd.id = md.id " +
			"LEFT OUTER JOIN Eletronico el " +
			"ON pd.id = el.id " +
			"WHERE (pd.titulo LIKE %?1% " +
			"OR a.titulo LIKE %?1% " +
			"OR a.descricao LIKE %?1% " +
			"OR CONCAT(au.nome, ' ', au.sobrenome) LIKE %?1% " +
			"OR md.artista LIKE %?1% " + 
			"OR el.fk_id_marca IN (SELECT id FROM Marca WHERE nome LIKE %?1%)) " + 
			"AND a.fk_id_status = 1 " +
			"AND a.estoque > 0 " + 
			"AND pd.categoria LIKE %?2% ",
			nativeQuery = true)
	Page<HistoricoAnuncio> searchByQuery(String query, String categoria, Pageable pageable);
}
