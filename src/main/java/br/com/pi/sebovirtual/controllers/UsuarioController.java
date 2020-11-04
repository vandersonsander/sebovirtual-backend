package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.UsuarioRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("usuario")
public class UsuarioController extends BaseController<Usuario, UsuarioRepository, UsuarioService> {

}