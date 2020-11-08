package br.com.pi.sebovirtual.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.resource.BaseRepository;


public interface UsuarioRepository extends BaseRepository<Usuario>{

	Usuario findOneByEmail(String email);
	Optional<Usuario> findByEmail(String email);
	
	/**
	 * Retorna todos anúncios favoritados pelo usuário.
	 * @param id Id do usuário.
	 * @return Lista de anúncios favoritados pelo usuário.
	 */
	String query = "SELECT * FROM Historico_Anuncio " +
			        "WHERE id IN " +
			        "(SELECT fk_id_anuncio FROM Usuario_favorita_Anuncio " +
			        "WHERE fk_id_usuario = :id)";	
	@Query(value = query, nativeQuery = true)
	List<Object[]> findFavoritesAds(int id);
	
}
