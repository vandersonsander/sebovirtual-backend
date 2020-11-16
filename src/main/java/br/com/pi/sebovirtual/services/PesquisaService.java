package br.com.pi.sebovirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.dto.SearchDTO;
import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.repositories.PesquisaRepository;

@Service
public class PesquisaService {
	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	public SearchDTO findByQuery(
			@Nullable String query,
			@Nullable String categoria,
			@Nullable Integer pagina,
			@Nullable String orderBy,
			@Nullable Integer resultsPerPage) {
		if (query == null)
			query = "";
		query = query.replace(" ", "%");
		if (categoria == null)
			categoria = "";
		if (pagina == null)
			pagina = 0;
		if (orderBy == null)
			orderBy = "";
		if (resultsPerPage == null)
			resultsPerPage = 16;
		Sort sorteable = Sort.unsorted();
		if (orderBy.equals("minPrice"))
			sorteable = Sort.by(Sort.Direction.ASC, "preco");
		else if (orderBy.equals("minPrice"))
			sorteable = Sort.by(Sort.Direction.DESC, "preco");
		
		Pageable pageable = PageRequest.of(pagina, resultsPerPage, sorteable);
		SearchDTO search = new SearchDTO();
		Page<HistoricoAnuncio> anuncios = 
				pesquisaRepository.searchByQuery(query, categoria, pageable);
		search.setContent(anuncios.getContent());
		search.setResults(anuncios.getTotalElements());
		search.setPages(anuncios.getTotalPages());
		search.setCurrentPage(anuncios.getNumber());
		return search;
	}//*/
	
	public SearchDTO nextPage() {
		SearchDTO search = new SearchDTO();
		return search;
	}
}
