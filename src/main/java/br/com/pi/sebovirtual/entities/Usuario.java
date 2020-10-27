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
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Usuario")
@AllArgsConstructor
@RequiredArgsConstructor
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
	
	// Verifica se a senha está criptografada
	// se a senha não estiver a condição dá false
	// e faz a criptografia
	// O mesmo serve para atualizar a senha se a senha
	// for igual a do banco ele não altera a criptografia
	// caso não seja, ele faz a criptografia
	public void setSenha(String senha, Usuario usuario) {
		if (senha == null) {
			this.senha = usuario.getSenha();
			return;
		}
		if (usuario == null) return;
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (passwordEncoder.matches(senha, usuario.getSenha())) {
			this.senha = usuario.getSenha();
			return;
		}
		this.senha = passwordEncoder.encode(senha);
	}

}
