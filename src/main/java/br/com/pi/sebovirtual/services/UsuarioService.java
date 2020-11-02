package br.com.pi.sebovirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.UsuarioRepository;
import br.com.pi.sebovirtual.resource.BaseService;
import br.com.pi.sebovirtual.util.PasswordUtils;
import br.com.pi.sebovirtual.util.Utils;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Usuario> findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	@Override
	public Usuario store(Usuario entity) {
		// Verifica se já não há criptografia
		if (!PasswordUtils.checksIfPasswordIsEncrypted(entity.getSenha()))
			entity.setSenha(
					PasswordUtils.encriptyPassword(entity.getSenha()));
		return super.store(entity);
	}
	
	public Usuario update(Integer id, Usuario entity) {
		Usuario current = super.getOne(id);
		entity.setId(id);
		
		// Verifica se o email que o usuario
		// Pretende atualizar já existe
		if (entity.getEmail() != null &&
				!entity.getEmail().equals(current.getEmail()) &&
				emailExists(entity.getEmail()))
			throw new ResponseStatusException(
					HttpStatus.FORBIDDEN, "Email já existe");
		
		// Compara com a senha atual
		if (PasswordUtils.comparesPassword(
				entity.getSenha(),
				current.getSenha()))
			entity.setSenha(current.getSenha());
		
		Utils.updateProperties(entity, current, true);
		return this.store(current);
	}
	
	public Boolean emailExists(String email) {
		return findByEmail(email).isPresent();
	}
}
