package br.com.pi.sebovirtual.controllers;

import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import br.com.pi.sebovirtual.entities.HistoricoAnuncio;
import br.com.pi.sebovirtual.entities.Imagem;
import br.com.pi.sebovirtual.exceptions.StorageFileNotFoundException;
import br.com.pi.sebovirtual.services.HistoricoAnuncioService;
import br.com.pi.sebovirtual.services.ImagemService;
import br.com.pi.sebovirtual.services.StorageService;

@RestController
@RequestMapping("upload")
@CrossOrigin
public class FileUploadController {
	
	private final StorageService storageService;
	private final ImagemService imagemService;
	private final HistoricoAnuncioService anuncioService;
	
	@Autowired
	public FileUploadController(StorageService storageService,
			ImagemService imagemService,
			HistoricoAnuncioService anuncioService) {
		this.storageService = storageService;
		this.imagemService = imagemService;
		this.anuncioService = anuncioService;
		this.storageService.init();
	}
	
	@GetMapping("{filename:.+}")
	public ResponseEntity<Resource> getOne(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"inline; filename=\"" + file.getFilename() + "\"")
				.contentType(MediaType.IMAGE_PNG).body(file);
	}//*/
	
	@PostMapping("{id}")
	@Transactional
	public ResponseEntity<Stream<Imagem>> storeAll(@RequestParam("file") MultipartFile[] file,
			@PathVariable Integer id) {
		HistoricoAnuncio anuncio = anuncioService.getOne(id);
		if (anuncio == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Id de anúncio não encontrado");
		
		return ResponseEntity.ok().body(
				storageService.storeAll(file) // salva os arquivos no servidor
					.map(filename -> {
						Imagem imagem = new Imagem();
						imagem.setHistoricoAnuncio(anuncio);
						imagem.setUrl(filename);
						return imagemService.store(imagem); // armazena os nomes no banco
					})
				);
	}
	
	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
}
