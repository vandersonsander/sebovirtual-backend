package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.FormatoMidia;
import br.com.pi.sebovirtual.repositories.FormatoMidiaRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class FormatoMidiaService extends BaseService
	<FormatoMidia, FormatoMidiaRepository> {

}
