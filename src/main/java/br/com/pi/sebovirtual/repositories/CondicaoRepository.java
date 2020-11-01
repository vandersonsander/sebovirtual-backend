package br.com.pi.sebovirtual.repositories;

import java.util.Optional;

import br.com.pi.sebovirtual.entities.Condicao;
import br.com.pi.sebovirtual.resource.BaseRepository;

public interface CondicaoRepository extends BaseRepository<Condicao> {
	
	Optional<Condicao> findOneByDescricao(String descricao);
}
