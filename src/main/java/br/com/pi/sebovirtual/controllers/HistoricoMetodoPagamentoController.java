package br.com.pi.sebovirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.HistoricoMetodoPagamento;
import br.com.pi.sebovirtual.repositories.HistoricoMetodoPagamentoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.HistoricoMetodoPagamentoService;

@CrossOrigin
@RestController
@RequestMapping("/pagamento")
public class HistoricoMetodoPagamentoController extends BaseController
	<HistoricoMetodoPagamento, HistoricoMetodoPagamentoRepository, HistoricoMetodoPagamentoService> {

	@Autowired
	HistoricoMetodoPagamentoRepository metodoPagamentoRepository;
	
	@GetMapping("/usuario/{id}")
	public List<HistoricoMetodoPagamento> getPaymentMethodsByUserId(@PathVariable int id) {
		return metodoPagamentoRepository.findAllActivePaymentsMethodsByUserId(id);
	}

}
