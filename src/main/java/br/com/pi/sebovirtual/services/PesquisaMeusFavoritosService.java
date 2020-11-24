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
import br.com.pi.sebovirtual.repositories.PesquisaMeusFavoritosRepository;

@Service
public class PesquisaMeusFavoritosService {
	@Autowired
	private PesquisaMeusFavoritosRepository repository;
	
	public SearchDTO findByQuery (
			@Nullable int userId,
			@Nullable Integer pageNumber,
			@Nullable Integer resultsPerPage) {
		if (pageNumber == null)
			pageNumber = 0;
		if (resultsPerPage == null)
			resultsPerPage = 5;
		Sort sorteable = Sort.unsorted();
		
		Pageable pageable = PageRequest.of(pageNumber, resultsPerPage, sorteable);
		SearchDTO search = new SearchDTO();
		Page<HistoricoAnuncio> pedidos = 
				repository.searchByQuery(
						userId,
						pageable);
		
		search.setContent(pedidos.getContent());
		search.setResults(pedidos.getTotalElements());
		search.setPages(pedidos.getTotalPages());
		search.setCurrentPage(pedidos.getNumber());
		return search;
	}
}
