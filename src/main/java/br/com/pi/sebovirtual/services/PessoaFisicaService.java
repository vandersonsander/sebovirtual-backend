package br.com.pi.sebovirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.pi.sebovirtual.entities.PessoaFisica;
import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.PessoaFisicaRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class PessoaFisicaService extends BaseService<PessoaFisica, PessoaFisicaRepository> {
	@Autowired
	private PessoaFisicaRepository pessoaFisicaRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public PessoaFisica store(PessoaFisica pessoaFisica) {
		// Verifica se o CPF já existe
		if (pessoaFisica.getId() == null &&
				pessoaFisica.getCpf() != null &&
				checkCPFExists(pessoaFisica.getCpf()))
			throw new ResponseStatusException(
					HttpStatus.FORBIDDEN, "CPF já cadastrado");
				
		Usuario usuario = usuarioService.store(pessoaFisica);
		pessoaFisica.setSenha(usuario.getSenha());
		pessoaFisica.setEmail(usuario.getEmail());
		pessoaFisica.setFavoritos(usuario.getFavoritos());
		return super.store(pessoaFisica);
	}
	
	@Override
	public PessoaFisica update(Integer id, PessoaFisica pessoaFisica) {
		Usuario usuario = usuarioService.update(id, pessoaFisica);
		// Valida senha e email de usuário
		pessoaFisica.setSenha(usuario.getSenha());
		pessoaFisica.setEmail(usuario.getEmail());
		pessoaFisica.setFavoritos(usuario.getFavoritos());
		System.out.println("Favoritos adicionados: " + pessoaFisica.getFavoritos().size() );
		
		return super.update(id, pessoaFisica);
	}
	
	public Boolean checkCPFExists(String CPF) {
		return pessoaFisicaRepository.findOneByCpf(CPF).isPresent();
	}
}
