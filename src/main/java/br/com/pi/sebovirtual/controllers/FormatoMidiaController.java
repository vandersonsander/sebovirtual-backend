package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.FormatoMidia;
import br.com.pi.sebovirtual.repositories.FormatoMidiaRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.FormatoMidiaService;

@RestController
@RequestMapping("formatomidia")
public class FormatoMidiaController extends BaseController
	<FormatoMidia, FormatoMidiaRepository, FormatoMidiaService> {

}