package br.com.pi.sebovirtual.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.dto.JwtResponseDTO;
import br.com.pi.sebovirtual.dto.LoginDTO;
import br.com.pi.sebovirtual.services.UsuarioServiceImpl;
import io.swagger.annotations.Api;


@RestController
@CrossOrigin
@Api(tags = "Login", description = "Autenticações do usuário")
public class LoginController {
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody LoginDTO loginDTO)
			throws Exception {
		String token = usuarioServiceImpl.login(loginDTO);
		return ResponseEntity.ok(new JwtResponseDTO(token)); // retorna para o usuário o token
	}
}
