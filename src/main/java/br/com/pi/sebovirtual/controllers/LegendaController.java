package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Legenda;
import br.com.pi.sebovirtual.repositories.LegendaRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.LegendaService;

@RestController
@RequestMapping("legenda")
public class LegendaController extends BaseController
	<Legenda, LegendaRepository, LegendaService> {

}