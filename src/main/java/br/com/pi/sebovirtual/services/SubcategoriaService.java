package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Subcategoria;
import br.com.pi.sebovirtual.repositories.SubcategoriaRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class SubcategoriaService extends BaseService
	<Subcategoria, SubcategoriaRepository> {

}
