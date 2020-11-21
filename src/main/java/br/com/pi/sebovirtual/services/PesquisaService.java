package br.com.pi.sebovirtual.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.dto.FilterDTO;
import br.com.pi.sebovirtual.dto.FilterOccurrencesDTO;
import br.com.pi.sebovirtual.dto.SearchDTO;
import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.repositories.PesquisaRepository;

@Service
public class PesquisaService {
	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	public SearchDTO findByQuery (
			@Nullable String query,
			@Nullable String categoria,
			@Nullable String condicao,
			@Nullable Double precoMin,
			@Nullable Double precoMax,
			@Nullable Integer pagina,
			@Nullable String orderBy,
			@Nullable Integer resultsPerPage) {
		if (query == null)
			query = "";
		query = query.replace(" ", "%");
		if (categoria == null)
			categoria = "";
		if (condicao == null)
			condicao = "";
		if (precoMin == null)
			precoMin = 0.0;
		if (precoMax == null)
			precoMax = 9999999999.0;
		if (pagina == null)
			pagina = 0;
		if (orderBy == null)
			orderBy = "";
		if (resultsPerPage == null)
			resultsPerPage = 16;
		Sort sorteable = Sort.unsorted();
		if (orderBy.equals("minPrice"))
			sorteable = Sort.by(Sort.Direction.ASC, "preco");
		else if (orderBy.equals("maxPrice"))
			sorteable = Sort.by(Sort.Direction.DESC, "preco");
		
		Pageable pageable = PageRequest.of(pagina, resultsPerPage, sorteable);
		SearchDTO search = new SearchDTO();
		Page<HistoricoAnuncio> anuncios = 
				pesquisaRepository.searchByQuery(
						query,
						categoria,
						condicao,
						precoMin,
						precoMax,
						pageable);
		
		/* Filtros */
		List<FilterOccurrencesDTO> condicaoOccu = pesquisaRepository.generateFiltersDescricao(
				query,
				categoria, 
				condicao,
				precoMin,
				precoMax);
		List<FilterOccurrencesDTO> categoriaOccu = pesquisaRepository.generateFiltersCategoria(
				query,
				categoria, 
				condicao,
				precoMin,
				precoMax);
		List<FilterDTO> filters = new ArrayList<>();
		filters.add(new FilterDTO("condicao", condicaoOccu));
		filters.add(new FilterDTO("categoria", categoriaOccu));
		
		search.setContent(anuncios.getContent());
		search.setResults(anuncios.getTotalElements());
		search.setPages(anuncios.getTotalPages());
		search.setCurrentPage(anuncios.getNumber());
		search.setFilters(filters);
		return search;
	}
}
