package br.com.pi.sebovirtual.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AlterarSenhaDTO {
	@NotNull(message = "Senha atual é obrigatória")
	private String senhaAtual;
	
	@NotNull(message = "Senha nova é obrigatória")
	private String senhaNova;
}
