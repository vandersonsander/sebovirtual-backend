package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Genero;
import br.com.pi.sebovirtual.repositories.GeneroRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.GeneroService;

@RestController
@RequestMapping("genero")
public class GeneroController extends BaseController
	<Genero, GeneroRepository, GeneroService> {

}
