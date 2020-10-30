package br.com.pi.sebovirtual.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;

import br.com.pi.sebovirtual.resource.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FaleConosco extends BaseEntity {
	@NotNull
	private String nome;
	
	@NotNull(message = "E-mail é obrigatório")
	private String email;
	
	/*
	@NotNull
	@OneToMany
	@JoinColumn(name = "fk_id_telefone")
	private Telefone telefone;
	*/
	
	@JoinColumn(name = "fk_id_usuario")
	private Usuario usuario;
}
