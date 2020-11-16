package br.com.pi.sebovirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pi.sebovirtual.dto.SearchDTO;
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
			@Nullable @RequestParam Integer pagina,
			@Nullable @RequestParam String[] estado,
			@Nullable @RequestParam String[] cidade,
			@Nullable @RequestParam Double precoMin,
			@Nullable @RequestParam Double precoMax,
			@Nullable @RequestParam String orderBy,
			@Nullable @RequestParam Integer resultadosPorPagina) {
		return ResponseEntity.ok().body(anuncioService.findByQuery(
				query,
				categoria,
				pagina,
				orderBy,
				resultadosPorPagina));
	}
}
