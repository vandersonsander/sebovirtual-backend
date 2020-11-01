package br.com.pi.sebovirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Status;
import br.com.pi.sebovirtual.repositories.StatusRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class StatusService extends BaseService<Status, StatusRepository>{
	@Autowired
	private StatusRepository repository;
	public Optional<Status> findOneByNome(String nome) {
		return repository.findOneByNome(nome); 
	}
}
