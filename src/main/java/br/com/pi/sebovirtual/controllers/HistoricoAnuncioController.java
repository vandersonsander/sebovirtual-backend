package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.repositories.HistoricoAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.HistoricoAnuncioService;

@RestController
@RequestMapping("historico-anuncio")
public class HistoricoAnuncioController extends BaseController
	<HistoricoAnuncio, HistoricoAnuncioRepository, HistoricoAnuncioService> {

}
