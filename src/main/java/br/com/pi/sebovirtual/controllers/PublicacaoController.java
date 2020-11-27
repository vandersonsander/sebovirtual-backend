package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Publicacao;
import br.com.pi.sebovirtual.repositories.PublicacaoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.PublicacaoService;

@CrossOrigin
@RestController
@RequestMapping("publicacao")
public class PublicacaoController extends BaseController<Publicacao, PublicacaoRepository,
	PublicacaoService> {
	
}
