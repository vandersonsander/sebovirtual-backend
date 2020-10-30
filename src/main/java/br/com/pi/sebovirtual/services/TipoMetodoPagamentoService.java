package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.TipoMetodoPagamento;
import br.com.pi.sebovirtual.repositories.TipoMetodoPagamentoRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class TipoMetodoPagamentoService extends BaseService
	<TipoMetodoPagamento, TipoMetodoPagamentoRepository>{

}
