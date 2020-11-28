package br.com.pi.sebovirtual.dto;

import br.com.pi.sebovirtual.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponseDTO {
	private Integer id;
	private Usuario usuario;
	private String email;
	private String token;
}
