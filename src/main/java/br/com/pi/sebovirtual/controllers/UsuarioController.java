package br.com.pi.sebovirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.UsuarioRepository;
import br.com.pi.sebovirtual.resource.BaseController;
import br.com.pi.sebovirtual.services.UsuarioService;

@CrossOrigin
@RestController
@RequestMapping("usuario")
public class UsuarioController extends 
	BaseController<Usuario, UsuarioRepository, UsuarioService> {

	@Autowired
	private UsuarioRepository repository;
	
	/*@GetMapping("/favoritos/{id}")
	List<Object[]> getFavoritesById(@PathVariable int id) {
		return repository.findFavoritesAds(id);
	}//*/
	
	@GetMapping("/favoritos")
	List<Usuario> getFavoritesById(@RequestParam String email) {
		return repository.findFavoritesAds(email);
	}
	
}