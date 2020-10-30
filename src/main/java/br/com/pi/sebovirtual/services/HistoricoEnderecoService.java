package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.HistoricoEndereco;
import br.com.pi.sebovirtual.repositories.HistoricoEnderecoRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class HistoricoEnderecoService 
	extends BaseService<HistoricoEndereco, HistoricoEnderecoRepository> {

}
