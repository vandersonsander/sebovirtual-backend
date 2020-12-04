package br.com.pi.sebovirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.dto.SearchDTO;
import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.services.PesquisaService;

@RestController
@CrossOrigin
@RequestMapping("search")
public class PesquisaController {
	@Autowired
	private PesquisaService anuncioService;
	
	@GetMapping
	public ResponseEntity<SearchDTO> getByQuery(
			@Nullable @RequestParam String query,
			@Nullable @RequestParam String categoria,
			@Nullable @RequestParam String condicao,
			@Nullable @RequestParam Integer pagina,
			@Nullable @RequestParam String estado,
			@Nullable @RequestParam String cidade,
			@Nullable @RequestParam Double precoMin,
			@Nullable @RequestParam Double precoMax,
			@Nullable @RequestParam String orderBy,
			@Nullable @RequestParam Integer resultadosPorPagina) {
		return ResponseEntity.ok().body(anuncioService.findByQuery(
				query,
				categoria,
				condicao,
				precoMin,
				precoMax,
				pagina,
				estado,
				cidade,
				orderBy,
				resultadosPorPagina));
	}
	@GetMapping("livro")
	public ResponseEntity<SearchDTO> getLivros(
			@Nullable @RequestParam String condicao,
			@Nullable @RequestParam String autor,
			@Nullable @RequestParam String editora,
			@Nullable @RequestParam String idioma,
			@Nullable @RequestParam Double precoMin,
			@Nullable @RequestParam Double precoMax,
			@Nullable @RequestParam Integer pagina,
			@Nullable @RequestParam String estado,
			@Nullable @RequestParam String cidade,
			@Nullable @RequestParam String orderBy,
			@Nullable @RequestParam Integer resultadosPorPagina) {
		return ResponseEntity.ok().body(anuncioService.getPublicacao(
				"livro",
				condicao,
				autor,
				editora,
				idioma,
				precoMin,
				precoMax,
				pagina,
				estado,
				cidade,
				orderBy,
				resultadosPorPagina));
	}
	
	@GetMapping("quadrinho")
	public ResponseEntity<SearchDTO> getQuadrinhos(
			@Nullable @RequestParam String condicao,
			@Nullable @RequestParam String autor,
			@Nullable @RequestParam String editora,
			@Nullable @RequestParam String genero,
			@Nullable @RequestParam Double precoMin,
			@Nullable @RequestParam Double precoMax,
			@Nullable @RequestParam Integer pagina,
			@Nullable @RequestParam String estado,
			@Nullable @RequestParam String cidade,
			@Nullable @RequestParam String orderBy,
			@Nullable @RequestParam Integer resultadosPorPagina) {
		return ResponseEntity.ok().body(anuncioService.getPublicacao(
				"quadrinho",
				condicao,
				autor,
				editora,
				genero,
				precoMin,
				precoMax,
				pagina,
				estado,
				cidade,
				orderBy,
				resultadosPorPagina));
	}
	
	@GetMapping("mais-vendidos")
	public ResponseEntity<List<HistoricoAnuncio>> getMaisVendidos() {
		return ResponseEntity.ok().body(anuncioService.listarMaisVendidos());
	}
	@GetMapping("mais-populares")
	public ResponseEntity<List<HistoricoAnuncio>> getMaisPopulares() {
		return ResponseEntity.ok().body(anuncioService.listarMaisPopulares());
	}
	@GetMapping("mais-recentes")
	public ResponseEntity<List<HistoricoAnuncio>> getMaisRecentes() {
		return ResponseEntity.ok().body(anuncioService.listarMaisRecentes());
	}
}
