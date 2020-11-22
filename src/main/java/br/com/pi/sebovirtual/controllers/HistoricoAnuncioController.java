package br.com.pi.sebovirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.repositories.HistoricoAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.HistoricoAnuncioService;

@RestController
@CrossOrigin
@RequestMapping("anuncio")
public class HistoricoAnuncioController extends BaseController
	<HistoricoAnuncio, HistoricoAnuncioRepository, HistoricoAnuncioService> {
	
	@Autowired
	HistoricoAnuncioRepository repository;
	
	@GetMapping("/usuario/{id}")
	public List<HistoricoAnuncio> getAllActiveAdsByUserId(@PathVariable int id) {
	  return repository.findAllActiveAdsByUserId(id);
	}
}
