package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Eletronico;
import br.com.pi.sebovirtual.repositories.EletronicoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.EletronicoService;

@RestController
@RequestMapping("eletronico")
public class EletronicoController extends BaseController
	<Eletronico, EletronicoRepository, EletronicoService> {

}