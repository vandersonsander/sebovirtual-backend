package br.com.pi.sebovirtual.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.dto.LoginDTO;
import br.com.pi.sebovirtual.dto.PessoaFisicaDTO;
import br.com.pi.sebovirtual.entities.PessoaFisica;
import br.com.pi.sebovirtual.repositories.PessoaFisicaRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.PessoaFisicaService;
import br.com.pi.sebovirtual.services.UsuarioServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("pessoafisica")
public class PessoaFisicaController extends BaseController
	<PessoaFisica, PessoaFisicaRepository, PessoaFisicaService> {
	
	@Autowired
	private PessoaFisicaService pessoaFisicaService;
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@PostMapping("/cadastro")
	@Transactional
	public ResponseEntity<?> cadastrarPessoaFisica(@Valid @RequestBody PessoaFisica pessoaFisica)
			throws Exception {
		
		// Obtém a senha não criptogradada ainda
		String senhaNaoCriptografada = pessoaFisica.getSenha();
		
		// Cria a pessoa física
		PessoaFisica pessoaFisicaCurrent = pessoaFisicaService.store(pessoaFisica);
		
		// Faz o login
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setEmail(pessoaFisica.getEmail());
		loginDTO.setSenha(senhaNaoCriptografada);
		String token = usuarioServiceImpl.login(loginDTO);
			
		// Monta a resposta
		PessoaFisicaDTO pessoaFisicaDTO = new PessoaFisicaDTO();
		pessoaFisicaDTO = new PessoaFisicaDTO();
		pessoaFisicaDTO.setUsuario(pessoaFisicaCurrent);
		pessoaFisicaDTO.setToken(token);

		// Retorna o usuário e o token
		return ResponseEntity.ok(pessoaFisicaDTO); 
	}
	
}