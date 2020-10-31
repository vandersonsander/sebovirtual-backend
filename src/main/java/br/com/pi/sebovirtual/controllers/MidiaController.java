package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Midia;
import br.com.pi.sebovirtual.repositories.MidiaRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.MidiaService;

@RestController
@RequestMapping("midia")
public class MidiaController extends BaseController
	<Midia, MidiaRepository, MidiaService> {

}