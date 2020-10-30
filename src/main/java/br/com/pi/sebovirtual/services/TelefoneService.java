package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Telefone;
import br.com.pi.sebovirtual.repositories.TelefoneRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class TelefoneService extends BaseService<Telefone, TelefoneRepository>{

}
