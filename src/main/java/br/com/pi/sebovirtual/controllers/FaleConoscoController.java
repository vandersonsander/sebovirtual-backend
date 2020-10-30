package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.FaleConosco;
import br.com.pi.sebovirtual.repositories.FaleConoscoRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.FaleConoscoService;

@RestController
@RequestMapping("faleconosco")
public class FaleConoscoController extends BaseController<FaleConosco, FaleConoscoRepository, FaleConoscoService> {

}
