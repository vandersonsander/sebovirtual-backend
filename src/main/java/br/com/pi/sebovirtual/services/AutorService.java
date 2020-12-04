package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Autor;
import br.com.pi.sebovirtual.repositories.AutorRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class AutorService extends BaseService<Autor, AutorRepository> {

}
