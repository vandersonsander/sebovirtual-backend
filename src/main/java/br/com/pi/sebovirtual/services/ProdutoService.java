package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Produto;
import br.com.pi.sebovirtual.repositories.ProdutoRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class ProdutoService extends BaseService<Produto, ProdutoRepository> {
	

}
