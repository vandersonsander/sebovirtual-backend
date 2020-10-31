package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Midia;
import br.com.pi.sebovirtual.repositories.MidiaRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class MidiaService extends BaseService
	<Midia, MidiaRepository> {

}
