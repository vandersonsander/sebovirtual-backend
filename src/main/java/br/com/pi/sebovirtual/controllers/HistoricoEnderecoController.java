package br.com.pi.sebovirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.HistoricoEndereco;
import br.com.pi.sebovirtual.repositories.HistoricoEnderecoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.HistoricoEnderecoService;

@CrossOrigin
@RestController
@RequestMapping("/endereco")
public class HistoricoEnderecoController extends BaseController
	<HistoricoEndereco, HistoricoEnderecoRepository, HistoricoEnderecoService> {
	
	@Autowired
	HistoricoEnderecoRepository enderecoRepository;
	
	@GetMapping("/usuario/{id}")
	public List<HistoricoEndereco> getAddressByUserId(@PathVariable int id) {
		return enderecoRepository.findAllActiveAddressByUserId(id);
	}
	
	@GetMapping("/usuario/principal/{id}")
	public Integer getMainActiveAddressByUser(@PathVariable int id) {
	  return enderecoRepository.findMainActiveAddressByUser(id);
	}
	
	@GetMapping("/usuario/principal-envio/{id}")
	public Integer getMainActiveShippingAddressByUser(@PathVariable int id) {
	  return enderecoRepository.findMainActiveShippingAddressByUser(id);
	}

}
