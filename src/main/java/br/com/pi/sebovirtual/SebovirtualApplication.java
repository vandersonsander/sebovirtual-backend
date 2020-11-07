package br.com.pi.sebovirtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.pi.sebovirtual.config.StorageProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class SebovirtualApplication {

	public static void main(String[] args) {
		SpringApplication.run(SebovirtualApplication.class, args);
	}

}
