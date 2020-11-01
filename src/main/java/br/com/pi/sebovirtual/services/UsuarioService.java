package br.com.pi.sebovirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.UsuarioRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Usuario> findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	@Override
	public Usuario store(Usuario entity) {
		System.out.println("store");
		return super.store(entity);
	}

	@Override
	public Usuario update(Integer id, Usuario entity) {
		System.out.println("update");
		return super.update(id, entity);
	}
	
	
}
