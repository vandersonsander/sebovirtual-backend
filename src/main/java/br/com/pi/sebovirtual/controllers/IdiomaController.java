package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Idioma;
import br.com.pi.sebovirtual.repositories.IdiomaRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.IdiomaService;

@RestController
@RequestMapping("idioma")
public class IdiomaController extends BaseController
	<Idioma, IdiomaRepository, IdiomaService> {

}
