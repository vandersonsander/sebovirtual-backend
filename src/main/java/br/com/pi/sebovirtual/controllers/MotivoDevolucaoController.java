package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Subcategoria;
import br.com.pi.sebovirtual.repositories.SubcategoriaRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.SubcategoriaService;

@RestController
@RequestMapping("motivo-devolucao")
public class MotivoDevolucaoController extends BaseController
	<Subcategoria, SubcategoriaRepository, SubcategoriaService> {

}