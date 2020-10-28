package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Publicacao;
import br.com.pi.sebovirtual.repositories.PublicacaoRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class PublicacaoService extends BaseService<Publicacao, PublicacaoRepository> {

}
