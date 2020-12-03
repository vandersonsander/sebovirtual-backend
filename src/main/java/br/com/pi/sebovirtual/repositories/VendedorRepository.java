package br.com.pi.sebovirtual.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pi.sebovirtual.dto.FilterOccurrencesDTO;
import br.com.pi.sebovirtual.entities.Usuario;

public interface VendedorRepository extends JpaRepository<Usuario, Integer> {
	
	String query = ""
			+ "FROM Usuario u, HistoricoEndereco e "
			+ "WHERE u IN (SELECT h.usuario "
			+ "FROM HistoricoAnuncio h "
			+ "WHERE h.status IN "
			+ "(SELECT s FROM Status s "
			+ "WHERE s.nome = 'ativo')) "
			+ "AND u = e.usuario "
			+ "AND e.principalParaEnvio = true "
			+ "AND e.estado IN :estado "
			+ "AND e.cidade IN :cidade ";
	@Query("SELECT u  "
			+ query)
	Page<Usuario> getAll(
			List<String> estado,
			List<String> cidade,
			Pageable pageable);
	
	@Query("SELECT u "
			+ query
			+ "AND u.id = :id ")
	Optional<Usuario> findOne(Integer id);
	
	/* Filtros */
	@Query(value = "SELECT new br.com.pi.sebovirtual.dto.FilterOccurrencesDTO(e.estado, count(e.estado)) "
			+ query
			+ "GROUP BY e.estado")
	List<FilterOccurrencesDTO> generateFiltersEstado(
			List<String> estado,
			List<String> cidade);
	
	@Query(value = "SELECT new br.com.pi.sebovirtual.dto.FilterOccurrencesDTO(e.cidade, count(e.cidade)) "
			+ query
			+ "GROUP BY e.cidade")
	List<FilterOccurrencesDTO> generateFiltersCidade(
			List<String> estado,
			List<String> cidade);
}
