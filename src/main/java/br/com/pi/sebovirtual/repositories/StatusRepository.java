package br.com.pi.sebovirtual.repositories;

import java.util.Optional;

import br.com.pi.sebovirtual.entities.Status;
import br.com.pi.sebovirtual.resource.BaseRepository;

public interface StatusRepository extends BaseRepository<Status> {
	Optional<Status> findOneByNome(String status);
}
