package br.com.pi.sebovirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.dto.SearchDTO;
import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.services.VendedorService;

@CrossOrigin
@RestController
@RequestMapping("vendedor")
public class VendedorController {
	@Autowired
	private VendedorService service;
	
	@GetMapping
	public ResponseEntity<SearchDTO> getAll(
			@Nullable @RequestParam String estado,
			@Nullable @RequestParam String cidade) {
		return ResponseEntity.ok().body(service.getAll(estado, cidade));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> get(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.getOne(id));
	}
}
