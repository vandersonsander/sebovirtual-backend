package br.com.pi.sebovirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.repositories.HistoricoAnuncioRepository;
import br.com.pi.sebovirtual.resource.BaseService;
import br.com.pi.sebovirtual.util.Utils;

@Service
public class HistoricoAnuncioService
	extends BaseService<HistoricoAnuncio, HistoricoAnuncioRepository> {
	@Autowired
	private HistoricoAnuncioRepository anuncioRepository;
	
	// NÃO DESCOMENTAR E NEM APAGAR ESTE CÓDIGO. EM TESTE!
	/*@Autowired
	private UsuarioService usuarioService;*/

	@Override
	public HistoricoAnuncio store(HistoricoAnuncio anuncio) {
		Integer idAnuncio = anuncioRepository.getNextIdAnuncio();
		// Se o ID é igual a null
		// significa que está cadastrando um novo anúncio
		if (anuncio.getId() == null) 
			anuncio.setIdAnuncio(
					idAnuncio == null ? 1 : idAnuncio
			);
		anuncio.setDataModificacao(java.time.LocalDate.now());
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
			Utils.updateProperties(anuncio, current, true);
			Utils.updateProperties(current, anuncio, true);
			return super.store(anuncio);
		}
		
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
		
		return super.update(id, anuncio);
	}
	
}
