package br.com.pi.sebovirtual.repositories;

import java.util.Optional;

import br.com.pi.sebovirtual.entities.PessoaFisica;
import br.com.pi.sebovirtual.resource.BaseRepository;

public interface PessoaFisicaRepository extends BaseRepository<PessoaFisica> {
	Optional<PessoaFisica> findOneByCpf(String CPF);
}
