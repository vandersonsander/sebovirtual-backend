package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Legenda;
import br.com.pi.sebovirtual.repositories.LegendaRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class LegendaService extends BaseService
	<Legenda, LegendaRepository> {

}
