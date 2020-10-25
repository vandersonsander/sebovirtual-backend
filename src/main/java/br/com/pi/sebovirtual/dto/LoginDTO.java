package br.com.pi.sebovirtual.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginDTO {
	@Email(message = "Email incorreto")
	@NotNull(message = "Email é obrigatório")
	private String email;
	
	@NotNull(message = "Senha é obrigatória")
	private String senha;
}
