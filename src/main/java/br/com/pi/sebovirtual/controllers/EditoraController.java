package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Editora;
import br.com.pi.sebovirtual.repositories.EditoraRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.EditoraService;

@RestController
@RequestMapping("editora")
public class EditoraController extends BaseController
	<Editora, EditoraRepository, EditoraService> {

}
