package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Marca;
import br.com.pi.sebovirtual.repositories.MarcaRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.MarcaService;

@RestController
@RequestMapping("marca")
public class MarcaController extends BaseController
<Marca, MarcaRepository, MarcaService> {

}