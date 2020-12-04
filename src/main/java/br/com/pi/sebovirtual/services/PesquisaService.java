package br.com.pi.sebovirtual.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private HistoricoEnderecoService enderecoService;
	@Autowired
	private AutorService autorService;
	@Autowired
	private EditoraService editoraService;
	
	public SearchDTO findByQuery (
			@Nullable String query,
			@Nullable String categoria,
			@Nullable String condicao,
			@Nullable Double precoMin,
			@Nullable Double precoMax,
			@Nullable Integer pagina,
			@Nullable String estado,
			@Nullable String cidade,
			@Nullable String orderBy,
			@Nullable Integer resultsPerPage) {
		if (query == null)
			query = "";
		query = query.replace(" ", "%");
		
		List<String> parsedCategoria = new ArrayList<>();
		if (categoria == null || categoria.isEmpty())
			produtoService.getAll().stream()
				.forEach(categ -> parsedCategoria.add(categ.getCategoria()));
		else
			Stream.of(categoria.split(",")).forEach(categ -> {
				parsedCategoria.add(categ);
			});
		
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
		
		if (condicao == null || condicao.isEmpty())
			condicao = "Usado,Novo,Seminovo";
		String[] parsedCondicao = condicao.split(",");
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
						parsedCategoria,
						parsedCondicao,
						precoMin,
						precoMax,
						parsedEstado,
						parsedCidade,
						pageable);
		
		/* Filtros */
		
		List<FilterOccurrencesDTO> condicaoOccu = pesquisaRepository.generateFiltersDescricao(
				query,
				parsedCategoria, 
				parsedCondicao,
				precoMin,
				precoMax,
				parsedEstado,
				parsedCidade);
		List<FilterOccurrencesDTO> categoriaOccu = pesquisaRepository.generateFiltersCategoria(
				query,
				parsedCategoria, 
				parsedCondicao,
				precoMin,
				precoMax,
				parsedEstado,
				parsedCidade);

		List<FilterOccurrencesDTO> estadoOccu = pesquisaRepository.generateFiltersEstado(
				query,
				parsedCategoria, 
				parsedCondicao,
				precoMin,
				precoMax,
				parsedEstado,
				parsedCidade);

		List<FilterOccurrencesDTO> cidadeOccu = pesquisaRepository.generateFiltersCidade(
				query,
				parsedCategoria, 
				parsedCondicao,
				precoMin,
				precoMax,
				parsedEstado,
				parsedCidade);
		
		List<FilterDTO> filters = new ArrayList<>();
		
		filters.add(new FilterDTO("condicao", condicaoOccu));
		filters.add(new FilterDTO("categoria", categoriaOccu));
		filters.add(new FilterDTO("estado", estadoOccu));
		filters.add(new FilterDTO("cidade", cidadeOccu));
		
		search.setContent(anuncios.getContent());
		search.setResults(anuncios.getTotalElements());
		search.setPages(anuncios.getTotalPages());
		search.setCurrentPage(anuncios.getNumber());
		search.setFilters(filters);
		return search;
	}
	
	/* Livros */
	public SearchDTO getPublicacao (
			@Nullable String categoria,
			@Nullable String condicao,
			@Nullable String autor,
			@Nullable String editora,
			@Nullable String genero,
			@Nullable Double precoMin,
			@Nullable Double precoMax,
			@Nullable Integer pagina,
			@Nullable String estado,
			@Nullable String cidade,
			@Nullable String orderBy,
			@Nullable Integer resultsPerPage) {
		
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
			});
		
		List<String> parsedAutor = new ArrayList<>();
		if (autor == null || autor.isEmpty())
			autorService.getAll().stream()
				.forEach(aut -> parsedAutor.add(aut.getNome() + " " + aut.getSobrenome()));
		else
			Stream.of(autor.split(",")).forEach(aut -> {
				parsedAutor.add(aut);
			});
		parsedAutor.add(" ");
		
		List<String> parsedEditora = new ArrayList<>();
		if (editora == null || editora.isEmpty())
			editoraService.getAll().stream()
				.forEach(edi -> parsedEditora.add(edi.getNome()));
		else
			Stream.of(editora.split(",")).forEach(edi -> {
				parsedEditora.add(edi);
			});
		
		if (condicao == null || condicao.isEmpty())
			condicao = "Usado,Novo,Seminovo";
		String[] parsedCondicao = condicao.split(",");
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
		Page<HistoricoAnuncio> anuncios = pesquisaRepository.getPublicacao(
				categoria,
				precoMin,
				precoMax,
				parsedCondicao,
				parsedAutor,
				parsedEstado,
				parsedCidade,
				parsedEditora,
				pageable);
		
		/* Filtros */
		List<FilterOccurrencesDTO> condicaoOccu = pesquisaRepository.getPublicacaoFiltersDescricao(
				categoria,
				precoMin,
				precoMax,
				parsedCondicao,
				parsedAutor,
				parsedEstado,
				parsedCidade,
				parsedEditora);
		List<FilterOccurrencesDTO> estadoOccu = pesquisaRepository.getPublicacaoFiltersEstado(
				categoria,
				precoMin,
				precoMax,
				parsedCondicao,
				parsedAutor,
				parsedEstado,
				parsedCidade,
				parsedEditora);
		List<FilterOccurrencesDTO> cidadeOccu = pesquisaRepository.getPublicacaoFiltersCidade(
				categoria,
				precoMin,
				precoMax,
				parsedCondicao,
				parsedAutor,
				parsedEstado,
				parsedCidade,
				parsedEditora);
		List<FilterOccurrencesDTO> autorOccu = pesquisaRepository.getPublicacaoFiltersAutor(
				categoria,
				precoMin,
				precoMax,
				parsedCondicao,
				parsedAutor,
				parsedEstado,
				parsedCidade,
				parsedEditora);//*/
		List<FilterOccurrencesDTO> editoraOccu = pesquisaRepository.getPublicacaoFiltersEditora(
				categoria,
				precoMin,
				precoMax,
				parsedCondicao,
				parsedAutor,
				parsedEstado,
				parsedCidade,
				parsedEditora);
		
		List<FilterDTO> filters = new ArrayList<>();
		filters.add(new FilterDTO("condicao", condicaoOccu));
		filters.add(new FilterDTO("estado", estadoOccu));
		filters.add(new FilterDTO("cidade", cidadeOccu));
		filters.add(new FilterDTO("autor", autorOccu));
		filters.add(new FilterDTO("editora", editoraOccu));
		
		search.setContent(anuncios.getContent());
		search.setResults(anuncios.getTotalElements());
		search.setPages(anuncios.getTotalPages());
		search.setCurrentPage(anuncios.getNumber());
		search.setFilters(filters);
		return search;
	}//*/
	
	public List<HistoricoAnuncio> listarMaisVendidos() {
		Pageable pageable = PageRequest.of(0, 6);
		return pesquisaRepository.getMaisVendidos(pageable).getContent();
	}
	public List<HistoricoAnuncio> listarMaisPopulares() {
		Pageable pageable = PageRequest.of(0, 6);
		return pesquisaRepository.getMaisPopulares(pageable).getContent();
	}
	public List<HistoricoAnuncio> listarMaisRecentes() {
		Sort sort = Sort.by(Sort.Direction.DESC, "dataModificacao");
		Pageable pageable = PageRequest.of(0, 12, sort);
		return pesquisaRepository.getMaisRecentes(pageable).getContent();
	}
}
