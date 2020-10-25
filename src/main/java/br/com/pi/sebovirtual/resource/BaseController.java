package br.com.pi.sebovirtual.resource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	
//	Todos os campos são verificados sem a necessidade de vários ifs nos controllers
	@PutMapping("/{id}") // Atualizar uma entidade
	@Transactional
	public ResponseEntity<Entity> update(@Valid @PathVariable Integer id,
			@RequestBody Entity entity)
					throws Exception {
		// Busca no banco a entidade atual
		Entity currentEntity = service.getOne(id);
		
		// Verifica todos os métodos que a entidade possui
		Method[] methods = currentEntity.getClass().getDeclaredMethods();
		Stream<Method> stream = Stream.of(methods);
		stream.forEach((method) -> {
			String methodName = method.getName();
			
			// Verifica se o método começa com get
			// Queremos pegar o valor para comparação
			if (methodName.startsWith("get")) {
				// Mudamos o nome para set para settarmos o valor
				final String name = "set" + methodName.substring(3);
					// Valor passado na requisição
					Object bodyField;
					try {
						bodyField = method.invoke(entity, new Object[] {});
					
					// Valor atual do BD
						Object entityField = method.invoke(currentEntity, new Object[] {});
						if (bodyField != null // Não pode ser null
								&& !bodyField.equals(entityField)) { // Só atualiza se o valor for diferente
							Stream<Method> findSet = Stream.of(methods);
							// faz uma busca pelo método set e o invoca
							findSet.filter((fMethod) -> fMethod.getName().equals(name))
								.forEach((fMethod) -> {
									try {
										fMethod.invoke(currentEntity, bodyField);
									} catch (IllegalAccessException | IllegalArgumentException
											| InvocationTargetException e) {
										e.printStackTrace();
									}
								});
						}
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e1) {
						e1.printStackTrace();
					}
			}
		});
		// Após as verificações anteriores o valor é salvo no bd
		Entity updatedEntity = service.update(id, currentEntity);
		return ResponseEntity.ok(updatedEntity);
	}
	
	@DeleteMapping("/{id}") // Deletar uma entidade
	@Transactional
	public ResponseEntity<?> destroy(@PathVariable Integer id) throws NotFoundException {
		service.destroy(id);
		return ResponseEntity.noContent().build();
	}
}
