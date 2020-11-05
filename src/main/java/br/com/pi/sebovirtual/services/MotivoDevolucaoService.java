package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.MotivoDevolucao;
import br.com.pi.sebovirtual.repositories.MotivoDevolucaoRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class MotivoDevolucaoService extends BaseService
	<MotivoDevolucao, MotivoDevolucaoRepository> {

}
