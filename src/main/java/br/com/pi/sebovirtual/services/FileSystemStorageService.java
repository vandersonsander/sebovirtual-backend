package br.com.pi.sebovirtual.services;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.Stream;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.pi.sebovirtual.config.StorageProperties;
import br.com.pi.sebovirtual.exceptions.StorageException;

@Service
public class FileSystemStorageService implements StorageService {
	
	private final Path rootLocation;
	private final String[] suportedFiles;

	
	@Autowired
	public FileSystemStorageService(StorageProperties properties) {
		this.rootLocation = Paths.get(properties.getLocation());
		this.suportedFiles = properties.getSuportedFiles();
	}

	@Override
	public String store(MultipartFile file) {
		try {
			if (file.isEmpty())
				throw new StorageException("Falha ao armazenar: arquivo vazio");
			
			String filename = randomFileName(file.getOriginalFilename());
			
			// Verifica os formatos suportados
			checksSuportedTypes(filename, this.suportedFiles);

			Path destinationFile = this.rootLocation.resolve(
					Paths.get(filename))
					.normalize().toAbsolutePath();
			if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath()))
				// Verificação de segurança
				throw new StorageException(
						"Falha ao armazenar: fora do diretório atual");
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile,
						StandardCopyOption.REPLACE_EXISTING);
			}
			return filename;
		} catch (IOException e) {
			throw new StorageException("Falha ao guardar a imagem.", e);
		}
	}
	
	@Override // Salva múltiplos arquivos
	public Stream<String> storeAll(MultipartFile[] file) {
		return Stream.of(file).map(this::store);
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.rootLocation, 1)
					.filter(path -> !path.equals(this.rootLocation))
					.map(this.rootLocation::relativize);
		} catch (IOException e) {
			throw new StorageException("Falha ao carregar arquivos", e);
		}
	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable())
				return resource;
			else
				throw new StorageException(
						"Falha ao carregar arquivo: " + filename);
		} catch (MalformedURLException e) {
			throw new StorageException("Falha ao carregar arquivo: " + filename, e);
		}
	}
	
	public ResponseEntity<String> deleteOne(String filename) {
		try {
			Files.deleteIfExists(this.rootLocation.resolve(filename));
			return ResponseEntity.ok().body("Imagem apagada com sucesso: " + filename);
		} catch (IOException e) {
			return ResponseEntity.badRequest().body("Falha ao apagar imagem " + filename);
		}
	}

	@Override
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		} catch(IOException e) {
			throw new StorageException("Falha ao criar diretório.", e);
		}
	}
	
	// Gerar um nome aleatório para o arquivo
	private final String randomFileName(String filename) {
		String extName = filename.substring(filename.lastIndexOf(".") + 1);
		Random random = new Random();
		try {
			byte[] chars = ((Double) (random.nextDouble() * LocalDateTime.now().getNano()))
					.toString().getBytes();
			random.nextBytes(chars);
			byte[] charBytes = Base64.encodeBase64(chars);
			return new String(charBytes, "UTF-8").replace("/", "0") + "." + extName;
		} catch (UnsupportedEncodingException e) {
			throw new StorageException("Falha ao gerar nome do arquivo", e);
		}
	}
	
	// Verifica os tipos de arquivo suportados
	private final void checksSuportedTypes(String filename, String[] types) {
		String extName = filename.substring(filename.lastIndexOf(".") + 1).toLowerCase();
		if (Stream.of(types).filter(extName::equals).findAny().isEmpty())
			throw new StorageException("Formato não suportado");
	}

}
