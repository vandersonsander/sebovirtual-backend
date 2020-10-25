package br.com.pi.sebovirtual.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.UsuarioRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.UsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController extends BaseController<Usuario, UsuarioRepository, UsuarioService> {
	/*
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public Iterable<Usuario> getUsuarios() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> getById(@PathVariable int id) {
		return repository.findById(id);
	}
	
	/*@GetMapping("/nome/{nome}")
	public Usuario getByNome(@PathVariable String nome) {
		return repository.findOneByNome(nome);
	}*/

	/*@GetMapping("/email/{email}")
	public Usuario getByEmail(@PathVariable String email) {
		return repository.findOneByEmail(email);
	}*//*
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario) {
//		System.out.println(usuario.getId_usuario());/*
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getSenha());
		String senhaCripto = passwordEncoder.encode(usuario.getSenha());
		System.out.println(usuario.getHabilitado());
		System.out.println(usuario.getAutoridade());
		usuario.setSenha(senhaCripto);
//		repository.save(usuario);
		return usuario; 
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsuario(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/{idPaciente}")
	public Usuario updateUsuario(@PathVariable int idUsuario, 
			@RequestBody Usuario dadosUsuario) throws IllegalAccessException {
		Usuario database = repository.findById(idUsuario).orElseThrow(() -> new IllegalAccessException());
		
		String email = database.getEmail();
		if (email != null && !email.isEmpty()) 
			database.setEmail(email);
		
		String senha = database.getSenha();
		if (senha != null && !senha.isEmpty()) 
			database.setSenha(senha);
		
		Boolean habilitado = database.getHabilitado();
		if (habilitado != null) 
			database.setHabilitado(habilitado);
		
		String autoridade = database.getAutoridade();
		if (autoridade != null && !autoridade.isEmpty()) 
			database.setAutoridade(autoridade);
		
		repository.save(database);
		
		return dadosUsuario;
	}*/

}
