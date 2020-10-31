package br.com.pi.sebovirtual.repositories;

import java.util.Optional;

import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.resource.BaseRepository;


public interface UsuarioRepository extends BaseRepository<Usuario>{

	Usuario findOneByEmail(String email);
	Optional<Usuario> findByEmail(String email);

}
