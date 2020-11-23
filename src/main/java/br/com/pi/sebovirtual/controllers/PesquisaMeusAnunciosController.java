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
import br.com.pi.sebovirtual.services.PesquisaMeusAnunciosService;

@RestController
@CrossOrigin
@RequestMapping("search-myads")
public class PesquisaMeusAnunciosController {
	@Autowired
	private PesquisaMeusAnunciosService anuncioService;
	
	@GetMapping
	public ResponseEntity<SearchDTO> getByQuery(
			@Nullable @RequestParam int userId,
			@Nullable @RequestParam Integer pageNumber,
			@Nullable @RequestParam String orderBy,
			@Nullable @RequestParam Integer resultsPerPage) {
		return ResponseEntity.ok().body(anuncioService.findByQuery(
				userId,
				pageNumber,
				orderBy,
				resultsPerPage));
	}
}
