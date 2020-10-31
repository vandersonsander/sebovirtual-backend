package br.com.pi.sebovirtual.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javassist.NotFoundException;

public abstract class BaseController<Entity extends BaseEntity,
	Repository extends BaseRepository<Entity>, 
	Service extends BaseService<Entity, Repository>> {
	@Autowired
	private Service service;
	
	@GetMapping // Listar todos entidades
	public ResponseEntity<List<Entity>> index() {
		List<Entity> entities = service.getAll();
		return ResponseEntity.ok(entities);
	}
	
	@GetMapping("/{id}") // Retornar uma entidade
	public ResponseEntity<Entity> show(@PathVariable(value = "id") Integer id) throws NotFoundException {
		Entity entity = service.getOne(id);
		return ResponseEntity.ok(entity);
	}
	
	@PostMapping // Cadastrar uma entidade
	@Transactional
	public ResponseEntity<Entity> store(@Valid @RequestBody Entity entity) {
		Entity newEntity = service.store(entity);
		return ResponseEntity.status(201).body(newEntity);
	}
	
	@PutMapping("/{id}") // Atualizar uma entidade
	@Transactional
	public ResponseEntity<Entity> update (
			@Valid @PathVariable(value = "id") Integer id,
			@RequestBody Entity entity) {
		Entity updatedEntity = service.update(id, entity);
		return ResponseEntity.ok(updatedEntity);
	}
	
	@DeleteMapping("/{id}") // Deletar uma entidade
	@Transactional
	public ResponseEntity<?> destroy(@PathVariable Integer id) throws NotFoundException {
		service.destroy(id);
		return ResponseEntity.noContent().build();
	}
}
