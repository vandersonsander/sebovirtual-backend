package br.com.pi.sebovirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Condicao;
import br.com.pi.sebovirtual.repositories.CondicaoRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class CondicaoService extends BaseService<Condicao, CondicaoRepository> {
	@Autowired
	private CondicaoRepository repository;
	
	public Optional<Condicao> findOneByDescricao(String descricao) {
		return repository.findOneByDescricao(descricao);
	}
}
