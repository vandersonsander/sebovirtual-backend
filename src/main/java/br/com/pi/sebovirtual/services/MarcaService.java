package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Marca;
import br.com.pi.sebovirtual.repositories.MarcaRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class MarcaService extends BaseService
	<Marca, MarcaRepository> {

}
