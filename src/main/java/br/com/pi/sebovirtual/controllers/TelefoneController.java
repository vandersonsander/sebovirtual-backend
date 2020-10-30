package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Telefone;
import br.com.pi.sebovirtual.repositories.TelefoneRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.TelefoneService;

@RestController
@RequestMapping("telefone")
public class TelefoneController extends BaseController
	<Telefone, TelefoneRepository, TelefoneService> {

}