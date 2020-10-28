package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Imagem;
import br.com.pi.sebovirtual.repositories.ImagemRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class ImagemService extends BaseService<Imagem, ImagemRepository> {

}
