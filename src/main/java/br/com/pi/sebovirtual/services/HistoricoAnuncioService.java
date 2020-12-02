package br.com.pi.sebovirtual.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.entities.Status;
import br.com.pi.sebovirtual.repositories.HistoricoAnuncioRepository;
import br.com.pi.sebovirtual.repositories.StatusRepository;
import br.com.pi.sebovirtual.resource.BaseService;
import br.com.pi.sebovirtual.util.Utils;

@Service
public class HistoricoAnuncioService
	extends BaseService<HistoricoAnuncio, HistoricoAnuncioRepository> {
	@Autowired
	private HistoricoAnuncioRepository anuncioRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	// NÃO DESCOMENTAR E NEM APAGAR ESTE CÓDIGO. EM TESTE!
	/*@Autowired
	private UsuarioService usuarioService;*/

	@Override
	public HistoricoAnuncio store(HistoricoAnuncio anuncio) {
		// Obtém o id do usuário criador do anúncio.
		Integer idUsuario = anuncio.getUsuario().getId();
		
		Integer idAnuncio = anuncioRepository.getNextIdAnuncio(idUsuario);
		// Se o ID é igual a null
		// significa que está cadastrando um novo anúncio
		if (anuncio.getId() == null) 
			anuncio.setIdAnuncio(
					idAnuncio == null ? 1 : idAnuncio
			);
		// O novo registro possui status ativo.
		Optional<Status> statusAtivo = 
			statusRepository.findOneByNome(Status.ATIVO);
		if (statusAtivo.isPresent()) {
			anuncio.setStatus(statusAtivo.get());
		}
		anuncio.setDataModificacao(java.time.LocalDateTime.now());
		return super.store(anuncio);
	}

	@Override
	public HistoricoAnuncio update(Integer id, HistoricoAnuncio anuncio) {
		HistoricoAnuncio current = super.getOne(id);
		// O idAnuncio nunca muda
		anuncio.setIdAnuncio(current.getIdAnuncio());
		
		// Se houver pedidos relacionados cria um novo
		// anúncio mantento o mesmo "idAnuncio"
		if (current.getItens() != null &&
				!current.getItens().isEmpty()) {
			System.out.println("tem pedido");
			Utils.updateProperties(anuncio, current, true);
			Utils.updateProperties(current, anuncio, true);
			return super.store(anuncio);
		}
		
		/*// O status do registro atual muda para editado.
		Optional<Status> statusEditado = 
			statusRepository.findOneByNome(Status.EDITADO);
		if (statusEditado.isPresent()) {
			current.setStatus(statusEditado.get()); // Muda o status para editado			
		}*/
		
		// NÃO DESCOMENTAR E NEM APAGAR ESTE CÓDIGO. EM TESTE!
		// Atualiza os usuários que favoritaram este anúncio.
		/*Collection<Usuario> novosUsuariosQueFavoritaram = 
			new HashSet<Usuario>();
		System.out.println("Qtde de usuarios antes: "+ current.getUsuarios().size());
		if (!anuncio.getUsuarios().isEmpty()) {
			
			// Adiciona os novos usuários que favoritaram este anúncio.
			novosUsuariosQueFavoritaram
				.addAll(anuncio.getUsuarios()
				.stream()
				.map(u-> {
					Usuario usuario = usuarioService.getOne(u.getId());
					usuario.getAnuncios().add(current);
					return usuario;
				}).collect(Collectors.toList()));	
			
			current.getUsuarios().addAll(novosUsuariosQueFavoritaram);
			
			System.out.println("Qtde de novos usuarios: " + novosUsuariosQueFavoritaram.size());
			System.out.println("Qtde de usuarios atuais: " + current.getUsuarios().size());
		}*/
		
		return this.update(id, anuncio);
	}
	
	public ResponseEntity<List<HistoricoAnuncio>> findByFilters(Integer query) {
		return ResponseEntity.ok().body(anuncioRepository.findQuery(query));
	}
	
	@Override
	public void destroy(Integer id) {
		// Não apaga o registro de fato, pois ele pode estar sendo
		// referenciado por um pedido, mas seu status muda para excluído.
		HistoricoAnuncio current = this.getOne(id);
		Optional<Status> status = 
			statusRepository.findOneByNome(Status.EXCLUIDO);
		if (status.isPresent()) {
			current.setStatus(status.get()); // Muda o status para excluido			
		}
	}
	
}
