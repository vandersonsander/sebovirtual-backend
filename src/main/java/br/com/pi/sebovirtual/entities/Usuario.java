package br.com.pi.sebovirtual.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	@JsonIgnore // Campos que não serão mostrados para o usuário
	private transient final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	@JsonIgnore
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
		this.senha = passwordEncoder.encode(senha);
	}

}
