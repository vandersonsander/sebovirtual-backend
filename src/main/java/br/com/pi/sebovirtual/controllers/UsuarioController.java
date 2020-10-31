package br.com.pi.sebovirtual.controllers;

import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.UsuarioRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.UsuarioService;
import javassist.NotFoundException;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends BaseController<Usuario, UsuarioRepository, UsuarioService> {
	
	@Autowired // Adicionar só se quiser sobrescrever o padrão crud
	private UsuarioService usuarioService;
	
	@PostMapping
	// Sobrescreve o padrão crud e impede que o usuário coloque a própria autoridade
	public ResponseEntity<Usuario> store(@Valid @RequestBody Usuario usuario) {
		/*usuario.setHabilitado(true);
		usuario.setAutoridade("USUARIO");*/
		// Verifica se a senha está criptografada
		// senão salva a senha criptografada
		usuario.setSenha(usuario.getSenha(), usuario);
		Usuario newUsuario = usuarioService.store(usuario);
		System.out.println("AQUI_USUARIO_controller");
		return ResponseEntity.ok(newUsuario);
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<Usuario> update(@Valid @PathVariable Integer id, 
			@RequestBody Usuario usuario) throws Exception {
		Usuario database = usuarioService.getOne(id);
		
		if (database == null) {
			throw new NotFoundException("Usuário não encontrado");
			//return ResponseEntity.status(404).body();
		}
		
		if (usuario.getEmail() != null &&
				!usuario.getEmail().equals(database.getEmail())) {
			try {
				Usuario usuarioExists = usuarioService
						.findByEmail(usuario.getEmail()).get();
				if (usuarioExists != null) {
					throw new RuntimeException("Email já existe");
					//return ResponseEntity.status(401).body(null);
				}
			} catch (NoSuchElementException e) {
			} catch (RuntimeException e) {
				
			}
		}
		
		// Faz uma comparação se a senha é igual a do banco
		// senão salva a senha criptografada
		usuario.setSenha(usuario.getSenha(), database);
		/*usuario.setHabilitado(database.getHabilitado());
		usuario.setAutoridade(database.getAutoridade());*/
		usuario.setId(database.getId());
		
		return ResponseEntity.ok(usuarioService.store(usuario));
	}

}
