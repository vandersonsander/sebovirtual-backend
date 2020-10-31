package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Gravadora;
import br.com.pi.sebovirtual.repositories.GravadoraRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.GravadoraService;

@RestController
@RequestMapping("gravadora")
public class GravadoraController extends BaseController
	<Gravadora, GravadoraRepository, GravadoraService> {

}