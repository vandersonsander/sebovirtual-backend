package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Imagem;
import br.com.pi.sebovirtual.repositories.ImagemRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.ImagemService;

@RestController
@RequestMapping("imagem")
public class ImagemController extends BaseController
	<Imagem, ImagemRepository, ImagemService>{

}
