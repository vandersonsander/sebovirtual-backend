package br.com.pi.sebovirtual.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.pi.sebovirtual.dto.FilterDTO;
import br.com.pi.sebovirtual.dto.FilterOccurrencesDTO;
import br.com.pi.sebovirtual.dto.SearchDTO;
import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.VendedorRepository;

@Service
public class VendedorService {
	@Autowired
	private VendedorRepository repository;
	@Autowired
	private HistoricoEnderecoService enderecoService;
	
	public SearchDTO getAll(
			@Nullable String estado,
			@Nullable	String cidade,
			@Nullable Integer pagina,
			@Nullable Integer resultadosPorPagina) {
		if (pagina == null)
			pagina = 0;
		if (resultadosPorPagina == null)
			resultadosPorPagina = 16;
		
		List<String> parsedEstado = new ArrayList<>();
		if (estado == null || estado.isEmpty())
			enderecoService.getAll().stream()
				.forEach(endereco -> parsedEstado.add(endereco.getEstado()));
		else
			Stream.of(estado.split(",")).forEach(est -> {
				parsedEstado.add(est);
			});

		List<String> parsedCidade = new ArrayList<>();
		if (cidade == null || cidade.isEmpty())
			enderecoService.getAll().stream()
				.forEach(cid -> parsedCidade.add(cid.getCidade()));
		else
			Stream.of(cidade.split(",")).forEach(cid -> {
				parsedCidade.add(cid);
			});//*/
			
		SearchDTO search = new SearchDTO();
		Pageable pageable = PageRequest.of(pagina, resultadosPorPagina); 
		Page<Usuario> result = repository.getAll(parsedEstado, parsedCidade, pageable);
		search.setContent(result.getContent());
		search.setPages(result.getTotalPages());
		search.setResults(result.getTotalElements());
		search.setCurrentPage(result.getNumber());
		List<FilterOccurrencesDTO> estadoOccu = repository.generateFiltersEstado(parsedEstado, parsedCidade);
		List<FilterOccurrencesDTO> cidadeOccu = repository.generateFiltersCidade(parsedEstado, parsedCidade);
		List<FilterDTO> filters = new ArrayList<>();
		filters.add(new FilterDTO("estado", estadoOccu));//*/
		filters.add(new FilterDTO("cidade", cidadeOccu));//*/
		search.setFilters(filters);
		return search;
		//return null;
	}
	
	public Usuario getOne(Integer id) {
		Optional<Usuario> usuario = repository.findOne(id);
		if (usuario.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor não encontrado");
		return usuario.get();
	}
}
