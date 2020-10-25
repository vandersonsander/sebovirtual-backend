package br.com.pi.sebovirtual.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public abstract class BaseService<Entity extends BaseEntity,
	Repository extends BaseRepository<Entity>>{
	@Autowired
	private Repository repository;

	public List<Entity> getAll() {
		return repository.findAll();
	}
	
	public Entity getOne(Integer id) {
		Optional<Entity> entity = repository.findById(id);
		if (!entity.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entidade não foi encontrada");
		return entity.get();
	}
	
	public Entity store(Entity entity) {
		return repository.save(entity);
	}
	
	public Entity update(Integer id, Entity entity) {
		this.getOne(id);
		entity.setId(id);
		return this.store(entity);
	}
	
	public void destroy(Integer id) {
		Entity entity = this.getOne(id);
		repository.delete(entity);
	}
}
