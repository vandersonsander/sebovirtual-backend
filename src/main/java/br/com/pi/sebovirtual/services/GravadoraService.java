package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Gravadora;
import br.com.pi.sebovirtual.repositories.GravadoraRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class GravadoraService extends BaseService
	<Gravadora, GravadoraRepository> {

}
