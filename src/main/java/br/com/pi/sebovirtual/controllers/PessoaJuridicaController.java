package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.PessoaJuridica;
import br.com.pi.sebovirtual.repositories.PessoaJuridicaRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.PessoaJuridicaService;

@CrossOrigin
@RestController
@RequestMapping("pessoajuridica")
public class PessoaJuridicaController extends BaseController
	<PessoaJuridica, PessoaJuridicaRepository, PessoaJuridicaService> {

}