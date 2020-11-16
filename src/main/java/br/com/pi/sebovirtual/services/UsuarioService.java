package br.com.pi.sebovirtual.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.pi.sebovirtual.dto.AlterarSenhaDTO;
import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.UsuarioRepository;
import br.com.pi.sebovirtual.resource.BaseService;
import br.com.pi.sebovirtual.util.PasswordUtils;
import br.com.pi.sebovirtual.util.Utils;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired 
	private HistoricoAnuncioService anuncioService;
	
	public Optional<Usuario> findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	@Override
	public Usuario store(Usuario entity) {
		// Verifica se o email que o usuário quer cadastrar
		// já existe
		if (entity.getId() == null)
			if (emailExists(entity.getEmail()))
				throw new ResponseStatusException(
						HttpStatus.FORBIDDEN, "Email já existe");

		// Verifica se já não há criptografia
		if (!PasswordUtils.checksIfPasswordIsEncrypted(entity.getSenha()))
			entity.setSenha(
					PasswordUtils.encriptyPassword(entity.getSenha()));
		return super.store(entity);
	}
	
	@Override
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
		
		/** NÃO DESCOMENTAR E NEM APAGAR ESTE CÓDIGO. EM TESTE
		// Atualiza os anúncios favoritos. O ideaL é que os novos anúncios favoritos
		// substituíssem os antigos, mas eles estão sendo adicionados.
		Collection<HistoricoAnuncio> novosFavoritos = 
			new HashSet<HistoricoAnuncio>();
		//System.out.println("Qtde de favoritos antes: "+ current.getFavoritos().size());
		if (!entity.getFavoritos().isEmpty()) {
			
			// Adiciona os novos anúncios favoritos.
			novosFavoritos
				.addAll(entity.getFavoritos()
				.stream()
				.map(a-> {
					HistoricoAnuncio anuncio = anuncioService.getOne(a.getId());
					anuncio.getUsuarios().add(current);
					return anuncio;
				}).collect(Collectors.toList()));	
			
			current.getFavoritos().addAll(novosFavoritos);
			
			//System.out.println("Qtde de novos favoritos: " + novosFavoritos.size());
			//System.out.println("Qtde de favoritos atuais: " + current.getFavoritos().size());
		}*/
		// Não funciona para atualizar os favoritos
		Utils.updateProperties(entity, current, true); 
		return this.store(current); 
	
	}
	
	public Boolean emailExists(String email) {
		return findByEmail(email).isPresent();
	}

	public Usuario alterarSenha(Integer id, @Valid AlterarSenhaDTO alterarSenhaDTO) {
		Usuario current = super.getOne(id);
		
		String senhaAtual = alterarSenhaDTO.getSenhaAtual();
		String senhaNova = alterarSenhaDTO.getSenhaNova();
		String encryptedPassword = current.getSenha();
		// Compara se a senha atual digital digitada pelo usuário está correta,
		// ou seja, se a senha é igual a senha salva no banco.
		if (!PasswordUtils.comparesPassword(senhaAtual, encryptedPassword)) {
			throw new ResponseStatusException(
				HttpStatus.FORBIDDEN, "A senha enviada é diferente da senha atual.");
		} else {
			current.setSenha(PasswordUtils.encriptyPassword(senhaNova));
		}
		return this.update(id, current);
	}
	
}
