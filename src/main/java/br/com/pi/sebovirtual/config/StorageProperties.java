package br.com.pi.sebovirtual.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
	
	// Pasta de salvamento dos arquivos
	private String location = "src/main/resources/static/uploads";
	// Define os tipos de arquivos que queremos salvar
	private String[] suportedFiles = new String[] {"jpeg", "jpg", "png", "gif", "webp"};

	public String getLocation() {
		return location;
	}
	
	public String[] getSuportedFiles() {
		return this.suportedFiles;
	}

}
