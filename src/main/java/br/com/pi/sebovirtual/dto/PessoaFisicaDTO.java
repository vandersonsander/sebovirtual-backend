package br.com.pi.sebovirtual.dto;

import br.com.pi.sebovirtual.entities.PessoaFisica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisicaDTO {
	private PessoaFisica usuario;
	private String token;
}
