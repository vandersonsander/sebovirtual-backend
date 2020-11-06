package br.com.pi.sebovirtual.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("storage")
public class StorageProperties {
	
	private String location = "/src/main/resources/static/uploads";

}
