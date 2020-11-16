package br.com.pi.sebovirtual.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.dto.AlterarSenhaDTO;
import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.services.UsuarioService;
import io.swagger.annotations.Api;


@RestController
@CrossOrigin
@Api(tags = {"Alterar senha", "Senha"})
public class AlterarSenhaController {

	@Autowired
	private UsuarioService usuarioService;

	@PutMapping("/alterarsenha/{id}")
	public Usuario alterarSenhaUsuario(@PathVariable int id, 
		@RequestBody AlterarSenhaDTO alterarSenhaDTO)
			throws Exception {
		Usuario usuario = usuarioService.alterarSenha(id, alterarSenhaDTO);
		return usuario; 
	}
}
