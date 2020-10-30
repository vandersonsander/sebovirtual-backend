package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.TipoMetodoPagamento;
import br.com.pi.sebovirtual.repositories.TipoMetodoPagamentoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.TipoMetodoPagamentoService;

@RestController
@RequestMapping("/tipo_metodo_pagamento")
public class TipoMetodoPagamentoController extends BaseController
	<TipoMetodoPagamento, TipoMetodoPagamentoRepository, TipoMetodoPagamentoService> {

}