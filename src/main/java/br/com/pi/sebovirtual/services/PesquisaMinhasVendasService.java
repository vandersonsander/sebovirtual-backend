package br.com.pi.sebovirtual.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.dto.SearchDTO;
import br.com.pi.sebovirtual.entities.Pedido;
import br.com.pi.sebovirtual.repositories.PesquisaMinhasVendasRepository;

@Service
public class PesquisaMinhasVendasService {
	@Autowired
	private PesquisaMinhasVendasRepository repository;
	
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
			sorteable = Sort.by(Sort.Direction.DESC, "data");
		else if (orderBy.equals("older")) // mais antigos
			sorteable = Sort.by(Sort.Direction.ASC, "data");
		
		Pageable pageable = PageRequest.of(pageNumber, resultsPerPage, sorteable);
		SearchDTO search = new SearchDTO();
		Page<Pedido> pedidos = 
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
