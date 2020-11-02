package br.com.pi.sebovirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.PessoaJuridica;
import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.PessoaJuridicaRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class PessoaJuridicaService extends BaseService<PessoaJuridica, PessoaJuridicaRepository> {
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public PessoaJuridica store(PessoaJuridica pessoaJuridica) {
		Usuario usuario = usuarioService.store(pessoaJuridica);
		pessoaJuridica.setSenha(usuario.getSenha());
		pessoaJuridica.setEmail(usuario.getEmail());
		return super.store(pessoaJuridica);
	}
	
	@Override
	public PessoaJuridica update(Integer id, PessoaJuridica pessoaJuridica) {
		Usuario usuario = usuarioService.update(id, pessoaJuridica);
		// A lógica da criptografia de senha fica em UsuarioService
		pessoaJuridica.setSenha(usuario.getSenha());
		// A validação de email também fica em UsuarioService
		pessoaJuridica.setEmail(usuario.getEmail());
		return super.update(id, pessoaJuridica);
	}
}