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
import br.com.pi.sebovirtual.repositories.PesquisaMeusAnunciosRepository;

@Service
public class PesquisaMeusAnunciosService {
	@Autowired
	private PesquisaMeusAnunciosRepository pesquisaRepository;
	
	public SearchDTO findByQuery (
			@Nullable int userId,
			@Nullable Integer pageNumber,
			@Nullable String orderBy,
			@Nullable Integer resultsPerPage) {
		if (pageNumber == null)
			pageNumber = 0;
		if (orderBy == null)
			orderBy = "";
		if (resultsPerPage == null)
			resultsPerPage = 5;
		Sort sorteable = Sort.unsorted();
		if (orderBy.equals("last")) // mais recentes
			sorteable = Sort.by(Sort.Direction.DESC, "dataModificacao");
		else if (orderBy.equals("older")) // mais antigos
			sorteable = Sort.by(Sort.Direction.ASC, "dataModificacao");
		
		Pageable pageable = PageRequest.of(pageNumber, resultsPerPage, sorteable);
		SearchDTO search = new SearchDTO();
		Page<HistoricoAnuncio> anuncios = 
				pesquisaRepository.searchByQuery(
						userId,
						pageable);
		
		search.setContent(anuncios.getContent());
		search.setResults(anuncios.getTotalElements());
		search.setPages(anuncios.getTotalPages());
		search.setCurrentPage(anuncios.getNumber());
		return search;
	}
}
