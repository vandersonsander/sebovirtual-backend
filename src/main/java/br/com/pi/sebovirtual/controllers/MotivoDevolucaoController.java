package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.MotivoDevolucao;
import br.com.pi.sebovirtual.repositories.MotivoDevolucaoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.MotivoDevolucaoService;

@RestController
@RequestMapping("motivo-devolucao")
public class MotivoDevolucaoController extends BaseController
	<MotivoDevolucao, MotivoDevolucaoRepository, MotivoDevolucaoService> {

}