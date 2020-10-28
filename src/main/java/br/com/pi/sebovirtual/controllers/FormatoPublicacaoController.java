package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.FormatoPublicacao;
import br.com.pi.sebovirtual.repositories.FormatoPublicacaoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.FormatoPublicacaoService;

@RestController
@RequestMapping("formato-publicacao")
public class FormatoPublicacaoController
	extends BaseController<FormatoPublicacao, FormatoPublicacaoRepository,
		FormatoPublicacaoService> {

}
