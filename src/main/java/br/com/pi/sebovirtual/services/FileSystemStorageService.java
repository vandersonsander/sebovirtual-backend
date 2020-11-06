package br.com.pi.sebovirtual.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.pi.sebovirtual.config.StorageProperties;
import br.com.pi.sebovirtual.exceptions.StorageException;

@Service
public class FileSystemStorageService implements StorageService {
	
	private final Path rootLocation;
	
	@Autowired
	public FileSystemStorageService(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
	}

	@Override
	public void Store(MultipartFile file) {
		try {
			if (file.isEmpty())
				throw new StorageException("Falha ao armazenar: arquivo vazio");
			
			Path destinationFile = this.rootLocation.resolve(
					Paths.get(file.getOriginalFilename()))
					.normalize().toAbsolutePath();
			if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath()))
				// Verificação de segurança
				throw new StorageException(
						"Falha ao armazenar: fora do diretório atual");
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile,
						StandardCopyOption.REPLACE_EXISTING);
			}
		} catch (IOException e) {
			throw new StorageException("Falha ao guardar a imagem.", e);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		return null;
	}

	@Override
	public Path load(String filename) {
		return null;
	}

	@Override
	public Resource loadAsResource(String filename) {
		return null;
	}

	@Override
	public void deleteAll() {
		
	}

	@Override
	public void init() {
		
	}

}
