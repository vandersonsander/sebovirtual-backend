package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Produto;
import br.com.pi.sebovirtual.repositories.ProdutoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.ProdutoService;

@RestController
@CrossOrigin
@RequestMapping("produto")
public class ProdutoController extends BaseController
	<Produto, ProdutoRepository, ProdutoService> {

}
