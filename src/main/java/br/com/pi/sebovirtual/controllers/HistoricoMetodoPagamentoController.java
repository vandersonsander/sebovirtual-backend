package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.HistoricoMetodoPagamento;
import br.com.pi.sebovirtual.repositories.HistoricoMetodoPagamentoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.HistoricoMetodoPagamentoService;

@RestController
@RequestMapping("/pagamento")
public class HistoricoMetodoPagamentoController extends BaseController
	<HistoricoMetodoPagamento, HistoricoMetodoPagamentoRepository, HistoricoMetodoPagamentoService> {

}
