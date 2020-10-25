package br.com.pi.sebovirtual.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Usuario")
@NoArgsConstructor 
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Usuario extends BaseEntity {
	@Column(name = "email")
	@Email(message = "Email incorreto")
	@NotNull(message="Email é obrigatório")
	private String email;
	
	@Column(name = "senha")
	@NotNull(message="Senha é obrigatória")
	private String senha;
	
	@Column(name = "habilitado")
	@JsonIgnore
	private Boolean habilitado;
	
	@Column(name = "autoridade")
	@JsonIgnore
	private String autoridade;
	
	// Sobrescreve o setter setSenha para salvar a senha
	// Criptografada
	public void setSenha(String senha) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		this.senha = passwordEncoder.encode(senha);
	}

}
