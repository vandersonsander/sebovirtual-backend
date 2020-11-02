package br.com.pi.sebovirtual.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.pi.sebovirtual.util.Utils;

public abstract class BaseService<Entity extends BaseEntity,
	Repository extends BaseRepository<Entity>> {
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
		try {
			return repository.save(entity);
		} catch(RuntimeException e) {
			throw new ResponseStatusException(
					HttpStatus.FORBIDDEN, "Erro ao cadastrar");
		}
	}
	
	public Entity update(Integer id, Entity entity) {
		Entity updateEntity = this.getOne(id);
		entity.setId(id);
		Utils.updateProperties(entity, updateEntity, true);
		return this.store(updateEntity);
	}
	
	public void destroy(Integer id) {
		Entity entity = this.getOne(id);
		repository.delete(entity);
	}
}
